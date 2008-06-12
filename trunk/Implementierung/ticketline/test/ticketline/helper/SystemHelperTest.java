/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import static org.junit.Assert.*;
import ticketline.db.Kunde;
import ticketline.exceptions.TicketLineException;

/**
 *
 * @author Andreas Weißenbacher, Dominik Kontner
 */
public class SystemHelperTest {

    public SystemHelperTest() {
    }

    Kunde result;
    private String onlinepwd;
    private Integer kartennr;
    
    

    @Before
    public void setUp() {
          result = null;
          onlinepwd = null;
          kartennr = null;
    }

    @After
    public void tearDown() {
          result = null;
          onlinepwd = null;
          kartennr = null;
    }

    /**
     * Test of checkLogin method, of class SystemHelper.
     */
    @Test
    public void checkLoginTrue() {
        try {

            System.out.println("checkLoginTrue");
            kartennr = 1;
            onlinepwd = "foobar";
            result = SystemHelper.checkLogin(kartennr, onlinepwd);
            assertEquals(result.getNname(), "Sobieski");
        } catch (TicketLineException ex) {
            Logger.getLogger(SystemHelperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void PwdCheck() { 
        System.out.println("PwdCheck");
        kartennr = 1;
        onlinepwd = "foobar";
        result = DAOFactory.getKundeDAO().get(kartennr);
        assertEquals(onlinepwd, result.getOnlinepwd());
    }
    @Test
    public void NullInput() {
        try {

            System.out.println("NullInput");
            result = SystemHelper.checkLogin(kartennr, onlinepwd);
            assertEquals(null, result);
        } catch (TicketLineException ex) {
            Logger.getLogger(SystemHelperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void WrongKartennr() {
        try {

            System.out.println("WrongKartennr");
            kartennr = 10000;
            onlinepwd = "foobar";
            result = SystemHelper.checkLogin(kartennr, onlinepwd);
            assertEquals(null, result);
        } catch (TicketLineException ex) {
            Logger.getLogger(SystemHelperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void WrongPwd() {
        try {

            System.out.println("WrongPwd");
            kartennr = 1;
            result = SystemHelper.checkLogin(kartennr, onlinepwd);
            assertEquals(null, result);
        } catch (TicketLineException ex) {
            Logger.getLogger(SystemHelperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}