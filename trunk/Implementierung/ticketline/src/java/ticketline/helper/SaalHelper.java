/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.db.Kategorie;
import ticketline.db.KategorieKey;
import ticketline.db.OrtKey;
import ticketline.db.Reihe;
import ticketline.db.Saal;
import ticketline.db.SaalKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak
 */
public class SaalHelper 
{
    private static final Logger log = LogManager.getLogger(SaalHelper.class);
    
    private SaalHelper() { }
    
    public static List<Saal> sucheSaele(String bezeichnung, String typ, Integer plaetzeMin,
                                    OrtKey ort) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static List<Kategorie> sucheKategorien(SaalKey saal) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
    
    public static List<Reihe> sucheReihen(KategorieKey key) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
}
