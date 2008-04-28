/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.db.Kunde;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak
 */
public class KundenHelper 
{
    private static final Logger log = LogManager.getLogger(KundenHelper.class);
    
    private KundenHelper() { }
    
    public static List<Object> sucheNews(String kategorie, String ort) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static void speichern(Kunde k) throws TicketLineException, TicketLineSystemException
    {
        try
        {
            DAOFactory.getKundeDAO().save(k);
        }
        catch(RuntimeException e)
        {
            throw new TicketLineSystemException("Error during database access!", e);
        }
    }
}
