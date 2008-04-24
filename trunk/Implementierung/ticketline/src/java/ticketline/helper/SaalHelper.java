/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import ticketline.db.Kategorie;
import ticketline.db.KategorieKey;
import ticketline.db.OrtKey;
import ticketline.db.Reihe;
import ticketline.db.Saal;
import ticketline.db.SaalKey;

/**
 *
 * @author Michael Morak
 */
public class SaalHelper 
{
    public List<Saal> sucheSaele(String bezeichnung, String typ, Integer plaetzeMin,
                                    OrtKey ort)
    {
        return null;
    }
    
    public List<Kategorie> sucheKategorien(SaalKey saal)
    {
        return null;
    }
    
    public List<Reihe> sucheReihen(KategorieKey key)
    {
        return null;
    }
}
