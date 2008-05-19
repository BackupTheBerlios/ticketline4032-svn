/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.KundeDAO;
import ticketline.dao.interfaces.TransaktionDAO;
import ticketline.db.Auffuehrung;
import static org.junit.Assert.*;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Belegung;
import ticketline.db.Kategorie;
import ticketline.db.Kunde;
import ticketline.db.Reihe;
import ticketline.db.ReiheKey;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;

//--

/**
 *
 * @author Rene
 */
public class ReservierungsManagerTest {

    public ReservierungsManagerTest() {
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
     * Test of kaufeTickets method, of class ReservierungsManager.
     */
    @Test
    public void kaufeTicketsF() throws Exception {
        System.out.println("kaufeTickets mit Null");
        KundeDAO kundeDAO = DAOFactory.getKundeDAO();
        Kunde kunde = kundeDAO.get(1);
        Date zeit = new Date();
        Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(1);
        AuffuehrungKey auffuehrungsKey = auffuehrung.getComp_id();
        ReiheKey reihe = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();
        BigDecimal preis = new BigDecimal(100);
        Integer startplatz = 1;
        Integer anzahl = null;
        String zahlart = "Karte";
        boolean reservierung = true;
        Integer expResult = new Integer(-1);
        Integer result = ReservierungsManager.kaufeTickets(kunde, zeit, auffuehrungsKey, reihe, preis, startplatz, anzahl, zahlart, reservierung);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of kaufeTickets method, of class ReservierungsManager.
     */
    @Test
    public void reserviereTicket() throws Exception {
        System.out.println("reserviere und storniere Ticket");
        TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
        int anzTransStart = transaktionDAO.find("storniert is 'false'").size();
        KundeDAO kundeDAO = DAOFactory.getKundeDAO();
        Kunde kunde = kundeDAO.get(1);
        Date zeit = new Date();
        Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(1);
        AuffuehrungKey auffuehrungsKey = auffuehrung.getComp_id();
        ReiheKey reihe = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();
        BigDecimal preis = new BigDecimal(100);
        Integer startplatz = 1;
        Integer anzahl = 3;
        String zahlart = "Karte";
        boolean reservierung = true;
        Integer expResult = new Integer(-1);
        Integer result = ReservierungsManager.kaufeTickets(kunde, zeit, auffuehrungsKey, reihe, preis, startplatz, anzahl, zahlart, reservierung);
        System.out.println("Die reservierungsnummer lautet: " + result);
        int anzTransRes = transaktionDAO.find("storniert is 'false'").size();
        assertFalse(expResult == result);
        assertTrue(anzTransStart+1 == anzTransRes);
        System.out.println(anzTransStart+1 + " zu "+ anzTransRes);
        TransaktionKey transaktionKey = ((Transaktion)DAOFactory.getTransaktionDAO().find("resnr is " + result).get(0)).getComp_id();
        ReservierungsManager.storniereReservierung(transaktionKey);
        int anzTransStor = transaktionDAO.find("storniert is 'false'").size();
        System.out.println(anzTransStart + " zu "+ anzTransStor);
        assertTrue(anzTransStart==anzTransStor);
        
        System.out.println("Ende gut, alles gut");
        
    }

    /**
     * Test of storniereReservierung method, of class ReservierungsManager.
     *
    @Test
    public void storniereReservierung() throws Exception {
        System.out.println("storniereReservierung");
        TransaktionKey reservierung = null;
        ReservierungsManager.storniereReservierung(reservierung);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    **/
}