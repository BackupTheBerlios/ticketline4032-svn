/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import static org.junit.Assert.*;
import ticketline.db.Kunde;

/**
 *
 * @author Sriver
 */
public class SystemHelperTest {

    public SystemHelperTest() {
    }

    Kunde result;
    private String onlinepwd;
    private Integer kartennr;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

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
        
        System.out.println("checkLoginTrue");
        kartennr = 1;
        onlinepwd = "foobar";
        result = SystemHelper.checkLogin(kartennr, onlinepwd);
        assertEquals(result.getNname(), "Sobieski");
        
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
        
        System.out.println("NullInput");
        result = SystemHelper.checkLogin(kartennr, onlinepwd);
        assertEquals(null, result);
        
    }
    @Test
    public void WrongPwd() {
        
        System.out.println("WrongPwd");
        kartennr = 1;
        result = SystemHelper.checkLogin(kartennr, onlinepwd);
        assertEquals(null, result);
        
    }
    @Test
    public void WrongKartennr() {
        
        System.out.println("WrongKartennr");
        kartennr = 61;
        result = SystemHelper.checkLogin(kartennr, onlinepwd);
        assertEquals(null, result);
        
    }
}