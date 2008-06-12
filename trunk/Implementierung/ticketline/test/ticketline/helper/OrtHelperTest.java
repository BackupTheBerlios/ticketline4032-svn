/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.OrtDAO;
import static org.junit.Assert.*;
import ticketline.db.Ort;

/**
 *
 * @author Rene
 */
public class OrtHelperTest {
    
    private String bezeichnung = "";
    private String strasse = "";
    private String ort = "";
    private String bundesland = "";
    private String plz = "";
    private Boolean verkauf = null;
    private Boolean auffuehrung = null;
    private Boolean kiosk = null;
    private List<Ort> expResult = null;
    OrtDAO ortdao = DAOFactory.getOrtDAO();
    String query="";
    
    public OrtHelperTest() {
        
    }

    @Before
    public void setUp() {
    bezeichnung = "";
    strasse = "";
    ort = "";
    bundesland = "";
    plz = "";
    verkauf = null;
    auffuehrung = null;
    kiosk = null;
    expResult = null;
    query = "";
    }

    @After
    public void tearDown() {
        bezeichnung = "";
        strasse = "";
        ort = "";
        bundesland = "";
        plz = "";
        verkauf = null;
        auffuehrung = null;
        kiosk = null;
        expResult = null;
        query = "";
    }

    /**
     * Test of sucheOrte method, of class OrtHelper.
     */
    @Test
    public void sucheOrteAlleNull() throws Exception {
        System.out.println("suche Orte: all empty");
        query= " 1 = 1";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    @Test
    public void sucheOrteAlleF() throws Exception {
        System.out.println("suche Orte: Eingabe falsch");
        bezeichnung = "f.."; 
        strasse = "234lo";
        ort = "    ";
        bundesland = "Mö-dlün%";
        plz = "vier";
        verkauf = null;
        auffuehrung = null;
        kiosk = null;
        query= " 1 = 1 AND bezeichnung like '%" + bezeichnung + "%' AND strasse like '%" + strasse + "%' AND ort like '%" + ort + "%' AND bundesland like '%" + bundesland + "%' " ;
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    @Test
    public void sucheOrteBezT() throws Exception {
        System.out.println("suche Orte: bezeichnung");
        bezeichnung = "UMMI GUMMI";
        query = "bezeichnung like '%" + bezeichnung + "%' ";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    @Test
    public void sucheOrteBundlT() throws Exception {
        System.out.println("suche Orte: bezeichnung");
        bundesland = "Wien";
        query = "bundesland like '%" + bundesland + "%' ";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    @Test
    public void sucheOrtePlzT() throws Exception {
        System.out.println("suche Orte: bezeichnung");
        plz = "6239";
        query = "plz like '%" + plz + "%' ";
        expResult = ortdao.find(query);  
        List<Ort> result = OrtHelper.sucheOrte(bezeichnung, strasse, ort, bundesland, plz, verkauf, auffuehrung, kiosk);
        assertEquals(expResult, result);
        
    }
    

}