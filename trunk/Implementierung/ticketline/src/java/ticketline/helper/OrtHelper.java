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
    
    /*
     * @param bezeichnung   Bezeichnung der Location
     * @param strasse   Straßenname
     * @param ort   Ortbezeichnung
     * @param bundesland    Name des Bundeslands
     * @param plz   Postleitzahl
     * @param verkauf   true: Verkaufsstelle
     * @param auffuehrung   true: Auffuehrungsort
     * @param kiosk     true: Kioskstandort
     * 
     * @return Liste der gefundenen Orte
     * 
     * sucht Orte die den übergebenen Parametern übersprechen und gibt eine Liste der gefundenen Orte zurück
     * 
     * @throws TicketLineException, TicketLineSystemException 
     */
    
    public static List<Ort> sucheOrte(String bezeichnung, String strasse, String ort,
                                String bundesland, String plz, Boolean verkauf,
                                Boolean auffuehrung, Boolean kiosk) throws TicketLineException, TicketLineSystemException
    {
        OrtDAO ortdao = DAOFactory.getOrtDAO();
        
        String query = "1 = 1 ";
        
       if(bezeichnung != null){
           query +=  "AND LOWER(bezeichnung) like '%" + SystemHelper.validateInput(bezeichnung) + "%' ";
       }
       if(strasse != null){
           query +=  "AND LOWER(strasse) like '%" + SystemHelper.validateInput(strasse) + "%' ";
       }
       if(ort != null){
           query +=  "AND LOWER(ort) like '%" + SystemHelper.validateInput(ort) + "%' ";
       }
       if(bundesland != null){
           query +=  "AND LOWER(bundesland) like '%" + SystemHelper.validateInput(bundesland) + "%' ";
       }
       if(plz != null){
           query +=  "AND LOWER(plz) like '%" + SystemHelper.validateInput(plz) + "%' ";
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
            throw new TicketLineSystemException("Datenbankfehler", ex);
        }
    }
            
        
        
}
