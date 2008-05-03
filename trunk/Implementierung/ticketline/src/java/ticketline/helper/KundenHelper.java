/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.NewsDAO;
import ticketline.db.Kunde;
import ticketline.db.News;
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
    
    public static List<News> sucheNews(String inhalt, Date gueltig) throws TicketLineException, TicketLineSystemException
    {
        try
        {
            NewsDAO dao = DAOFactory.getNewsDAO();
            String query = "1 = 1 ";
       
            if(inhalt != null){
                query +=  "AND inhalt like '%" + inhalt + "%' ";
            }
            
            if(gueltig != null){
                query +=  "AND gueltig >= '" + ((java.sql.Date) gueltig).toString() + "' ";
            }

            List list = dao.find(query);

            log.info("Executing: " + query);
            
            return list;
        }
        catch(RuntimeException e)
        {
            throw new TicketLineSystemException("Error during database access!", e);
        }
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
