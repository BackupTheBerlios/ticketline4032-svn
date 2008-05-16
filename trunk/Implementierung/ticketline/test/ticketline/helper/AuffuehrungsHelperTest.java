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
 * @author Sriver
 */
public class AuffuehrungsHelperTest {

    public AuffuehrungsHelperTest() {
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
     * Test of sucheKuenstler method, of class AuffuehrungsHelper.
     */
    @Test
    public void sucheKuenstlerAll() throws Exception {
        System.out.println("suche alle Kuenstler");
        String vorname = "";
        String nachname = "";
        Boolean maennlich = null;
        KuenstlerDAO dao = DAOFactory.getKuenstlerDAO();
        List<Kuenstler> expResult = dao.getAll();
        List<Kuenstler> result = AuffuehrungsHelper.sucheKuenstler(vorname, nachname, maennlich);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheKuenstlerFalse() throws Exception {
        System.out.println("Falsche Eingabe");
        String vorname = "inznho621736hj";
        String nachname = "";
        Boolean maennlich = null;
        query = "vname like '" + vorname + "'";
        KuenstlerDAO dao = DAOFactory.getKuenstlerDAO();
        List<Kuenstler> expResult = dao.find(query);
        List<Kuenstler> result = AuffuehrungsHelper.sucheKuenstler(vorname, nachname, maennlich);
        assertEquals(expResult, result);
    }

    @Test
    public void sucheKuenstler() throws Exception {
        System.out.println("suche bestimmten Künstler");
        String vorname = "Matthias";
        String nachname = "Händel";
        Boolean maennlich = null;
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
        String bezeichnung = "Austria 3 in Concert";
        String kategorie = "Tanz";
        Integer dauerMin = 0;
        Integer dauerMax = 100;
        String inhalt = "1895, Dr. Alexander Hartdegen ist seiner Zeit weit voraus - im wahrsten Sinne des Wortes. Mit einfachsten Mitteln konstruiert er eine Zeitmachine, die ihn schließlich ins Jahr 802701 katapultiert.";
        query = "bezeichnung like '" + bezeichnung + "' AND kategorie like '" + kategorie + "'";
        VeranstaltungDAO dao = DAOFactory.getVeranstaltungDAO();
        List<Veranstaltung> expResult = dao.find(query);
        List<Veranstaltung> result = AuffuehrungsHelper.sucheVeranstaltungen(bezeichnung, kategorie, dauerMin, dauerMax, inhalt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheVeranstaltungenAll() throws Exception {
        System.out.println("suche alle Veranstaltungen");
        String bezeichnung = "";
        String kategorie = "";
        Integer dauerMin = null;
        Integer dauerMax = null;
        String inhalt = "";
        VeranstaltungDAO dao = DAOFactory.getVeranstaltungDAO();
        List<Veranstaltung> expResult = dao.getAll();
        List<Veranstaltung> result = AuffuehrungsHelper.sucheVeranstaltungen(bezeichnung, kategorie, dauerMin, dauerMax, inhalt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void sucheVeranstaltungenFalse() throws Exception {
        System.out.println("Ungültige Eingabe");
        String bezeichnung = "gvz";
        String kategorie = "gccztz";
        Integer dauerMin = null;
        Integer dauerMax = null;
        String inhalt = "";
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
        Date zeitVon = null;
        Date zeitBis = null;
        Boolean storniert = null;
        Integer preisMin = null;
        Integer preisMax = null;
        VeranstaltungKey veranstaltung = null;
        SaalKey saal = null;
        AuffuehrungDAO dao = DAOFactory.getAuffuehrungDAO();
        List<Auffuehrung> expResult = dao.getAll();
        List<Auffuehrung> result = AuffuehrungsHelper.sucheAuffuehrungen(zeitVon, zeitBis, storniert, preisMin, preisMax, veranstaltung, saal);
        assertEquals(expResult, result);
    }
    
     @Test
    public void sucheAuffuehrungenStorniert() throws Exception {
        System.out.println("Suche bestimmte Aufführung die storniert wurden");
        Date zeitVon = null;
        Date zeitBis = null;
        Boolean storniert = true;
        Integer preisMin = null;
        Integer preisMax = null;
        VeranstaltungKey veranstaltung = null;
        SaalKey saal = null;
        AuffuehrungDAO dao = DAOFactory.getAuffuehrungDAO();
        query = "storniert = " + true;
        List<Auffuehrung> expResult = dao.find(query);
        List<Auffuehrung> result = AuffuehrungsHelper.sucheAuffuehrungen(zeitVon, zeitBis, storniert, preisMin, preisMax, veranstaltung, saal);
        assertEquals(expResult, result);
    }

}