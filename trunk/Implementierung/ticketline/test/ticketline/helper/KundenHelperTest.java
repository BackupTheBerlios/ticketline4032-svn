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
import ticketline.db.News;

/**
 *
 * @author Andreas Weißenbacher
 */
public class KundenHelperTest {

    public KundenHelperTest() {
    }

    String query;
    String inhalt;
    Date gueltig;

    @Before
    public void setUp() {
        
        query = null;
        inhalt = null;
        gueltig = null;
        
    }

    @After
    public void tearDown() {
        
        query = null;
        inhalt = null;
        gueltig = null;
        
    }

    /**
     * Test of sucheNews method, of class KundenHelper.
     */
    @Test
    public void sucheNewsAll() throws Exception {
        System.out.println("suche nach allen News");
        query = "1 = 1 ORDER BY gueltig DESC";
        NewsDAO dao = DAOFactory.getNewsDAO();
        List<News> expResult = dao.find(query);
        List<News> result = KundenHelper.sucheNews(inhalt, gueltig);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void sucheNewsInhalt() throws Exception {
        System.out.println("suche nach allen News mit folgendem Inhalt");
        inhalt = "Test 2";
        query = "inhalt like '" + inhalt + "'"; 
        NewsDAO dao = DAOFactory.getNewsDAO();
        List<News> expResult = dao.find(query);
        List<News> result = KundenHelper.sucheNews(inhalt, gueltig);
        assertEquals(expResult, result);
       
    }
    
}