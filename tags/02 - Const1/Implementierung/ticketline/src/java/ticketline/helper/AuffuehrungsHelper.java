/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.helper;

import java.util.Date;
import java.util.List;
import ticketline.db.Auffuehrung;
import ticketline.db.Kuenstler;
import ticketline.db.SaalKey;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;

/**
 *
 * @author Michael Morak
 */
public class AuffuehrungsHelper 
{
    public List<Kuenstler> sucheKuenstler(String vorname, String nachname, boolean maennlich)
    {
        return null;
    }
    
    public List<Veranstaltung> sucheVeranstaltungen(String bezeichnung, String kategorie,
                                                    Integer dauerMin, Integer dauerMax, String inhalt)
    {
        return null;
    }
    
    public List<Auffuehrung> sucheAuffuehrungen(Date zeitVon, Date zeitBis, boolean storniert, Integer preisMin, Integer preisMax,
                                                VeranstaltungKey veranstaltung, SaalKey saal)
    {
        return null;
    }
}
