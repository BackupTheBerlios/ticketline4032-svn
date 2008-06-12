/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.junit.Test;
import ticketline.dao.hibernate.HibernateSessionFactory;
import static org.junit.Assert.*;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;

/**
 *
 * @author Michael Morak, Andreas Weißenbacher
 */
public class AuswertungsHelperTest {

    public AuswertungsHelperTest() {
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
        
        VeranstaltungKey veranstaltungKey = new VeranstaltungKey("Bush", "Theater");
        
        List list = HibernateSessionFactory.currentSession().createQuery("SELECT SUM(anzverk) FROM Belegung WHERE auffuehrung.veranstaltung.comp_id.bezeichnung = '" + veranstaltungKey.getBezeichnung() + "' AND auffuehrung.veranstaltung.comp_id.kategorie = '" + veranstaltungKey.getKategorie() + "'").list();
        
        int expResult = Integer.parseInt(list.get(0).toString());
        
        Integer result = AuswertungsHelper.berechneBesucherzahl(veranstaltungKey); //AuswertungsHelper.berechneBesucherzahl(veranstaltungKey);
        
        assertEquals(expResult, result);
        
    }

}