/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
 * @author Sriver
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
            
            List<Veranstaltung> list = sucheTopTen();
            
            for(int k = 0; k <= 10; k++) {
                
                log.info(list.get(k).toString());
                
            }
            
        } catch (Exception ex) {
           
        } 
    }
    
    public static List<Veranstaltung> sucheTopTen() throws TicketLineException, TicketLineSystemException
    {
       
        VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        List<Veranstaltung> list = veranstaltung.getAll();
        ArrayList<Veranstaltung> gesList = new ArrayList<Veranstaltung>();
        
        
        for(int i = 0; i < list.size(); i++) {
            
            if(i == 0) {
                
                gesList.add(list.get(i));
                
            }
            else {
            
                 for(int j = 0; j < 10; j++) {
                     
                     if(j < gesList.size()) {
                         
                         if(berechneBesucherzahl(list.get(i).getComp_id()) > berechneBesucherzahl(gesList.get(j).getComp_id())) {
                    
                             gesList.add(j, list.get(i));
                            
                             break;
                    
                         }
                         
                     }
                     else {
                         
                         gesList.add(list.get(i));
                         
                         break;
                         
                     }
                
                }
                 
            }
            
            if(gesList.size() > 10) {
                                 
                gesList.remove(10);
                                 
            }
            
        }
        
        return gesList;
    }
    
    public static Integer berechneBesucherzahl(VeranstaltungKey veranstaltungKey) throws TicketLineException, TicketLineSystemException
    {
        
        VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        Veranstaltung veranst = veranstaltung.get(veranstaltungKey);
        
        Set auffuehrungSet = veranst.getAuffuehrungen();
        
        Iterator<Auffuehrung> ia = auffuehrungSet.iterator();
        
        int belegungGes = 0;
        
        while(ia.hasNext()) {
            
            Auffuehrung auffuehrung =  ia.next();
            
            Iterator<Belegung> ib = auffuehrung.getBelegungen().iterator();
            
            while(ib.hasNext()) {
                
                Belegung belegung = ib.next();
                
                belegungGes += belegung.getAnzverk();
                
            }
            
            
        }
        
        return new Integer(belegungGes);
    }
}
