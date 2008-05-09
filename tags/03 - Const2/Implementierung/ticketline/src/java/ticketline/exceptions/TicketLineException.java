/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.exceptions;

/**
 *
 * @author Michael Morak
 */
public class TicketLineException extends Exception 
{
    private static final long serialVersionUID = -1956468922210978997L;
    
    public TicketLineException(String message)
    {
        super(message);
    }
    
    public TicketLineException(String message, Throwable t)
    {
        super(message, t);
    }
}
