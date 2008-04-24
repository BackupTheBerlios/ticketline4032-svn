/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Belegung;
import ticketline.db.Bestellung;
import ticketline.db.Kunde;
import ticketline.db.ReiheKey;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;

/**
 *
 * @author Michael Morak
 */
public class ReservierungsManager 
{
    public List<Belegung> sucheBelegungen(AuffuehrungKey auffuehrung)
    {
        return null;
    }
    
    public Integer kaufeTickets(Kunde k, Date zeit, ReiheKey reihe, BigDecimal preis, Integer startplatz, 
                                Integer anzahl, String zahlart, boolean reservierung)
    {
        return -1;
    }
    
    public boolean storniereReservierung(TransaktionKey reservierung)
    {
        return false;
    }
    
    public List<Transaktion> sucheReservierungen(Kunde k, Date zeitVon, Date zeitBis, String reihenBezeichnung, 
                                                    String kategorieBezeichnung, String saalBezeichnung,
                                                    String ortsBezeichnung, String ort)
    {
        return null;
    }
    
    public boolean kaufeReservierung(TransaktionKey transaktion)
    {
        return false;
    }
    
    public boolean kaufeWerbematerial(Kunde k, Bestellung bestellung)
    {
        return false;
    }
}
