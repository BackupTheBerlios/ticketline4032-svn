/*
 * This class provides methods to ease the login process and associated 
 * tasks.
 */

package ticketline.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.db.Kunde;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 * This class provides methods to ease the login process and associated 
 * tasks.
 * 
 * @author Michael Morak
 */
public final class SystemHelper 
{
    private static final Logger log = LogManager.getLogger(SystemHelper.class);
    
    private SystemHelper() { } 
    
    public static Kunde checkLogin(Integer kartennr, String onlinepwd)  throws TicketLineException, TicketLineSystemException
    {
        try
        {
            Kunde kunde = DAOFactory.getKundeDAO().get(kartennr);

            if(onlinepwd != null && onlinepwd.equals(kunde.getOnlinepwd()))
            {
                log.info("Customer " + kartennr + " successfully logged in!");
                return kunde;
            }
            else
            {
                log.warn("Customer " + kartennr + " failed to log in (wrong password)!");
                return null;
            }
        }
        catch(RuntimeException e)
        {
            log.error("Error during database access!", e);
            throw new TicketLineSystemException("Error during database access!", e);
        }
        catch(Exception e)
        {
            log.error("General error!", e);
            throw new TicketLineSystemException("General error!", e);
        }
    }
    
    public static String validateInput(String input)
    {
        return input.replace("'", "\\'");
    }
}
