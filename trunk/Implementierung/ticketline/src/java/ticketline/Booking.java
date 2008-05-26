/*
 * Products.java
 *
 * Created on 23.04.2008, 17:58:59
 */
 
package ticketline;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import ticketline.db.Transaktion;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;
import ticketline.manager.ReservierungsManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Dominik
 */
public class Booking extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private Button button1 = new Button();

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button b) {
        this.button1 = b;
    }
    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }
    private Button button3 = new Button();

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button b) {
        this.button3 = b;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    private TableColumn tableColumn7 = new TableColumn();

    public TableColumn getTableColumn7() {
        return tableColumn7;
    }

    public void setTableColumn7(TableColumn tc) {
        this.tableColumn7 = tc;
    }
    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }
    private TableColumn tableColumn8 = new TableColumn();

    public TableColumn getTableColumn8() {
        return tableColumn8;
    }

    public void setTableColumn8(TableColumn tc) {
        this.tableColumn8 = tc;
    }
    private StaticText staticText8 = new StaticText();

    public StaticText getStaticText8() {
        return staticText8;
    }

    public void setStaticText8(StaticText st) {
        this.staticText8 = st;
    }
    private TableColumn tableColumn9 = new TableColumn();

    public TableColumn getTableColumn9() {
        return tableColumn9;
    }

    public void setTableColumn9(TableColumn tc) {
        this.tableColumn9 = tc;
    }
    private StaticText staticText9 = new StaticText();

    public StaticText getStaticText9() {
        return staticText9;
    }

    public void setStaticText9(StaticText st) {
        this.staticText9 = st;
    }
    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private Label labelStatus = new Label();

    public Label getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(Label l) {
        this.labelStatus = l;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Booking() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("Products Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    
    public List<Transaktion> getReservierungen()
    {
        try {
            return ReservierungsManager.sucheReservierungen(this.getSessionBean1().getLogin(), null, null, null, null, null, null, null);
        } catch (TicketLineSystemException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TicketLineException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return null;
    }
    
    private TableSelectPhaseListener tablePhaseListener =
                                  new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected(){
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }

    public String buttonBuy_action() {
        
        if(this.tableRowGroup1.getSelectedRowsCount() > 0)
        {
            RowKey sel = this.tableRowGroup1.getSelectedRowKeys()[0];
            Transaktion t = ((List<Transaktion>)this.tableRowGroup1.getSourceData()).get(Integer.parseInt(sel.getRowId()));
            
            if(!t.isVerkauft())
            {
                try {
                    ReservierungsManager.kaufeReservierung(t.getComp_id());
                    
                    this.getRequestBean1().setTransaktion(t);
                    return "buy";
                    
                } catch (TicketLineSystemException ex) {
                    this.labelStatus.setText("Es trat ein unbekannter Fehler auf!");
                } catch (TicketLineException ex) {
                    this.labelStatus.setText("Fehler: " + ex.getMessage());
                } 
            }
        }
        
        return null;
    }

    public String buttonRevoke_action() {
        
        if(this.tableRowGroup1.getSelectedRowsCount() > 0)
        {
            RowKey sel = this.tableRowGroup1.getSelectedRowKeys()[0];
            Transaktion t = ((List<Transaktion>)this.tableRowGroup1.getSourceData()).get(Integer.parseInt(sel.getRowId()));
            
            if(!t.isStorniert())
            {
                try {
                    ReservierungsManager.storniereReservierung(t.getComp_id());
                    this.labelStatus.setText("Erfolgreich storniert!");
                } catch (TicketLineSystemException ex) {
                    this.labelStatus.setText("Es trat ein unbekannter Fehler auf!");
                } catch (TicketLineException ex) {
                    this.labelStatus.setText("Fehler: " + ex.getMessage());
                } 
            }
        }
        
        return null;
    }
}

