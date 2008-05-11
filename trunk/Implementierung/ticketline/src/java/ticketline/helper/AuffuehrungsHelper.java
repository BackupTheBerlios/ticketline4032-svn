/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.Date;

import java.util.List;
import java.util.Vector;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.AuffuehrungDAO;
import ticketline.dao.interfaces.KuenstlerDAO;
import ticketline.dao.interfaces.VeranstaltungDAO;
import ticketline.db.Auffuehrung;
import ticketline.db.Engagement;
import ticketline.db.Kuenstler;
import ticketline.db.Ort;
import ticketline.db.Saal;
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
        try{
        KuenstlerDAO kuenstler = DAOFactory.getKuenstlerDAO();
        
        String query = "1 = 1 ";
        
        if (vorname != null) query +=           "AND LOWER(vname) like '%" + SystemHelper.validateInput(vorname) + "%' ";
        if (nachname != null) query +=          "AND LOWER(nname) like '%" + SystemHelper.validateInput(nachname) + "%' ";
        if (maennlich != null) query +=         "AND geschlecht = '" + (maennlich ? "M" : "W") + "' ";
    
        List list = kuenstler.find(query);
        
        log.info("Executing: " + query);
        
        return list;
        
        }catch(RuntimeException e)
        {
            throw new TicketLineSystemException("Error during database access!", e);
        }
    }
    
    public static List<Veranstaltung> getVeranstaltungenVonKuenstler(Kuenstler k) 
    {
        List<Veranstaltung> list = new Vector<Veranstaltung>();
        
        Engagement[] engs = (Engagement[]) k.getEngagements().toArray(new Engagement[k.getEngagements().size()]);
        
        for(Engagement e : engs)
            if(!list.contains(e.getVeranstaltung())) list.add(e.getVeranstaltung());
        
        return list;
    }
    
    public static List<Veranstaltung> getVeranstaltungenVonOrt(Ort o)
    {
        List<Veranstaltung> list = new Vector<Veranstaltung>();
        
        Saal[] saele = (Saal[]) o.getSaele().toArray(new Saal[o.getSaele().size()]);
        
        for(Saal s : saele)
        {
            Auffuehrung[] aufgen = (Auffuehrung[]) s.getAuffuehrungen().toArray(new Auffuehrung[s.getAuffuehrungen().size()]);
            
            for(Auffuehrung a : aufgen)
                if(!list.contains(a.getVeranstaltung())) list.add(a.getVeranstaltung());
        }
        
        return list;
    }
    
    public static List<Veranstaltung> sucheVeranstaltungen(String bezeichnung, String kategorie,
                                                    Integer dauerMin, Integer dauerMax, String inhalt) 
                                                    throws TicketLineException, TicketLineSystemException
    {
        try{
        VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        String query = "1=1 ";
        
        if (bezeichnung != null) query +=                   "AND LOWER(bezeichnung) like '%" + SystemHelper.validateInput(bezeichnung) + "%' ";
        if (kategorie != null) query +=                     "AND LOWER(kategorie) like '%" + SystemHelper.validateInput(kategorie) + "%' ";
        if (inhalt != null) query +=                        "AND LOWER(inhalt) like '%" + SystemHelper.validateInput(inhalt) + "%' ";
        if (dauerMin.toString() != null && dauerMax.toString() != null) query +=  "AND dauer BETWEEN '" + SystemHelper.validateInput(dauerMin.toString()) + "' AND '" + SystemHelper.validateInput(dauerMax.toString()) + "' ";
        if (dauerMin != null && !(dauerMax != null)) query +=   "AND dauer > '" + SystemHelper.validateInput(dauerMin.toString()) + "' ";
        if (!(dauerMin != null) && dauerMax != null) query +=   "AND dauer < '" + SystemHelper.validateInput(dauerMax.toString()) + "' ";
         
        List list = veranstaltung.find(query);
        
        log.info("Executing: " + query);
        
        return list;
        
        }catch(RuntimeException e)
        {
            throw new TicketLineSystemException("Error during database access!", e);
        }
        
    }
    
 
    public static List<Auffuehrung> sucheAuffuehrungen(Date zeitVon, Date zeitBis, Boolean storniert, Integer preisMin, Integer preisMax,
                                                VeranstaltungKey veranstaltung, SaalKey saal) throws TicketLineException, TicketLineSystemException
    {
      try{
       String veranstaltungBezeichnung  = null;
       String veranstaltungKategorie = null;
      
       String saalBezeichnung =             null;
       String saalOrt =                     null;
       String saalOrtBezeichnung =          null;
      
       java.sql.Date sqlZeitVon = null;
       java.sql.Date sqlZeitBis = null;
        
       AuffuehrungDAO auffuehrung = DAOFactory.getAuffuehrungDAO();
       
       String query = " 1=1 ";
      
       if (veranstaltung != null) {
           
           veranstaltungBezeichnung  = veranstaltung.getBezeichnung();
           veranstaltungKategorie = veranstaltung.getKategorie() ;
       }
      
       if (saal != null){
           saalBezeichnung =             saal.getBezeichnung();     
           saalOrt =                     saal.getOrt();
           saalOrtBezeichnung =          saal.getOrtbez();
       }
      
       if (zeitVon != null){
           sqlZeitVon = java.sql.Date.valueOf(zeitVon.toString());
       }
       
       if (zeitBis != null){
           sqlZeitBis = java.sql.Date.valueOf(zeitBis.toString());
       }
       
       
       
       if (zeitVon != null && zeitBis != null) query +=         "AND datumuhrzeit BETWEEN '" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' AND '" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
       if (zeitVon != null && !(zeitBis != null)) query +=      "AND datumuhrzeit >'" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' ";
       if (!(zeitVon != null) && zeitBis != null) query +=      "AND datumuhrzeit <'" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
       
       
       if (storniert != null) query +=                          "AND storniert = '" + storniert + "' ";
       if (preisMin != null && preisMax != null) query +=       "AND preis BETWEEN '" + SystemHelper.validateInput(preisMin.toString()) + "' AND '" + SystemHelper.validateInput(preisMax.toString()) + "' ";
       
       if (preisMin != null && !(preisMax != null)) query +=    "AND preis > '" + SystemHelper.validateInput(preisMin.toString()) + "' ";
       if (!(preisMin != null) && preisMax != null) query +=    "AND preis < '" + SystemHelper.validateInput(preisMax.toString()) + "' ";
      
       if (veranstaltungBezeichnung != null) query +=           "AND LOWER(veranstbez) like '%" + SystemHelper.validateInput(veranstaltungBezeichnung) + "%' ";
       if (veranstaltungKategorie != null) query +=             "AND LOWER(veranstkat) like '%" + SystemHelper.validateInput(veranstaltungKategorie) + "%' ";
       if (saalBezeichnung != null) query +=                    "AND LOWER(saalbez) like '%" + SystemHelper.validateInput(saalBezeichnung) + "%' ";
       if (saalOrtBezeichnung != null) query +=                 "AND LOWER(ortbez) like '%" + SystemHelper.validateInput(saalOrtBezeichnung) + "%' ";
       if (saalOrt != null) query +=                            "AND LOWER(ort) like '%" + SystemHelper.validateInput(saalOrt) + "%' ";
      
       
       List list = auffuehrung.find(query);
       
       log.info("Executing: " + query); 
       
       return list;
       
      }catch(RuntimeException e)
        {
            throw new TicketLineSystemException("Error during database access!", e);
        }
    }
}