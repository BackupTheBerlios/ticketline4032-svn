/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.OrtDAO;
import static org.junit.Assert.*;
import ticketline.db.Ort;

/**
 *
 * @author Rene
 */
public class OrtHelperTest {
    
    private String bezeichnung = "";
    private String strasse = "";
    private String ort = "";
    private String bundesland = "";
    private String plz = "";
    private Boolean verkauf = null;
    private Boolean auffuehrung = null;
    private Boolean kiosk = null;
    private List<Ort> expResult = null;
    OrtDAO ortdao = DAOFactory.getOrtDAO();
    String query="";
    
    public OrtHelperTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    bezeichnung = "";
    strasse = "";
    ort = "";
    bundesland = "";
    plz = "";
    verkauf = null;
    auffuehrung = null;
    kiosk = null;
    expResult = null;
    query = "";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sucheOrte method, of class OrtHelper.
     */
    @Test
    public void sucheOrte() throws Exception {
        System.out.println("suche Orte: all empty");
        query= " 1 = 1";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    @Test
    public void sucheOrteBezT() throws Exception {
        System.out.println("suche Orte: bezeichnung");
        bezeichnung = "Halle 1";
        query = "bezeichnung like '%" + bezeichnung + "%' ";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    

}