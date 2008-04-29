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
    
    public static List<Kuenstler> sucheKuenstler(String vorname, String nachname, boolean maennlich) 
            throws TicketLineException, TicketLineSystemException
    {
        KuenstlerDAO kuenstler = DAOFactory.getKuenstlerDAO();
        
        String query = "1 = 1 ";
        
        if (vorname != null) query += "AND vname = '" + vorname + "'";
        if (nachname != null) query += "AND nname = '" + nachname + "'";
        if (maennlich != false) query += "AND geschlecht = '" + maennlich + "'";
    
        List list = kuenstler.find(query);
        log.info(list);
        
        return list;
    }
    
    public static List<Veranstaltung> sucheVeranstaltungen(String bezeichnung, String kategorie,
                                                    Integer dauerMin, Integer dauerMax, String inhalt) 
                                                    throws TicketLineException, TicketLineSystemException
    {
         VeranstaltungDAO veranstaltung = DAOFactory.getVeranstaltungDAO();
        
        String query = "1=1";
        
        if (bezeichnung != null) query += "AND bezeichnung = '" + bezeichnung + "'";
        if (kategorie != null) query += "AND kategorie = '" + kategorie + "'";
        if (inhalt != null) query += "AND inhalt = '" + inhalt + "'";
        if (dauerMin != null && dauerMax != null) query += "AND dauer BETWEEN '" + dauerMin + "' AND '" + dauerMax + "'";
         
        List list = veranstaltung.find(query);
        
        log.info(list);
        return list;
    }
    
    public static List<Auffuehrung> sucheAuffuehrungen(Date zeitVon, Date zeitBis, boolean storniert, Integer preisMin, Integer preisMax,
                                                VeranstaltungKey veranstaltung, SaalKey saal) throws TicketLineException, TicketLineSystemException
    {
        AuffuehrungDAO auffuehrung = DAOFactory.getAuffuehrungDAO();
        
       
        
       // List list = auffuehrung.find("date BETWEEN '" + zeitVon + "' AND '" + zeitBis + "' AND storniert = " + storniert + "' AND preis BETWEEN '"
       //         + preisMin + "' AND '" + preisMax + "' AND ");
        
      //  alter table auffuehrung add constraint FK66B638A019C5BD90 foreign key (saalbez, ortbez, ort) references saal;
      //  alter table auffuehrung add constraint FK66B638A099F20D47 foreign key (veranstbez, veranstkat) references veranstaltung;
        
       // log.info(list);
        return null;
    }
}
