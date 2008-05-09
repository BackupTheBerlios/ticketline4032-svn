/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketline.exceptions;

/**
 *
 * @author Michael Morak
 */
public class TicketLineSystemException extends TicketLineException
{
    private static final long serialVersionUID = -1955468922613978257L;
    
    public TicketLineSystemException(String message)
    {
        super(message);
    }
    
    public TicketLineSystemException(String message, Throwable t)
    {
        super(message, t);
    }
}
