/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.KategorieDAO;
import ticketline.dao.interfaces.ReiheDAO;
import ticketline.dao.interfaces.SaalDAO;
import ticketline.db.Kategorie;
import ticketline.db.KategorieKey;
import ticketline.db.OrtKey;
import ticketline.db.Reihe;
import ticketline.db.Saal;
import ticketline.db.SaalKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak, Matthias Kausl
 */
public class SaalHelper 
{
    /**
     * Test only
     * @param args
     */
    public static void main(String args[]){
        try {
            List<Saal> l=SaalHelper.sucheSaele(null, "Saal", null, null);
            Saal s=l.iterator().next();
            List<Kategorie> l2=SaalHelper.sucheKategorien(s.getComp_id());
            SaalHelper.sucheReihen(l2.iterator().next().getComp_id());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SaalHelper.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private static final Logger log = LogManager.getLogger(SaalHelper.class);
    
    private SaalHelper() { }
    
    public static List<Saal> sucheSaele(String bezeichnung, String typ, Integer plaetzeMin,
                                    OrtKey ort) throws TicketLineException, TicketLineSystemException
    {
       SaalDAO dao=DAOFactory.getSaalDAO();
       String query = "1 = 1 ";
       bezeichnung=SystemHelper.validateInput(bezeichnung);
       typ=SystemHelper.validateInput(typ);
       
       
       if(bezeichnung != null){
           query+=  "AND bezeichnung like '%" + bezeichnung + "%' ";
       }
       if(typ != null){
           query+=  "AND typ like '%" + typ + "%' ";
       }
       if(plaetzeMin != null){
           query+=  "AND anzplaetze > " +plaetzeMin + " ";
       }
       if(ort != null){
           query+=  "AND ort like '% " +ort.getOrt() + "%' ";
       }
        List list = dao.find(query);
        
        log.info(query); 
        log.info(list);
        return list;
    }
    
    public static List<Kategorie> sucheKategorien(SaalKey saal) throws TicketLineException, TicketLineSystemException
    {
        KategorieDAO dao=DAOFactory.getKategorieDAO();
       String query = "1 = 1 ";
       if(saal!=null){
           query+=  "AND saalbez = '" + saal.getBezeichnung() + "' ";
           query+=  "AND ortbez = '" + saal.getOrtbez() + "' ";
           query+=  "AND ort = '" + saal.getOrt() + "' ";
           
       }else{
           return null;
       }
           
        
        List list = dao.find(query);
        
        log.info(query); 
        log.info(list);
        return list;
    }
    
    public static List<Reihe> sucheReihen(KategorieKey key) throws TicketLineException, TicketLineSystemException
    {
       ReiheDAO dao=DAOFactory.getReiheDAO();
       String query = "1 = 1 ";
       if(key!=null){
           query+=  "AND kategoriebez = '" + key.getBezeichnung() + "' ";
           query+=  "AND saalbez = '" + key.getSaalbez()+ "' ";
           query+=  "AND ortbez = '" + key.getOrtbez()+ "' ";
           query+=  "AND ort = '" + key.getOrt()+ "' ";

           
       }else{
           return null;
       }
        
               List list = dao.find(query);
        
        log.info(query); 
        log.info(list);
        return list;
    }
    
        public static List<Reihe> sucheAlleReihen(SaalKey key) throws TicketLineException, TicketLineSystemException
    {
       ReiheDAO dao=DAOFactory.getReiheDAO();
      
       String query = "1 = 1 ";
       if(key!=null){
           query+=  "AND saalbez = '" + key.getBezeichnung()+ "' ";
           query+=  "AND ortbez = '" + key.getOrtbez()+ "' ";
           query+=  "AND ort = '" + key.getOrt()+ "' order by kategoriebez,bezeichnung "; 

           
       }else{
           return null;
       }
        
               List list = dao.find(query);
        
        log.info(query); 
        log.info(list);
        return list;
    }
}
