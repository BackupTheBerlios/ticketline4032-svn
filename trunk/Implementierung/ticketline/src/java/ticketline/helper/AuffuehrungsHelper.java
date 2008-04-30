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
import ticketline.dao.hibernate.AuffuehrungDAOHibernate;
import ticketline.dao.interfaces.AuffuehrungDAO;
import ticketline.dao.interfaces.KuenstlerDAO;
import ticketline.dao.interfaces.VeranstaltungDAO;
import ticketline.db.Auffuehrung;
import ticketline.db.Kuenstler;
import ticketline.db.SaalKey;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Dominik Kontner
 */
public class AuffuehrungsHelper 
{
    private static final Logger log = LogManager.getLogger(AuffuehrungsHelper.class);
    
    private AuffuehrungsHelper() { }
    
    public static List<Kuenstler> sucheKuenstler(String vorname, String nachname, Boolean maennlich) 
            throws TicketLineException, TicketLineSystemException
    {
        KuenstlerDAO kuenstler = DAOFactory.getKuenstlerDAO();
        
        String query = "1 = 1 ";
        
        if (vorname != null) query +=           "AND vname like '%" + vorname + "%' ";
        if (nachname != null) query +=          "AND nname like '%" + nachname + "%' ";
        if (maennlich != null) query +=         "AND geschlecht = '" + (maennlich ? "M" : "W") + "' ";
    
        List list = kuenstler.find(query);
        
        log.info("KÜNSTLER" + query); 
        log.info(list);
        
        return list;
    }
    
    public static List<Veranstaltung> sucheVeranstaltungen(String bezeichnung, String kategorie,
                                                    Integer dauerMin, Integer dauerMax, String inhalt) 
                                                    throws TicketLineException, TicketLineSystemException
    {
        VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        String query = "1=1 ";
        
        if (bezeichnung != null) query +=                   "OR bezeichnung like '%" + bezeichnung + "%' ";
        if (kategorie != null) query +=                     "OR kategorie like '%" + kategorie + "%' ";
        if (inhalt != null) query +=                        "OR inhalt like '%" + inhalt + "%' ";
        if (dauerMin != null && dauerMax != null) query +=  "AND dauer BETWEEN '" + dauerMin + "' AND '" + dauerMax + "' ";
         
        List list = veranstaltung.find(query);
        
        log.info("das andere" + query); 
        log.info(list);
        return list;
    }
    
    public static List<Auffuehrung> sucheAuffuehrungen(Date zeitVon, Date zeitBis, Boolean storniert, Integer preisMin, Integer preisMax,
                                                VeranstaltungKey veranstaltung, SaalKey saal) throws TicketLineException, TicketLineSystemException
    {
       
       String veranstaltungBezeichnung  = veranstaltung.getBezeichnung();
       String veranstaltungKategorie = veranstaltung.getKategorie() ;
        
       String saalBezeichnung =             null;
       String saalOrt =                     null;
       String saalOrtBezeichnung =          null;
       
       java.sql.Date sqlZeitVon = null;
       java.sql.Date sqlZeitBis = null;
        
       AuffuehrungDAO auffuehrung = DAOFactory.getAuffuehrungDAO();
       
       String query = " 1=1 ";
       log.error("trööööt");
       if (veranstaltung != null) {
           
           veranstaltungBezeichnung  = veranstaltung.getBezeichnung();
           veranstaltungKategorie = veranstaltung.getKategorie() ;
       }
       
       if (saal != null){
       saalBezeichnung =             saal.getBezeichnung();     
       saalOrt =                     saal.getOrt();
       saalOrtBezeichnung =          saal.getOrtbez();
       }
       
       if (zeitVon != null && zeitBis != null){
       sqlZeitVon = java.sql.Date.valueOf(zeitVon.toString());
       sqlZeitBis = java.sql.Date.valueOf(zeitBis.toString());
       }
       
       log.info(sqlZeitVon.toString());
       
       if (zeitVon != null && zeitBis != null) query +=         "AND datumuhrzeit BETWEEN '" + sqlZeitVon.toString() + "' AND '" + sqlZeitBis.toString() + "' ";
       if (storniert != null) query +=                          "AND storniert = '" + storniert + "' ";
       if (preisMin != null && preisMax != null) query +=       "AND preis BETWEEN '" + preisMin + "' AND '" + preisMax + "' ";
       
       if (veranstaltungBezeichnung != null) query +=           "OR bezeichnung like %'" + veranstaltungBezeichnung + "'% ";
       if (veranstaltungKategorie != null) query +=             "OR kategorie like %'" + veranstaltungKategorie + "'% ";
       if (saalBezeichnung != null) query +=                    "OR bezeichnung like %'" + saalBezeichnung + "'% ";
       if (saalOrtBezeichnung != null) query +=                 "OR ortbez like %'" + saalOrtBezeichnung + "'% ";
       if (saalOrt != null) query +=                            "OR ort like %'" + saalOrt + "'% ";
       
       
       List list = auffuehrung.find(query);
       
       log.info("das ganz ganz ganz ganz andere " + query); 
       log.info(list);
       return list;
    }
}
/*
 try{
        ticketline.helper.AuffuehrungsHelper.sucheKuenstler("e", "e", false);
        }catch(Exception ex){
            
        }

        try{
         ticketline.helper.AuffuehrungsHelper.sucheVeranstaltungen("ee", "e", 0, 200, "");
        }catch(Exception ex){
            
        }
        
       
        try{
            
        //AuffuehrungsHelper.sucheAuffuehrungen(zeitVon, zeitBis, storniert, preisMin, preisMax, veranstaltung, saal);
        ticketline.helper.AuffuehrungsHelper.sucheAuffuehrungen(null, null, false, 0, 300, null, null);
        
        
        }catch(Exception ex){
            
        }

*/
