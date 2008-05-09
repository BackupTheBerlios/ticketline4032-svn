/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.util.Date;
import java.util.List;
import ticketline.db.Bestellung;
import ticketline.db.Kunde;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Not Needed
 */
public class ReservierungsManagerTemp {
    public static List<Transaktion> sucheReservierungen(Kunde k, Date zeitVon, Date zeitBis, String reihenBezeichnung, 
                                                    String kategorieBezeichnung, String saalBezeichnung,
                                                    String ortsBezeichnung, String ort) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static void kaufeWerbematerial(Kunde k, Bestellung bestellung) throws TicketLineException, TicketLineSystemException
    {   
    }
    
    public static void kaufeReservierung(TransaktionKey transaktion) throws TicketLineException, TicketLineSystemException
    {
    }
}
