/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.db.Ort;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;

/**
 *
 * @author Michael Morak
 */
public class OrtHelper 
{    
    private static final Logger log = LogManager.getLogger(OrtHelper.class);
    
    private OrtHelper() { }
    
    public static List<Ort> sucheOrte(String bezeichnung, String strasse, String ort,
                                String bundesland, String plz, boolean verkauf,
                                boolean auffuehrung, boolean kiosk) throws TicketLineException, TicketLineSystemException
    {
        return null;
    }
}
