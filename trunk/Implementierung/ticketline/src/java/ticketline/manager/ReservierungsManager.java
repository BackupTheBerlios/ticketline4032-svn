/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Michael Morak
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
            log.info(kaufeTickets(kunde, date, auffuehrungKey, rk, new BigDecimal(100), 1, 2, "Karte", true));
//TransaktionKey transaktionKey = ((Transaktion)DAOFactory.getTransaktionDAO().getAll().get(1)).getComp_id();
//storniereReservierung(transaktionKey);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReservierungsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private static final Logger log = LogManager.getLogger(ReservierungsManager.class);
    
    private ReservierungsManager() { }
    
    public static List<Belegung> sucheBelegungen(AuffuehrungKey auffuehrung) throws TicketLineException, TicketLineSystemException
    {
        try
        {
            Auffuehrung a = DAOFactory.getAuffuehrungDAO().get(auffuehrung);
            Set bel = a.getBelegungen();
            Set kats = a.getSaal().getKategorien();

            List<Reihe> reihen = new Vector<Reihe>();

            for(Object k : kats)
                for(Object r : ((Kategorie)k).getReihen())
                    reihen.add((Reihe)r);

            for(Object b : bel)
                reihen.remove(((Belegung)b).getReihe());

            for(Reihe r : reihen)
            {
                String belegung = "";
                for(int i = 0; i < r.getAnzplaetze(); ++i)
                    belegung += "F";

                DAOFactory.getBelegungDAO().save(new Belegung(new BelegungKey(r.getComp_id().getBezeichnung(), r.getComp_id().getKategoriebez(), r.getComp_id().getSaalbez(), r.getComp_id().getOrtbez(), r.getComp_id().getOrt(), a.getComp_id().getDatumuhrzeit()), belegung, r.getAnzplaetze(), 0, 0, r, a, new java.util.HashSet()));
            }

            return new Vector<Belegung>(a.getBelegungen());
        }
        catch(Exception e)
        {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }
    
    public static Integer kaufeTickets(Kunde k, Date zeit, AuffuehrungKey auffuehrung, ReiheKey reihe, BigDecimal preis, Integer startplatz,
            Integer anzahl, String zahlart, boolean reservierung) throws TicketLineException, TicketLineSystemException {
        try {
            if (k != null && zeit != null && reihe != null && preis != null && startplatz != null && anzahl != null && zahlart != null) {

                BelegungDAO belegungDAO = DAOFactory.getBelegungDAO();
                BelegungKey belegungKey = new BelegungKey(reihe.getBezeichnung(), reihe.getKategoriebez(), reihe.getSaalbez(), reihe.getOrtbez(), reihe.getOrt(), auffuehrung.getDatumuhrzeit());
                Belegung belegung = belegungDAO.get(belegungKey);

                OrtDAO ortDAO = DAOFactory.getOrtDAO();
                OrtKey ortKey = new OrtKey(reihe.getOrtbez(), reihe.getOrt());
                Ort ort = ortDAO.get(ortKey);

                TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
                TransaktionKey transaktionKey = new TransaktionKey(zeit, k.getKartennr(), 2);

                if (reservierung) {
                    Transaktion transaktion = new Transaktion(transaktionKey, false, false, preis, startplatz, anzahl, belegung, ort);
                    transaktion.setZahlart(zahlart);
                    Session s = HibernateSessionFactory.currentSession();
                    List l = s.createQuery("SELECT COALESCE(MAX(COALESCE(resnr, 0)),0)+1 FROM Transaktion").list();
                    int resnr = Integer.parseInt(l.get(0).toString());
                    transaktion.setResnr(resnr);
                    
                    transaktionDAO.save(transaktion);
                    return transaktionDAO.get(transaktionKey).getResnr();
                } else {
                    Transaktion transaktion = new Transaktion(transaktionKey, true, false, preis, startplatz, anzahl, belegung, ort);
                    transaktion.setZahlart(zahlart);
                    transaktionDAO.save(transaktion);
                    return -1;
                }
            } else {
                return -1;
            }
        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }
    
    public static void storniereReservierung(TransaktionKey reservierung) throws TicketLineException, TicketLineSystemException {
        try {
            if (reservierung != null) {
                TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
                Transaktion transaktion = transaktionDAO.get(reservierung);
                transaktion.setStorniert(true);
                transaktionDAO.save(transaktion);
            } else {
                log.info("Missing entity (transaktionKey)");
            }
        } catch (RuntimeException e) {
            throw new TicketLineSystemException("Fehler!", e);
        }
    }
}
