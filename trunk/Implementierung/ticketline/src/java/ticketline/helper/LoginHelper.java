/*
 * This class provides methods to ease the login process and associated 
 * tasks.
 */

package ticketline.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.db.Kunde;

/**
 * This class provides methods to ease the login process and associated 
 * tasks.
 * 
 * @author Michael Morak
 */
public final class LoginHelper 
{
    private static final Logger log = LogManager.getLogger(LoginHelper.class);
    
    private LoginHelper() 
    {
    }
    
    public static Kunde checkLogin(Integer kartennr, String onlinepwd)
    {
        Kunde kunde = DAOFactory.getKundeDAO().get(kartennr);
        
        if(kunde.isSaved() && onlinepwd.equals(kunde.getOnlinepwd()))
        {
            log.info("Customer " + kartennr + " successfully logged in!");
            return kunde;
        }
        
        log.warn("Customer " + kartennr + " failed to log in!");
        return null;
    }
}
