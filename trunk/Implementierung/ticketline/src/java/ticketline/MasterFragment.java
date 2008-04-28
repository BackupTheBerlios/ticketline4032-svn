/*
 * MasterFragment.java
 *
 * Created on Apr 20, 2008, 6:08:34 PM
 */
 
package ticketline;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import ticketline.db.Kunde;
import ticketline.helper.SystemHelper;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Michael Morak
 */
public class MasterFragment extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private PanelLayout panelSide = new PanelLayout();

    public PanelLayout getPanelSide() {
        return panelSide;
    }

    public void setPanelSide(PanelLayout pl) {
        this.panelSide = pl;
    }
    private TextField textFieldUsername = new TextField();

    public TextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public void setTextFieldUsername(TextField tf) {
        this.textFieldUsername = tf;
    }
    private Button buttonLogin = new Button();

    public Button getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(Button b) {
        this.buttonLogin = b;
    }
    private PasswordField passwordField = new PasswordField();

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField pf) {
        this.passwordField = pf;
    }
    private PanelLayout panelLogin = new PanelLayout();

    public PanelLayout getPanelLogin() {
        return panelLogin;
    }

    public void setPanelLogin(PanelLayout pl) {
        this.panelLogin = pl;
    }
    private PanelLayout panelLogout = new PanelLayout();

    public PanelLayout getPanelLogout() {
        return panelLogout;
    }

    public void setPanelLogout(PanelLayout pl) {
        this.panelLogout = pl;
    }
    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }
    private StaticText textUsername = new StaticText();

    public StaticText getTextUsername() {
        return textUsername;
    }

    public void setTextUsername(StaticText st) {
        this.textUsername = st;
    }
    private Button buttonLogout = new Button();

    public Button getButtonLogout() {
        return buttonLogout;
    }

    public void setButtonLogout(Button b) {
        this.buttonLogout = b;
    }
    private Label labelStatusMessage = new Label();

    public Label getLabelStatusMessage() {
        return labelStatusMessage;
    }

    public void setLabelStatusMessage(Label l) {
        this.labelStatusMessage = l;
    }
    private PanelLayout panelTop = new PanelLayout();

    public PanelLayout getPanelTop() {
        return panelTop;
    }

    public void setPanelTop(PanelLayout pl) {
        this.panelTop = pl;
    }
    private ImageComponent imageLogo = new ImageComponent();

    public ImageComponent getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(ImageComponent ic) {
        this.imageLogo = ic;
    }
    private StaticText staticTextTitle = new StaticText();

    public StaticText getStaticTextTitle() {
        return staticTextTitle;
    }

    public void setStaticTextTitle(StaticText st) {
        this.staticTextTitle = st;
    }
    private Hyperlink hyperlink1 = new Hyperlink();

    public Hyperlink getHyperlink1() {
        return hyperlink1;
    }

    public void setHyperlink1(Hyperlink h) {
        this.hyperlink1 = h;
    }
    private Hyperlink hyperlink2 = new Hyperlink();

    public Hyperlink getHyperlink2() {
        return hyperlink2;
    }

    public void setHyperlink2(Hyperlink h) {
        this.hyperlink2 = h;
    }
    private Hyperlink hyperlink4 = new Hyperlink();

    public Hyperlink getHyperlink4() {
        return hyperlink4;
    }

    public void setHyperlink4(Hyperlink h) {
        this.hyperlink4 = h;
    }
    private Hyperlink hyperlink5 = new Hyperlink();

    public Hyperlink getHyperlink5() {
        return hyperlink5;
    }

    public void setHyperlink5(Hyperlink h) {
        this.hyperlink5 = h;
    }
    private TextField textFieldSearch = new TextField();

    public TextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void setTextFieldSearch(TextField tf) {
        this.textFieldSearch = tf;
    }
    private Button buttonSearch = new Button();

    public Button getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(Button b) {
        this.buttonSearch = b;
    }
    private Hyperlink hyperlink6 = new Hyperlink();

    public Hyperlink getHyperlink6() {
        return hyperlink6;
    }

    public void setHyperlink6(Hyperlink h) {
        this.hyperlink6 = h;
    }
    private Hyperlink hyperlink7 = new Hyperlink();

    public Hyperlink getHyperlink7() {
        return hyperlink7;
    }

    public void setHyperlink7(Hyperlink h) {
        this.hyperlink7 = h;
    }
    private ImageComponent imageLeftEnd = new ImageComponent();

    public ImageComponent getImageLeftEnd() {
        return imageLeftEnd;
    }

    public void setImageLeftEnd(ImageComponent ic) {
        this.imageLeftEnd = ic;
    }
    private Hyperlink hyperlink3 = new Hyperlink();

    public Hyperlink getHyperlink3() {
        return hyperlink3;
    }

    public void setHyperlink3(Hyperlink h) {
        this.hyperlink3 = h;
    }
    private Form formLogin = new Form();

    public Form getFormLogin() {
        return formLogin;
    }

    public void setFormLogin(Form f) {
        this.formLogin = f;
    }
    private Form formLogout = new Form();

    public Form getFormLogout() {
        return formLogout;
    }

    public void setFormLogout(Form f) {
        this.formLogout = f;
    }
    private Form formTop = new Form();

    public Form getFormTop() {
        return formTop;
    }

    public void setFormTop(Form f) {
        this.formTop = f;
    }
    // </editor-fold>

    public MasterFragment() {
    }

    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        
        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        
        if(this.getSessionBean1().getLogin() == null)
        {
            this.panelLogout.setVisible(false);

            this.labelStatusMessage.setText("");
        }
        else
        {
            this.panelLogin.setVisible(false);

            this.labelStatusMessage.setText("");
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public String buttonLogin_action() {
        
        Integer knr = -1;
        
        try 
        {
            knr = Integer.parseInt(this.textFieldUsername.getText().toString());
            Kunde k;
            
            if((k = SystemHelper.checkLogin(knr, this.passwordField.getPassword().toString())) != null)
            {
                this.getSessionBean1().setLogin(k);
                
                this.labelStatusMessage.setText("");

                this.panelLogin.setVisible(false);
                this.panelLogout.setVisible(true);
            }
            else
            {
                this.labelStatusMessage.setText("Login fehlgeschlagen!");
            }
        } 
        catch (Exception ex) 
        {
            this.labelStatusMessage.setText("Login fehlgeschlagen!");
        }
        
        return null;
    }

    public String buttonLogout_action() {
        
        this.panelLogin.setVisible(true);
        this.panelLogout.setVisible(false);
        
        this.labelStatusMessage.setText("Erfolgreich ausgeloggt!");
        
        this.getSessionBean1().setLogin(null);
        
        return "logout";
    }

    public String buttonSearch_action() {
        
        return "search";
    }
}
