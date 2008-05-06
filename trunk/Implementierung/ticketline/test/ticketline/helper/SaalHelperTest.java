/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.SaalDAO;
import static org.junit.Assert.*;
import ticketline.db.Kategorie;
import ticketline.db.KategorieKey;
import ticketline.db.OrtKey;
import ticketline.db.Reihe;
import ticketline.db.Saal;
import ticketline.db.SaalKey;

/**
 *
 * @author Rene
 */
public class SaalHelperTest {

    public SaalHelperTest() {
    }

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
     * Test of main method, of class SaalHelper.
     */
    @Test
    public void main() {
        System.out.println("main");
        String[] args = null;
        SaalHelper.main(args);
    }

    /**
     * Test of sucheSaele method, of class SaalHelper.
     */
    @Test
    public void sucheSaeleBezT() throws Exception {
        System.out.println("sucheSaele");
        String bezeichnung = "Halle 1";
        String typ = "";
        Integer plaetzeMin = null;
        OrtKey ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        String query = "bezeichnung like '%" + bezeichnung + "%' ";
        List explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    @Test
    public void sucheSaeleBezF() throws Exception {
        System.out.println("sucheSaele");
        String bezeichnung = "2XYK23äi+#<sß?2^1,.";
        String typ = "";
        Integer plaetzeMin = null;
        OrtKey ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        String query = "bezeichnung like '%" + bezeichnung + "%' ";
        List explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    
    
    @Test
    public void sucheSaeleTypF() throws Exception {
        System.out.println("suche Saele nach Typ");
        String bezeichnung = "";
        String typ = "1";
        Integer plaetzeMin = null;
        OrtKey ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        String query = "typ like '%" + typ + "%' ";
        List explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    @Test
    public void sucheSaelePlaetzeMinT() throws Exception {
        System.out.println("suche Saele nach mindestplaetze");
        String bezeichnung = "";
        String typ = "";
        Integer plaetzeMin = new Integer(10);
        OrtKey ort = new OrtKey();
        SaalDAO dao=DAOFactory.getSaalDAO();
        String query = "anzplaetze like '%" + plaetzeMin + "%' ";
        List explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }

    /**
     * Test of sucheKategorien method, of class SaalHelper.
     */
    @Test
    public void sucheKategorien() throws Exception {
        System.out.println("sucheKategorien");
        SaalKey saal = null;
        List<Kategorie> expResult = null;
        List<Kategorie> result = SaalHelper.sucheKategorien(saal);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of sucheReihen method, of class SaalHelper.
     */
    @Test
    public void sucheReihen() throws Exception {
        System.out.println("sucheReihen");
        KategorieKey key = null;
        List<Reihe> expResult = null;
        List<Reihe> result = SaalHelper.sucheReihen(key);
        assertEquals(expResult, result);
        
    }

}