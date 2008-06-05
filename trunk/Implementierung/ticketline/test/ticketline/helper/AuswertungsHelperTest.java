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
import ticketline.dao.hibernate.HibernateSessionFactory;
import static org.junit.Assert.*;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;

/**
 *
 * @author RedFalcon
 */
public class AuswertungsHelperTest {

    public AuswertungsHelperTest() {
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
     * Test of sucheTopTen method, of class AuswertungsHelper.
     */
    @Test
    public void sucheTopTen() throws Exception {
        System.out.println("sucheTopTen");
        
        List<Long> l2 = HibernateSessionFactory.currentSession().createQuery("SELECT SUM(anzverk) FROM Belegung GROUP BY auffuehrung.veranstaltung.comp_id ORDER BY SUM(anzverk) DESC").list();
        
        List<Veranstaltung> result = AuswertungsHelper.sucheTopTen();
        
        for(int i = 0; i < 10; i++)
        {
            assertEquals(l2.get(i).intValue(), AuswertungsHelper.berechneBesucherzahl(result.get(i).getComp_id()).intValue());
        }
    }

    /**
     * Test of berechneBesucherzahl method, of class AuswertungsHelper.
     */
    @Test
    public void berechneBesucherzahl() throws Exception {
        System.out.println("berechneBesucherzahl");
        VeranstaltungKey veranstaltungKey = null;
        Integer expResult = null;
        Integer result = null; //AuswertungsHelper.berechneBesucherzahl(veranstaltungKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}