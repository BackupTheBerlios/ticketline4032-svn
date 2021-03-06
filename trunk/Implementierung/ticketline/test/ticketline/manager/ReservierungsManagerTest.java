/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.manager;

import java.util.Date;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.BestellungDAO;
import ticketline.dao.interfaces.KundeDAO;
import ticketline.dao.interfaces.TransaktionDAO;
import ticketline.db.Auffuehrung;
import static org.junit.Assert.*;
import ticketline.db.AuffuehrungKey;
import ticketline.db.Bestellung;
import ticketline.db.Kategorie;
import ticketline.db.Kunde;
import ticketline.db.Reihe;
import ticketline.db.ReiheKey;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;

//--

/**
 *
 * @author Rene Sabin, Dominik Kontner, Christoph Auernig
 */
public class ReservierungsManagerTest {

    public ReservierungsManagerTest() {
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
        Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(0);
        AuffuehrungKey auffuehrungsKey = auffuehrung.getComp_id();
        ReiheKey reihe = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();

        Integer startplatz = 1;
        Integer anzahl = null;
        String zahlart = "Karte";
        boolean reservierung = true;
        Transaktion result = ReservierungsManager.kaufeTickets(kunde, zeit, auffuehrungsKey, reihe, startplatz, anzahl, zahlart, reservierung);
        assertEquals(null, result);
        
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
        Kunde kunde = kundeDAO.get(2);
        Date zeit = new Date();
        Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(3);
        AuffuehrungKey auffuehrungsKey = auffuehrung.getComp_id();
        ReiheKey reihe = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();
        Integer startplatz = 4;
        Integer anzahl = 3;
        String zahlart = "Karte";
        boolean reservierung = true;
        Transaktion result = ReservierungsManager.kaufeTickets(kunde, zeit, auffuehrungsKey, reihe, startplatz, anzahl, zahlart, reservierung);
        System.out.println("Die reservierungsnummer lautet: " + result);
        int anzTransRes = transaktionDAO.find("storniert is 'false'").size();
        assertTrue(anzTransStart+1 == anzTransRes);
        assertFalse(result.isStorniert());
        System.out.println(anzTransStart+1 + " zu "+ anzTransRes);
        TransaktionKey transaktionKey = ((Transaktion)DAOFactory.getTransaktionDAO().find("resnr is " + result.getResnr()).get(0)).getComp_id();
        ReservierungsManager.storniereReservierung(transaktionKey);
        int anzTransStor = transaktionDAO.find("storniert is 'false'").size();
        System.out.println(anzTransStart + " zu "+ anzTransStor);
        assertTrue(anzTransStart==anzTransStor);
        assertTrue(result.isStorniert());
        
    }

    @Test
    public void reserviereTicket2() throws Exception {
        System.out.println("reserviere und storniere Ticket");
        TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
        int anzTransStart = transaktionDAO.find("storniert is 'false'").size();
        KundeDAO kundeDAO = DAOFactory.getKundeDAO();
        Kunde kunde = kundeDAO.get(2);
        Date zeit = new Date();
        Auffuehrung auffuehrung = (Auffuehrung) DAOFactory.getAuffuehrungDAO().getAll().get(1);
        AuffuehrungKey auffuehrungsKey = auffuehrung.getComp_id();
        ReiheKey reihe = ((Reihe) ((Kategorie) auffuehrung.getSaal().getKategorien().iterator().next()).getReihen().iterator().next()).getComp_id();
        Integer startplatz = 2;
        Integer anzahl = 1;
        String zahlart = "Karte";
        boolean reservierung = true;
        Transaktion result = ReservierungsManager.kaufeTickets(kunde, zeit, auffuehrungsKey, reihe, startplatz, anzahl, zahlart, reservierung);
        System.out.println("Die reservierungsnummer lautet: " + result);
        int anzTransRes = transaktionDAO.find("storniert is 'false'").size();
        assertTrue(anzTransStart+1 == anzTransRes);
        assertFalse(result.isStorniert());
        System.out.println(anzTransStart+1 + " zu "+ anzTransRes);
        TransaktionKey transaktionKey = ((Transaktion)DAOFactory.getTransaktionDAO().find("resnr is " + result.getResnr()).get(0)).getComp_id();
        ReservierungsManager.storniereReservierung(transaktionKey);
        int anzTransStor = transaktionDAO.find("storniert is 'false'").size();
        System.out.println(anzTransStart + " zu "+ anzTransStor);
        assertTrue(anzTransStart==anzTransStor);
        assertTrue(result.isStorniert());
        
        System.out.println("Ende des Funktionstests");
        
    }
    
       @Test
    public void kaufeWerbematerial() throws Exception {
        System.out.println("Kaufe Werbematerial");
	
        KundeDAO kundeDAO = DAOFactory.getKundeDAO();
        Kunde kunde = kundeDAO.get(1);
        BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
        Bestellung bestellung = (Bestellung) bestellungDAO.getAll().get(0);
	
        ReservierungsManager.kaufeWerbematerial(kunde, bestellung);
        assertEquals(bestellung.getKunde(),kunde);
    }
       
         @Test
    public void kaufeWerbematerial2() throws Exception {
        System.out.println("Kaufe Werbematerial2");
	
        KundeDAO kundeDAO = DAOFactory.getKundeDAO();
        Kunde kunde = kundeDAO.get(1);
	
        BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
        Bestellung bestellung = (Bestellung) bestellungDAO.getAll().get(4);
	
        ReservierungsManager.kaufeWerbematerial(kunde, bestellung);
        assertEquals(bestellung.getKunde(),kunde);
    }
    
}