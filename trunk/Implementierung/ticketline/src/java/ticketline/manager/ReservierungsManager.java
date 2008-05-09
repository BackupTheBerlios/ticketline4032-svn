/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.db.Auffuehrung;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Belegung;
import ticketline.db.BelegungKey;
import ticketline.db.Bestellung;
import ticketline.db.Kategorie;
import ticketline.db.Kunde;
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
public class ReservierungsManager 
{
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
    
    public static Integer kaufeTickets(Kunde k, Date zeit, ReiheKey reihe, BigDecimal preis, Integer startplatz, 
                                Integer anzahl, String zahlart, boolean reservierung) throws TicketLineException, TicketLineSystemException
    {
        return -1;
    }
    
    public static void storniereReservierung(TransaktionKey reservierung) throws TicketLineException, TicketLineSystemException
    {
    }
}
