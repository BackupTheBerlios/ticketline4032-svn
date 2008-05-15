/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.VeranstaltungDAO;
import ticketline.db.Auffuehrung;
import ticketline.db.Belegung;
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
    
        public static void main(String args[]){
        try {

            VeranstaltungKey key = new VeranstaltungKey("Donald Duck", "Film");
            
            int zahl = berechneBesucherzahl(key);
            
            log.info(zahl);
            
        } catch (Exception ex) {
           
        } 
    }
    
    public static List<Veranstaltung> sucheTopTen() throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static Integer berechneBesucherzahl(VeranstaltungKey veranstaltungKey) throws TicketLineException, TicketLineSystemException
    {
        
        VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        Veranstaltung veranst = veranstaltung.get(veranstaltungKey);
        
        Set auffuehrungSet = veranst.getAuffuehrungen();
        
        Iterator<Auffuehrung> ia = auffuehrungSet.iterator();
        
        Integer belegungGes = null;
        
        while(ia.hasNext()) {
            
            Auffuehrung auffuehrung =  ia.next();
            
            Iterator<Belegung> ib = auffuehrung.getBelegungen().iterator();
            
            while(ib.hasNext()) {
                
                Belegung belegung = ib.next();
                
                belegungGes += belegung.getAnzverk();
                
            }
            
            
        }
        
        return belegungGes;
    }
}
