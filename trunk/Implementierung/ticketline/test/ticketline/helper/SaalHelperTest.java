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

    String bezeichnung;
    String typ;
    Integer plaetzeMin;
    OrtKey ort;
    String query;
    List explist;
        
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
        bezeichnung = "";
        typ = "";
        plaetzeMin = null;
        ort = null;
        query = "";
        explist=null;
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
        bezeichnung = "Halle 1";
        typ = "";
        plaetzeMin = null;
        ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        query = "bezeichnung like '%" + bezeichnung + "%' ";
        explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    @Test
    public void sucheSaeleBezF() throws Exception {
        System.out.println("sucheSaele");
        bezeichnung = "2XYK23äi+#<sß?2^1,.";
        typ = "";
        plaetzeMin = null;
        ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        query = "bezeichnung like '%" + bezeichnung + "%' ";
        explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    
    
    @Test
    public void sucheSaeleTypF() throws Exception {
        System.out.println("suche Saele nach Typ");
        bezeichnung = "";
        typ = "1";
        plaetzeMin = null;
        ort = null;
        SaalDAO dao=DAOFactory.getSaalDAO();
        query = "typ like '%" + typ + "%' ";
        explist = dao.find(query);
        List<Saal> result = SaalHelper.sucheSaele(bezeichnung, typ, plaetzeMin, ort);
        assertEquals(explist, result);
        
    }
    @Test
    public void sucheSaelePlaetzeMinT() throws Exception {
        System.out.println("suche Saele nach mindestplaetze");
        bezeichnung = "";
        typ = "";
        plaetzeMin = new Integer(10);
        ort = new OrtKey();
        SaalDAO dao=DAOFactory.getSaalDAO();
        query = "anzplaetze like '%" + plaetzeMin + "%' ";
        explist = dao.find(query);
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