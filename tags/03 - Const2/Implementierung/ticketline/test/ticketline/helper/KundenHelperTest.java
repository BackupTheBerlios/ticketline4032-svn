/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.NewsDAO;
import static org.junit.Assert.*;
import ticketline.db.Kunde;
import ticketline.db.News;

/**
 *
 * @author Sriver
 */
public class KundenHelperTest {

    public KundenHelperTest() {
    }

    String query;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sucheNews method, of class KundenHelper.
     */
    @Test
    public void sucheNewsAll() throws Exception {
        System.out.println("suche nach allen News");
        String inhalt = "";
        Date gueltig = null;
        query = "1 = 1 ORDER BY gueltig DESC";
        NewsDAO dao = DAOFactory.getNewsDAO();
        List<News> expResult = dao.find(query);
        List<News> result = KundenHelper.sucheNews(inhalt, gueltig);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void sucheNewsInhalt() throws Exception {
        System.out.println("suche nach allen News mit folgendem Inhalt");
        String inhalt = "Test 2";
        Date gueltig = null;
        query = "inhalt like '" + inhalt + "'"; 
        NewsDAO dao = DAOFactory.getNewsDAO();
        List<News> expResult = dao.find(query);
        List<News> result = KundenHelper.sucheNews(inhalt, gueltig);
        assertEquals(expResult, result);
       
    }
    
}