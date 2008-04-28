/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak
 */
public class AuswertungsHelper 
{
    private static final Logger log = LogManager.getLogger(AuswertungsHelper.class);
    
    private AuswertungsHelper() { }
    
    public static List<Veranstaltung> sucheTopTen() throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static Integer berechneBesucherzahl(VeranstaltungKey veranstaltung) throws TicketLineException, TicketLineSystemException
    {
        return -1;
    }
}
