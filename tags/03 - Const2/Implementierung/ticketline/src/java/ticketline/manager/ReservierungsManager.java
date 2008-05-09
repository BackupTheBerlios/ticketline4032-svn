/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Belegung;
import ticketline.db.Bestellung;
import ticketline.db.Kunde;
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
        return null;
    }
    
    public static Integer kaufeTickets(Kunde k, Date zeit, ReiheKey reihe, BigDecimal preis, Integer startplatz, 
                                Integer anzahl, String zahlart, boolean reservierung) throws TicketLineException, TicketLineSystemException
    {
        return -1;
    }
    
    public static void storniereReservierung(TransaktionKey reservierung) throws TicketLineException, TicketLineSystemException
    {
    }
    
    public static List<Transaktion> sucheReservierungen(Kunde k, Date zeitVon, Date zeitBis, String reihenBezeichnung, 
                                                    String kategorieBezeichnung, String saalBezeichnung,
                                                    String ortsBezeichnung, String ort) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static void kaufeReservierung(TransaktionKey transaktion) throws TicketLineException, TicketLineSystemException
    {
    }
    
    public static void kaufeWerbematerial(Kunde k, Bestellung bestellung) throws TicketLineException, TicketLineSystemException
    {
    }
}
