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
import ticketline.dao.interfaces.AuffuehrungDAO;
import ticketline.dao.interfaces.KuenstlerDAO;
import ticketline.dao.interfaces.VeranstaltungDAO;
import static org.junit.Assert.*;
import ticketline.db.Auffuehrung;
import ticketline.db.Kuenstler;
import ticketline.db.SaalKey;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;

/**
 *
 * @author Andreas Weißenbacher
 */
public class AuffuehrungsHelperTest {

    public AuffuehrungsHelperTest() {
    }
    
    String query;
    String vorname;
    String nachname;
    Boolean maennlich;
    
    String bezeichnung;
    String kategorie;
    Integer dauerMin;
    Integer dauerMax;
    String inhalt;
    
    Date zeitVon;
    Date zeitBis;
    Boolean storniert;
    Integer preisMin;
    Integer preisMax;
    VeranstaltungKey veranstaltung;
    SaalKey saal;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        
        query = null;
        vorname = null;
        nachname = null;
        maennlich = null;
        
        bezeichnung = null;
        kategorie = null;
        dauerMin = null;
        dauerMax = null;
        inhalt = null;
        
        zeitVon = null;
        zeitBis = null;
        storniert = null;
        preisMin = null;
        preisMax = null;
        veranstaltung = null;
        saal = null;
        
    }

    @After
    public void tearDown() {
        
        query = null;
        vorname = null;
        nachname = null;
        maennlich = null;
        
        bezeichnung = null;
        kategorie = null;
        dauerMin = null;
        dauerMax = null;
        inhalt = null;
        
        zeitVon = null;
        zeitBis = null;
        storniert = null;
        preisMin = null;
        preisMax = null;
        veranstaltung = null;
        saal = null;
        
    }

    /**
     * Test of sucheKuenstler method, of class AuffuehrungsHelper.
     */
    @Test
    public void sucheKuenstlerAll() throws Exception {
        System.out.println("suche alle Kuenstler");
        KuenstlerDAO dao = DAOFactory.getKuenstlerDAO();
        List<Kuenstler> expResult = dao.getAll();
        List<Kuenstler> result = AuffuehrungsHelper.sucheKuenstler(vorname, nachname, maennlich);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheKuenstlerFalse() throws Exception {
        System.out.println("Falsche Eingabe");
        vorname = "inznho621736hj";
        query = "vname like '" + vorname + "'";
        KuenstlerDAO dao = DAOFactory.getKuenstlerDAO();
        List<Kuenstler> expResult = dao.find(query);
        List<Kuenstler> result = AuffuehrungsHelper.sucheKuenstler(vorname, nachname, maennlich);
        assertEquals(expResult, result);
    }

    @Test
    public void sucheKuenstler() throws Exception {
        System.out.println("suche bestimmten Künstler");
        vorname = "Matthias";
        nachname = "Händel";
        query = "vname like '" + vorname + "' AND nname like '" + nachname + "'";
        KuenstlerDAO dao = DAOFactory.getKuenstlerDAO();
        List<Kuenstler> expResult = dao.find(query);
        List<Kuenstler> result = AuffuehrungsHelper.sucheKuenstler(vorname, nachname, maennlich);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sucheVeranstaltungen method, of class AuffuehrungsHelper.
     */
    @Test
    public void sucheVeranstaltungen() throws Exception {
        System.out.println("suche nach bestimmter Veranstaltung");
        bezeichnung = "Austria 3 in Concert";
        kategorie = "Tanz";
        dauerMin = 0;
        dauerMax = 100;
        inhalt = "1895, Dr. Alexander Hartdegen ist seiner Zeit weit voraus - im wahrsten Sinne des Wortes. Mit einfachsten Mitteln konstruiert er eine Zeitmachine, die ihn schließlich ins Jahr 802701 katapultiert.";
        query = "bezeichnung like '" + bezeichnung + "' AND kategorie like '" + kategorie + "'";
        VeranstaltungDAO dao = DAOFactory.getVeranstaltungDAO();
        List<Veranstaltung> expResult = dao.find(query);
        List<Veranstaltung> result = AuffuehrungsHelper.sucheVeranstaltungen(bezeichnung, kategorie, dauerMin, dauerMax, inhalt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheVeranstaltungenAll() throws Exception {
        System.out.println("suche alle Veranstaltungen");
        VeranstaltungDAO dao = DAOFactory.getVeranstaltungDAO();
        List<Veranstaltung> expResult = dao.getAll();
        List<Veranstaltung> result = AuffuehrungsHelper.sucheVeranstaltungen(bezeichnung, kategorie, dauerMin, dauerMax, inhalt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheVeranstaltungenFalse() throws Exception {
        System.out.println("Ungültige Eingabe");
        bezeichnung = "gvz";
        kategorie = "gccztz";
        query = "bezeichnung like '" + bezeichnung + "' AND kategorie like '" + kategorie + "'";
        VeranstaltungDAO dao = DAOFactory.getVeranstaltungDAO();
        List<Veranstaltung> expResult = dao.find(query);
        List<Veranstaltung> result = AuffuehrungsHelper.sucheVeranstaltungen(bezeichnung, kategorie, dauerMin, dauerMax, inhalt);
        assertEquals(expResult, result);
    }

    /**
     * Test of sucheAuffuehrungen method, of class AuffuehrungsHelper.
     */
    @Test
    public void sucheAuffuehrungenAll() throws Exception {
        System.out.println("suche alle Auffuehrungen");
        AuffuehrungDAO dao = DAOFactory.getAuffuehrungDAO();
        List<Auffuehrung> expResult = dao.getAll();
        List<Auffuehrung> result = AuffuehrungsHelper.sucheAuffuehrungen(zeitVon, zeitBis, storniert, preisMin, preisMax, veranstaltung, saal);
        assertEquals(expResult, result);
    }
    
     @Test
    public void sucheAuffuehrungenStorniert() throws Exception {
        System.out.println("Suche bestimmte Aufführung die storniert wurden");
        storniert = true;
        AuffuehrungDAO dao = DAOFactory.getAuffuehrungDAO();
        query = "storniert = " + true;
        List<Auffuehrung> expResult = dao.find(query);
        List<Auffuehrung> result = AuffuehrungsHelper.sucheAuffuehrungen(zeitVon, zeitBis, storniert, preisMin, preisMax, veranstaltung, saal);
        assertEquals(expResult, result);
    }

}