/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ticketline.dao.interfaces.ArtikelDAO;
import ticketline.dao.interfaces.AuffuehrungDAO;
import ticketline.dao.interfaces.BelegungDAO;
import ticketline.dao.interfaces.BestellungDAO;
import ticketline.dao.interfaces.EngagementDAO;
import ticketline.dao.interfaces.KategorieDAO;
import ticketline.dao.interfaces.KuenstlerDAO;
import ticketline.dao.interfaces.KundeDAO;
import ticketline.dao.interfaces.MitarbeiterDAO;
import ticketline.dao.interfaces.NewsDAO;
import ticketline.dao.interfaces.OrtDAO;
import ticketline.dao.interfaces.ReiheDAO;
import ticketline.dao.interfaces.SaalDAO;
import ticketline.dao.interfaces.TicketcardDAO;
import ticketline.dao.interfaces.TransaktionDAO;
import ticketline.dao.interfaces.VeranstaltungDAO;
import ticketline.db.Ort;
import ticketline.db.Saal;

/**
 *
 * @author Rene
 */
public class DAOFactoryTest {
    NewsDAO newsDAO;
    String query;
    String bezeichnung;
    String bundesland;
    
    public DAOFactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        newsDAO = DAOFactory.getNewsDAO();
        bezeichnung = "";
        query = "";
        bundesland="";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSaalDAO method, of class DAOFactory.
     */
    @Test
    public void DAOumlaute() {
        System.out.println("auf Umlaute überprüfen bei der Suche nach Ort in der Datenbank");
        OrtDAO ortDAO = DAOFactory.getOrtDAO();
        bundesland = "Niederösterreich";
        query = "bezeichnung like '%" + bundesland + "%'";
        List<Ort> resultKlein = ortDAO.find(query);
        bundesland = "Niederoesterreich";
        query = "bezeichnung like '%" + bundesland + "%'";
        List<Ort> resultGross = ortDAO.find(query);
        assertEquals(resultKlein, resultGross);
        
    }
    @Test
    public void DAOKleinGross() {
        System.out.println("Klein - gross schreibung überprüfen bei der Suche in der Datenbank");
        SaalDAO saalDAO = DAOFactory.getSaalDAO();
        bezeichnung = "Halle 1";
        query = "bezeichnung like '%" + bezeichnung + "%'";
        List<Saal> resultKlein = saalDAO.find(query);
        bezeichnung = "halle 1";
        query = "bezeichnung like '%" + bezeichnung + "%'";
        List<Saal> resultGross = saalDAO.find(query);
        assertEquals(resultKlein, resultGross);
        
    }
    @Test
    public void DAOHochkomma() {
        System.out.println("überprüfen bei der Suche Hochkomma zu einem Problem führt");
        SaalDAO saalDAO = DAOFactory.getSaalDAO();
        bezeichnung = "'Halle 1'";
        query = "bezeichnung like '%" + bezeichnung + "%'";
        List<Saal> resultKlein = saalDAO.find(query);
        bezeichnung = "'Halle 1'";
        query = "bezeichnung like '%" + bezeichnung + "%'";
        List<Saal> resultGross = saalDAO.find(query);
        assertEquals(resultKlein, resultGross);
        
    }

    

}