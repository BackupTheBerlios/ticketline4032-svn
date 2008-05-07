/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.OrtDAO;
import ticketline.db.Ort;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak, Christoph Auernig
 */
public class OrtHelper 
{    
    private static final Logger log = LogManager.getLogger(OrtHelper.class);
    
    private OrtHelper() { }
    
    public static List<Ort> sucheOrte(String bezeichnung, String strasse, String ort,
                                String bundesland, String plz, Boolean verkauf,
                                Boolean auffuehrung, Boolean kiosk) throws TicketLineException, TicketLineSystemException
    {
        OrtDAO ortdao = DAOFactory.getOrtDAO();
        
        String query = "1 = 1 ";
        
       if(bezeichnung != null){
           query +=  "AND bezeichnung like '%" + SystemHelper.validateInput(bezeichnung) + "%' ";
       }
       if(strasse != null){
           query +=  "AND strasse like '%" + SystemHelper.validateInput(strasse) + "%' ";
       }
       if(ort != null){
           query +=  "AND ort like '%" + SystemHelper.validateInput(ort) + "%' ";
       }
       if(bundesland != null){
           query +=  "AND bundesland like '%" + SystemHelper.validateInput(bundesland) + "%' ";
       }
       if(plz != null){
           query +=  "AND plz like '%" + SystemHelper.validateInput(plz) + "%' ";
       }
       if(verkauf != null){
           query +=  "AND verkaufsstelle is " + verkauf + " ";
       }
       if(auffuehrung != null){
           query +=  "AND auffuehrungsort is " + auffuehrung + " ";
       }
       if(kiosk != null){
           query +=  "AND kiosk is " + kiosk + " ";
       }
       
        log.info(query);
        
        try {
            List list = ortdao.find(query);
            log.info(list);
            return list;
        } catch (RuntimeException ex) {
            throw new TicketLineSystemException("Datenbankfehler");
        }
    }
            
        
        
}

/*
folgenden Test positiv ausgeführt (Einfügen in super.init()-Methode in Mainpage.java):

try {
    OrtHelper.sucheOrte("CENTRAL KINO LINZ", "Kokosnussgasse", "Holzdorf", "Wien", "3082", true, false, true);
} catch (Exception ex) {
    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
}

*/