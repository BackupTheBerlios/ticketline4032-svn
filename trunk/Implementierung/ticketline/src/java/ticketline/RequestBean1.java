/*
 * RequestBean1.java
 *
 * Created on Apr 14, 2008, 11:14:55 PM
 */
 
package ticketline;

import com.sun.rave.web.ui.appbase.AbstractRequestBean;
import javax.faces.FacesException;
import ticketline.db.Kuenstler;
import ticketline.db.Ort;
import ticketline.db.Saal;
import ticketline.db.SaalKey;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;
import ticketline.exceptions.TicketLineException;
import ticketline.helper.SaalHelper;

/**
 * <p>Request scope data bean for your application.  Create properties
 *  here to represent data that should be made available across different
 *  pages in the same HTTP request, so that the page bean classes do not
 *  have to be directly linked to each other.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @author Michael Morak
 */
public class RequestBean1 extends AbstractRequestBean {

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new request data bean instance.</p>
     */
    public RequestBean1() {
       
    }

    /**
     * <p>This method is called when this bean is initially added to
     * request scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * request scope.</p>
     * 
     * <p>You may customize this method to allocate resources that are required
     * for the lifetime of the current request.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("RequestBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when this bean is removed from
     * request scope.  This occurs automatically when the corresponding
     * HTTP response has been completed and sent to the client.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the request.</p>
     */
    @Override
    public void destroy() {
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    
    private SaalKey plaetze=null;

    public SaalKey getPlaetze() throws TicketLineException {
        return plaetze;
    }

    public void setPlaetze(SaalKey plaetze) {
        this.plaetze = plaetze;
    }
    
    private String query = null;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    private boolean newQuery = false;

    public boolean isNewQuery() {
        return newQuery;
    }

    public void setNewQuery(boolean newQuery) {
        this.newQuery = newQuery;
    }
    
    private VeranstaltungKey veranstaltungKey = null;

    public VeranstaltungKey getVeranstaltungKey() {
        return veranstaltungKey;
    }

    public void setVeranstaltungKey(VeranstaltungKey veranstaltungKey) {
        this.veranstaltungKey = veranstaltungKey;
    }
    
    private Kuenstler kuenstler = null;
    
    private Ort ort = null;

    public Kuenstler getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(Kuenstler kuenstler) {
        this.kuenstler = kuenstler;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }
}
