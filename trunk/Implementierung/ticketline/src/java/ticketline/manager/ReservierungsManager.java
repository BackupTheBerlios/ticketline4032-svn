package ticketline.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.Set;
import java.util.Vector;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import ticketline.dao.DAOFactory;
import ticketline.dao.hibernate.HibernateSessionFactory;
import ticketline.dao.interfaces.BelegungDAO;
import ticketline.dao.interfaces.BestellungDAO;
import ticketline.dao.interfaces.KundeDAO;
import ticketline.dao.interfaces.OrtDAO;
import ticketline.dao.interfaces.TransaktionDAO;
import ticketline.db.Auffuehrung;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Belegung;
import ticketline.db.BelegungKey;
import ticketline.db.Bestellung;
import ticketline.db.*;
import ticketline.db.Kategorie;
import ticketline.db.Kunde;
import ticketline.db.Ort;
import ticketline.db.OrtKey;
import ticketline.db.Reihe;
import ticketline.db.ReiheKey;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;
import ticketline.helper.SystemHelper;

/**
 *
 * @author Michael Morak, Christoph Auernig, Dominik Kontner
 */
public class ReservierungsManager {

    /**
     * Test only
     * @param args
     */
    public static void main(String args[]) {
        try {
            KundeDAO kundeDAO = DAOFactory.getKundeDAO();
            Kunde kunde = kundeDAO.get(1);
            Date date = new Date();
            Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(1);
            AuffuehrungKey auffuehrungKey = auffuehrung.getComp_id();

            ReiheKey rk = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();
            log.info(kaufeTickets(kunde, date, auffuehrungKey, rk, 3, 4, "Karte", true));
//TransaktionKey transaktionKey = ((Transaktion)DAOFactory.getTransaktionDAO().getAll().get(1)).getComp_id();
//storniereReservierung(transaktionKey);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReservierungsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final Logger log = LogManager.getLogger(ReservierungsManager.class);

    private ReservierungsManager() {
    }

    /*
     * @param auffuehrung AuffuehrungKey Objekt
     * 
     * @return Liste der gefundenen Belegungen
     * 
     * sucht übereinstimmende Belegungen und gibt eine Liste der gefundenen Belegungen zurück
     * 
     * throws TicketLineException, TicketLineSystemException 
     */
    
    public static List<Belegung> sucheBelegungen(AuffuehrungKey auffuehrung) throws TicketLineException, TicketLineSystemException {
        try {
            Auffuehrung a = DAOFactory.getAuffuehrungDAO().get(auffuehrung);
            Set bel = a.getBelegungen();
            Set kats = a.getSaal().getKategorien();

            List<Reihe> reihen = new Vector<Reihe>();

            for (Object k : kats) {
                for (Object r : ((Kategorie) k).getReihen()) {
                    reihen.add((Reihe) r);
                }
            }

            for (Object b : bel) {
                reihen.remove(((Belegung) b).getReihe());
            }

            for (Reihe r : reihen) {
                String belegung = "";
                for (int i = 0; i < r.getAnzplaetze(); ++i) {
                    belegung += "F";
                }

                DAOFactory.getBelegungDAO().save(new Belegung(new BelegungKey(r.getComp_id().getBezeichnung(), r.getComp_id().getKategoriebez(), r.getComp_id().getSaalbez(), r.getComp_id().getOrtbez(), r.getComp_id().getOrt(), a.getComp_id().getDatumuhrzeit()), belegung, r.getAnzplaetze(), 0, 0, r, a, new java.util.HashSet()));
            }

            return sucheAlleBelegungen(auffuehrung);
        } catch (Exception e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }

    /*
     * @param key AuffuehrungKey Objekt
     * 
     * @return Liste der gefundenen Belegungen
     * 
     * sucht übereinstimmende Belegungen und gibt eine Liste der gefundenen Belegungen zurück
     * 
     * throws TicketLineException, TicketLineSystemException 
     */
    
    private static List<Belegung> sucheAlleBelegungen(AuffuehrungKey key) throws TicketLineException, TicketLineSystemException {
        BelegungDAO dao = DAOFactory.getBelegungDAO();

        String query = "1 = 1 ";
        if (key != null) {
            query += "AND saalbez = '" + key.getSaalbez() + "' ";
            query += "AND ortbez = '" + key.getOrtbez() + "' ";
            query += "AND datumuhrzeit = '" + key.getDatumuhrzeit() + "' ";
            query += "AND ort = '" + key.getOrt() + "' order by kategoriebez,reihebez";


        } else {
            return null;
        }

        List list = dao.find(query);

        log.info(query);
        log.info(list);
        return list;
    }

    /*
     * @param k	Kundenobjekt
     * @param zeit  Zeit im Date format
     * @param auffuehrungKey	AufführungsKey Objekt
     * @param reihe     Key der Reihe Objekt
     * @param startplatz    Startplatz im Integer Format
     * @param anzahl	Anzahl der Plätze   
     * @param zahlart	gewählte Zahlart
     * @param reservierung      true für Reservierung, sonst Kauf
     * 
     * @return gibt die Transaktion zurück
     * 
     * Legt eine neue Transaktion (Kauf oder Reservierung) an und gibt diese zurück
     * 
     * throws TicketLineException, TicketLineSystemException 
     */ 
    public static Transaktion kaufeTickets(Kunde k, Date zeit, AuffuehrungKey auffuehrungKey, ReiheKey reihe, Integer startplatz,
            Integer anzahl, String zahlart, boolean reservierung) throws TicketLineException, TicketLineSystemException {
        try {
            if (k != null && zeit != null && reihe != null && startplatz != null && anzahl != null && zahlart != null) {

                BelegungDAO belegungDAO = DAOFactory.getBelegungDAO();
                BelegungKey belegungKey = new BelegungKey(reihe.getBezeichnung(), reihe.getKategoriebez(), reihe.getSaalbez(), reihe.getOrtbez(), reihe.getOrt(), auffuehrungKey.getDatumuhrzeit());
                Belegung belegung = belegungDAO.get(belegungKey);

                OrtDAO ortDAO = DAOFactory.getOrtDAO();
                OrtKey ortKey = new OrtKey(reihe.getOrtbez(), reihe.getOrt());
                Ort ort = ortDAO.get(ortKey);

                TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
                TransaktionKey transaktionKey = new TransaktionKey(zeit, k.getKartennr(), 2);

                Auffuehrung auffuehrung = DAOFactory.getAuffuehrungDAO().get(auffuehrungKey);
                Kategorie kategorie = belegung.getReihe().getKategorie();

                String preisart = auffuehrung.getPreis();
                BigDecimal preis = new BigDecimal(0);

                if (preisart.equals("0")) {
                    preis = kategorie.getPreismin();
                } else if (preisart.equals("1")) {
                    preis = kategorie.getPreisstd();
                } else {
                    preis = kategorie.getPreismax();
                }

                preis = preis.multiply(new BigDecimal(anzahl));

                if (reservierung) {
                    editiereBelegung(belegungKey, startplatz, anzahl, 'R', null);
                    Transaktion transaktion = new Transaktion(transaktionKey, false, false, preis, startplatz, anzahl, belegung, ort);
                    transaktion.setZahlart(zahlart);
                    Session s = HibernateSessionFactory.currentSession();
                    List l = s.createQuery("SELECT COALESCE(MAX(COALESCE(resnr, 0)),0)+1 FROM Transaktion").list();
                    int resnr = Integer.parseInt(l.get(0).toString());
                    transaktion.setResnr(resnr);
                    transaktionDAO.save(transaktion);
                    return transaktion;
                } else {
                    editiereBelegung(belegungKey, startplatz, anzahl, 'V', false);
                    Transaktion transaktion = new Transaktion(transaktionKey, true, false, preis, startplatz, anzahl, belegung, ort);
                    transaktion.setZahlart(zahlart);
                    transaktionDAO.save(transaktion);
                    return transaktion;
                }
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }

     /*
     * @param reservierung Ist der Key der Transaktion (Objekt)
     * 
     * Storniert eine Reservierung - gibt nichts zurück
     * 
     * throws TicketLineException, TicketLineSystemException 
     */
    
    public static void storniereReservierung(TransaktionKey reservierung) throws TicketLineException, TicketLineSystemException {
        try {
            if (reservierung != null) {
                TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
                Transaktion transaktion = transaktionDAO.get(reservierung);
                transaktion.setStorniert(true);
                editiereBelegung(transaktion.getBelegung().getComp_id(), transaktion.getStartplatz(), transaktion.getAnzplaetze(), 'F', null);
                transaktionDAO.save(transaktion);
            } else {
                log.info("Missing entity (transaktionKey)");
            }
        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }

     /*
      * @param  k Kundenobjekt
      * @param  zeitVon	Startzeit
      * @param  zeitBis	Endzeit
      * @param  reihenBezeichnung   Bezeichnung der Reihe
      * @param  kategorieBezeichnung	Bezeichnung der Kategorie
      * @param  saalBezeichnung	Bezeichnung des Saals
      * @param  ortsBezeichnung	Bezeichnung des Ortes
      * @param  ort Ortsobjekt
      * 
      * @return Liste der gefundenen Transaktionen
      * 
      * Sucht anhand der übergebenen Parameter die Reservierungen und gibt eine Liste der Transaktionen zurück
     */
    
    public static List<Transaktion> sucheReservierungen(Kunde k, Date zeitVon, Date zeitBis, String reihenBezeichnung,
            String kategorieBezeichnung, String saalBezeichnung,
            String ortsBezeichnung, String ort) throws TicketLineException, TicketLineSystemException {
        try {
            TransaktionDAO transaktion = DAOFactory.getTransaktionDAO();

            java.sql.Date sqlZeitVon = null;
            java.sql.Date sqlZeitBis = null;

            if (zeitVon != null) {
                sqlZeitVon = new java.sql.Date(zeitVon.getTime());
            }

            if (zeitBis != null) {
                sqlZeitBis = new java.sql.Date(zeitBis.getTime());
            }

            String query = "1=1 AND storniert = FALSE AND verkauft = FALSE ";

            if (k != null) {
                query += "AND LOWER(kundennr) = '" + SystemHelper.validateInput(k.getKartennr().toString()) + "' ";
            }

            if (sqlZeitVon != null && sqlZeitBis != null) {
                query += "AND datumuhrzeit BETWEEN '" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' AND '" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
            }
            if (sqlZeitVon != null && !(sqlZeitBis != null)) {
                query += "AND datumuhrzeit >'" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' ";
            }
            if (!(sqlZeitVon != null) && sqlZeitBis != null) {
                query += "AND datumuhrzeit <'" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
            }


            if (reihenBezeichnung != null) {
                query += "AND LOWER(reihebez) like '%" + SystemHelper.validateInput(reihenBezeichnung) + "%' ";
            }
            if (kategorieBezeichnung != null) {
                query += "AND LOWER(kategoriebez) like '%" + SystemHelper.validateInput(kategorieBezeichnung) + "%' ";
            }
            if (saalBezeichnung != null) {
                query += "AND LOWER(saalbez) like '%" + SystemHelper.validateInput(saalBezeichnung) + "%' ";
            }

            if (ortsBezeichnung != null) {
                query += "AND LOWER(ortbez) like '%" + SystemHelper.validateInput(ortsBezeichnung) + "%' ";
            }

            if (ort != null) {
                query += "AND LOWER(ort.comp_id.ort) like '%" + SystemHelper.validateInput(ort) + "%' ";
            }

            log.info("Executing: " + query);

            List list = transaktion.find(query);

            return list;

        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Error during database access!", e);
        }
    }

    /*
     * @param kunde     Kundenobjekt
     * @param bestellung    Bestellungsobjekt
     * 
     * kauft Werbematerial - gibt nichts zurück
     * 
     * throws TicketLineException, TicketLineSystemException
     */
    
    public static void kaufeWerbematerial(Kunde kunde, Bestellung bestellung) throws TicketLineException, TicketLineSystemException {

        try {
            if (kunde != null && bestellung != null) {
                BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
                bestellung.setKunde(kunde);

                log.info("Executing: " + bestellung);
                bestellungDAO.save(bestellung);
            } else {
                log.info("Missing entity");
            }

        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Error during database access!", e);
        }


    }

        /*
     * @param kunde transaktionKey    TransaktionKey Objekt
     * 
     * kauft Werbematerial - gibt nichts zurück
     * 
     * throws TicketLineException, TicketLineSystemException
     */
    
    public static void kaufeReservierung(TransaktionKey transaktionKey) throws TicketLineException, TicketLineSystemException {

        try {
            if (transaktionKey != null) {

                TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
                Transaktion transaktion = transaktionDAO.get(transaktionKey);

                transaktion.setVerkauft(true);

                editiereBelegung(transaktion.getBelegung().getComp_id(), transaktion.getStartplatz(), transaktion.getAnzplaetze(), 'V', true);

                log.info("Executing: " + transaktion);
                transaktionDAO.save(transaktion);

            } else {
                log.info("Missing entity (transaktionKey)");
            }
        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Error during database access!", e);
        }

    }

    /*
     * @param belegungKey   BelegungKey Objekt
     * @param startplatz    Startplatz im Integer Format
     * @param anzahl	Anzahl der Plätze
     * @param editMode  ein char, das angibt ob ein Platz als frei ('F'), reserviert ('R') oder verkauft ('V') markiert werden soll
     * @param kaufeReservierung     true wenn eine vorhandene Reservierung gekauft werden soll
     * 
     * verändert in einer Belegung den Status der Plätze und je nach Bedarf die Anzahl der verkauften, freien und reservierten Plätze - gibt nichts zurück
     * 
     * throws TicketLineException, TicketLineSystemException
     */
    private static void editiereBelegung(BelegungKey belegungKey, int startplatz, int anzahl, char editMode, Boolean kaufeReservierung) throws TicketLineSystemException {
        try {
            if (editMode == 'F' || editMode == 'R' || editMode == 'V') {
                BelegungDAO belegungDAO = DAOFactory.getBelegungDAO();
                Belegung belegung = belegungDAO.get(belegungKey);

                String plaetze = belegung.getBelegung();
                char[] temp = new char[plaetze.length()];
                plaetze.getChars(0, plaetze.length(), temp, 0);


//                log.info("anzfrei: " + belegung.getAnzfrei());
//                log.info("anzres: " + belegung.getAnzres());
//                log.info("anzverk: " + belegung.getAnzverk());

                if (editMode == 'F') {

                    for (int i = -1; i < anzahl - 1; i++) {
                        if (temp[startplatz + i] == 'R') {
                            temp[startplatz + i] = editMode;
                        } else {
                            throw new TicketLineSystemException("Stornierungsfehler!");
                        }
                    }
//                log.info(plaetze);
                    plaetze = "";

                    for (char c : temp) {
                        plaetze += c;
                    }

                    belegung.setAnzres(belegung.getAnzres() - anzahl);
                    belegung.setAnzfrei(belegung.getAnzfrei() + anzahl);
                }

                if (editMode == 'R') {

                    for (int i = -1; i < anzahl - 1; i++) {
                        if (temp[startplatz + i] == 'F') {
                            temp[startplatz + i] = editMode;
                        } else {
                            throw new TicketLineSystemException("Reservierungsfehler!");
                        }
                    }
//                log.info(plaetze);
                    plaetze = "";

                    for (char c : temp) {
                        plaetze += c;
                    }

                    belegung.setAnzfrei(belegung.getAnzfrei() - anzahl);
                    belegung.setAnzres(belegung.getAnzres() + anzahl);
                }

                if (editMode == 'V') {

                    if (kaufeReservierung) {

                        for (int i = -1; i < anzahl - 1; i++) {
                            if (temp[startplatz + i] == 'R') {
                                temp[startplatz + i] = editMode;
                            } else {
                                throw new TicketLineSystemException("Reservierungskauffehler!");
                            }
                        }
//                log.info(plaetze);
                        plaetze = "";

                        for (char c : temp) {
                            plaetze += c;
                        }

                        belegung.setAnzres(belegung.getAnzres() - anzahl);
                    } else {
                        belegung.setAnzfrei(belegung.getAnzfrei() - anzahl);

                        for (int i = -1; i < anzahl - 1; i++) {
                            if (temp[startplatz + i] == 'F') {
                                temp[startplatz + i] = editMode;
                            } else {
                                throw new TicketLineSystemException("Kauffehler!");
                            }
                        }
//                log.info(plaetze);
                        plaetze = "";

                        for (char c : temp) {
                            plaetze += c;
                        }

                    }
                    belegung.setAnzverk(belegung.getAnzverk() + anzahl);
                }

//                log.info("anzfrei: " + belegung.getAnzfrei());
//                log.info("anzres: " + belegung.getAnzres());
//                log.info("anzverk: " + belegung.getAnzverk());


//                log.info(plaetze);

                belegung.setBelegung(plaetze);
                belegungDAO.save(belegung);

            } else {
                log.info("Falscher editMode!");
            }

        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }
}
