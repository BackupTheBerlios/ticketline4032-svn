/*
 * ManageAccount.java
 *
 * Created on 23.04.2008, 10:43:42
 */
 
package ticketline;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.db.Kunde;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;
import ticketline.helper.KundenHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Dominik
 */
public class ManageAccount extends AbstractPageBean 
{
    private static final Logger log = LogManager.getLogger(ManageAccount.class);
    
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
    private Label labelForename = new Label();

    public Label getLabelForename() {
        return labelForename;
    }

    public void setLabelForename(Label l) {
        this.labelForename = l;
    }
    private Label labelSurname = new Label();

    public Label getLabelSurname() {
        return labelSurname;
    }

    public void setLabelSurname(Label l) {
        this.labelSurname = l;
    }
    private Label labelTitle = new Label();

    public Label getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(Label l) {
        this.labelTitle = l;
    }
    private Label labelSex = new Label();

    public Label getLabelSex() {
        return labelSex;
    }

    public void setLabelSex(Label l) {
        this.labelSex = l;
    }
    private Label labelBirth = new Label();

    public Label getLabelBirth() {
        return labelBirth;
    }

    public void setLabelBirth(Label l) {
        this.labelBirth = l;
    }
    private Label labelStreet = new Label();

    public Label getLabelStreet() {
        return labelStreet;
    }

    public void setLabelStreet(Label l) {
        this.labelStreet = l;
    }

    private Label labelCity = new Label();

    public Label getLabelCity() {
        return labelCity;
    }

    public void setLabelCity(Label l) {
        this.labelCity = l;
    }
    private Label labelZIP = new Label();

    public Label getLabelZIP() {
        return labelZIP;
    }

    public void setLabelZIP(Label l) {
        this.labelZIP = l;
    }
    private Label labelPhone = new Label();

    public Label getLabelPhone() {
        return labelPhone;
    }

    public void setLabelPhone(Label l) {
        this.labelPhone = l;
    }
    private Label labelEmail = new Label();

    public Label getLabelEmail() {
        return labelEmail;
    }

    public void setLabelEmail(Label l) {
        this.labelEmail = l;
    }
    private Label labelBankAccount = new Label();

    public Label getLabelBankAccount() {
        return labelBankAccount;
    }

    public void setLabelBankAccount(Label l) {
        this.labelBankAccount = l;
    }
    private Label labelBankNumber = new Label();

    public Label getLabelBankNumber() {
        return labelBankNumber;
    }

    public void setLabelBankNumber(Label l) {
        this.labelBankNumber = l;
    }
    private Label labelCreditCard = new Label();

    public Label getLabelCreditCard() {
        return labelCreditCard;
    }

    public void setLabelCreditCard(Label l) {
        this.labelCreditCard = l;
    }
    private Label labelCreditCardValid = new Label();

    public Label getLabelCreditCardValid() {
        return labelCreditCardValid;
    }

    public void setLabelCreditCardValid(Label l) {
        this.labelCreditCardValid = l;
    }
    private Label labelPasswordNew = new Label();

    public Label getLabelPasswordNew() {
        return labelPasswordNew;
    }

    public void setLabelPasswordNew(Label l) {
        this.labelPasswordNew = l;
    }
    
    private TextField textForename = new TextField();

    public TextField getTextForename() {
        return textForename;
    }

    public void setTextForename(TextField tf) {
        this.textForename = tf;
    }
    private TextField textSurname = new TextField();

    public TextField getTextSurname() {
        return textSurname;
    }

    public void setTextSurname(TextField tf) {
        this.textSurname = tf;
    }
    private TextField textTitle = new TextField();

    public TextField getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(TextField tf) {
        this.textTitle = tf;
    }
    private TextField textBirth = new TextField();

    public TextField getTextBirth() {
        return textBirth;
    }

    public void setTextBirth(TextField tf) {
        this.textBirth = tf;
    }
    private TextField textStreet = new TextField();

    public TextField getTextStreet() {
        return textStreet;
    }

    public void setTextStreet(TextField tf) {
        this.textStreet = tf;
    }
    private TextField textCity = new TextField();

    public TextField getTextCity() {
        return textCity;
    }

    public void setTextCity(TextField tf) {
        this.textCity = tf;
    }
    private TextField textZIP = new TextField();

    public TextField getTextZIP() {
        return textZIP;
    }

    public void setTextZIP(TextField tf) {
        this.textZIP = tf;
    }
    private TextField textPhone = new TextField();

    public TextField getTextPhone() {
        return textPhone;
    }

    public void setTextPhone(TextField tf) {
        this.textPhone = tf;
    }
   
    private TextField textEmail = new TextField();

    public TextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(TextField tf) {
        this.textEmail = tf;
    }
    private TextField textBankAccount = new TextField();

    public TextField getTextBankAccount() {
        return textBankAccount;
    }

    public void setTextBankAccount(TextField tf) {
        this.textBankAccount = tf;
    }
    private TextField textBankNumber = new TextField();

    public TextField getTextBankNumber() {
        return textBankNumber;
    }

    public void setTextBankNumber(TextField tf) {
        this.textBankNumber = tf;
    }
    private TextField textCreditCard = new TextField();

    public TextField getTextCreditCard() {
        return textCreditCard;
    }

    public void setTextCreditCard(TextField tf) {
        this.textCreditCard = tf;
    }
    private TextField textCreditCardValid = new TextField();

    public TextField getTextCreditCardValid() {
        return textCreditCardValid;
    }

    public void setTextCreditCardValid(TextField tf) {
        this.textCreditCardValid = tf;
    }
    private PasswordField passwordNew = new PasswordField();

    public PasswordField getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(PasswordField pf) {
        this.passwordNew = pf;
    }
    private RadioButton radioMale = new RadioButton();

    public RadioButton getRadioMale() {
        return radioMale;
    }

    public void setRadioMale(RadioButton rb) {
        this.radioMale = rb;
    }
   
    private RadioButton radioFemale = new RadioButton();

    public RadioButton getRadioFemale() {
        return radioFemale;
    }

    public void setRadioFemale(RadioButton rb) {
        this.radioFemale = rb;
    }
    private Button buttonSave = new Button();

    public Button getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(Button b) {
        this.buttonSave = b;
    }
    private StaticText staticTextTitle = new StaticText();

    public StaticText getStaticTextTitle() {
        return staticTextTitle;
    }

    public void setStaticTextTitle(StaticText st) {
        this.staticTextTitle = st;
    }
    private PasswordField passwordRepeat = new PasswordField();

    public PasswordField getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(PasswordField pf) {
        this.passwordRepeat = pf;
    }
    private Label labelPasswordRepeat = new Label();

    public Label getLabelPasswordRepeat() {
        return labelPasswordRepeat;
    }

    public void setLabelPasswordRepeat(Label l) {
        this.labelPasswordRepeat = l;
    }
    private StaticText staticTextMessage = new StaticText();

    public StaticText getStaticTextMessage() {
        return staticTextMessage;
    }

    public void setStaticTextMessage(StaticText st) {
        this.staticTextMessage = st;
    }
    private TextArea textLikes = new TextArea();

    public TextArea getTextLikes() {
        return textLikes;
    }

    public void setTextLikes(TextArea ta) {
        this.textLikes = ta;
    }
    private Label labelLikes = new Label();

    public Label getLabelLikes() {
        return labelLikes;
    }

    public void setLabelLikes(Label l) {
        this.labelLikes = l;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ManageAccount() {
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


        // TODO - add your own initialiation code here
        if (this.getSessionBean1().getLogin() == null) 
        {
            try 
            {
                this.getExternalContext().redirect("MainPage.jsp");
            } 
            catch (IOException ex) 
            {
                log.error("Could not redirect to MainPage.jsp!", ex);
            }
        }
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ManageAccount Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        if (!this.isPostBack()) {
            Kunde k = this.getSessionBean1().getLogin();

            this.textBankAccount.setText(k.getKontonr());
            this.textBankNumber.setText(k.getBlz());
            if(k.getGeburtsdatum() != null) this.textBirth.setText(DateFormat.getDateInstance().format(k.getGeburtsdatum()));
            this.textCity.setText(k.getOrt());
            this.textCreditCard.setText(k.getKreditkartennr());
            if(k.getKkgueltigbis() != null) this.textCreditCardValid.setText(DateFormat.getDateInstance().format(k.getKkgueltigbis()));
            this.textEmail.setText(k.getEmail());
            this.textForename.setText(k.getVname());
            this.textLikes.setText(k.getVorlieben());
            this.textPhone.setText(k.getTelnr());
            this.textStreet.setText(k.getStrasse());
            this.textSurname.setText(k.getNname());
            this.textTitle.setText(k.getTitel());
            this.textZIP.setText(k.getPlz());
            
            this.radioFemale.setSelected(k.getGeschlecht().equals("W"));
            this.radioMale.setSelected(k.getGeschlecht().equals("M"));
        }

        this.passwordNew.setPassword(null);
        this.passwordRepeat.setPassword(null);
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
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

    public String buttonSave_action() 
    {        
        if (this.getSessionBean1().getLogin() == null) return "logout";
        
        DateFormat df = DateFormat.getDateInstance();
        Kunde k = new Kunde();
        boolean changePassword = false;
        
        if(this.textBankNumber.getText() != null) k.setBlz(this.textBankNumber.getText().toString());
        else k.setBlz(null);
        
        if(this.textEmail.getText() != null) k.setEmail(this.textEmail.getText().toString());
        else k.setEmail(null);

        try
        {
            if(this.textBirth.getText() != null && !this.textBirth.getText().equals(""))
            {
                k.setGeburtsdatum(df.parse(this.textBirth.getText().toString()));

                if(k.getGeburtsdatum().compareTo(Calendar.getInstance().getTime()) > 0) throw new Exception();
            }
            else
            {
                k.setGeburtsdatum(null);
            }
        } 
        catch (Exception ex) 
        {
            this.staticTextMessage.setText("Es wurde ein ungültiges Geburtsdatum eingegeben!");
            return null;
        }
        
        if(this.textCreditCard.getText() != null) k.setKreditkartennr(this.textCreditCard.getText().toString());
        else k.setKreditkartennr(null);
        
        try
        {
            if(this.textCreditCardValid.getText() != null && !this.textCreditCardValid.getText().equals(""))
            {
                k.setKkgueltigbis(df.parse(this.textCreditCardValid.getText().toString()));

                if(k.getKkgueltigbis().compareTo(Calendar.getInstance().getTime()) < 0) throw new Exception();
            }
            else
            {   
                if(k.getKreditkartennr() == null || k.getKreditkartennr().equals(""))
                    k.setKkgueltigbis(null);
                else
                    throw new Exception();
            }
        } 
        catch (Exception ex) 
        {
            this.staticTextMessage.setText("Es wurde ein ungültiges Kreditkartengültigkeitsdatum eingegeben!");
            return null;
        }
        
        if(this.radioFemale.isChecked()) k.setGeschlecht("W");
        else if(this.radioMale.isChecked()) k.setGeschlecht("M");
        else { this.staticTextMessage.setText("Es wurde kein Geschlecht angegeben!"); return null; }
        
        if(this.textBankAccount.getText() != null) k.setKontonr(this.textBankAccount.getText().toString());
        else k.setKontonr(null);
        
        if(this.textSurname.getText() != null) k.setNname(this.textSurname.getText().toString());
        else k.setNname(null);
        
        if(this.passwordNew.getText() != null && this.passwordNew.getText().equals(this.passwordRepeat.getText()))
        {
            k.setOnlinepwd(this.passwordNew.getText().toString());
            changePassword = true;
        }
        else if(this.passwordNew.getText() != null)
        {
            this.staticTextMessage.setText("Die eingegebenen Passwörter stimmen nicht überein!");
            return null;
        }
        
        if(this.textCity.getText() != null) k.setOrt(this.textCity.getText().toString());
        else k.setOrt(null);
        
        if(this.textZIP.getText() != null) k.setPlz(this.textZIP.getText().toString());
        else k.setPlz(null);
        
        if(this.textStreet.getText() != null) k.setStrasse(this.textStreet.getText().toString());
        else k.setStrasse(null);
        
        if(this.textPhone.getText() != null) k.setTelnr(this.textPhone.getText().toString());
        else k.setTelnr(null);
        
        if(this.textTitle.getText() != null) k.setTitel(this.textTitle.getText().toString());
        else k.setTitel(null);
        
        if(this.textForename.getText() != null) k.setVname(this.textForename.getText().toString());
        else k.setVname(null);
        
        if(this.textLikes.getText() != null) k.setVorlieben(this.textLikes.getText().toString());
        else k.setVorlieben(null);
        
        try
        {
            Kunde loggedIn = this.getSessionBean1().getLogin();
            
            loggedIn.setBlz(k.getBlz());
            loggedIn.setEmail(k.getEmail());
            loggedIn.setGeburtsdatum(k.getGeburtsdatum());
            loggedIn.setGeschlecht(k.getGeschlecht());
            loggedIn.setKkgueltigbis(k.getKkgueltigbis());
            loggedIn.setKontonr(k.getKontonr());
            loggedIn.setKreditkartennr(k.getKreditkartennr());
            loggedIn.setNname(k.getNname());
            if(changePassword) loggedIn.setOnlinepwd(k.getOnlinepwd());
            loggedIn.setOrt(k.getOrt());
            loggedIn.setPlz(k.getPlz());
            loggedIn.setStrasse(k.getStrasse());
            loggedIn.setTelnr(k.getTelnr());
            loggedIn.setTitel(k.getTitel());
            loggedIn.setVname(k.getVname());
            loggedIn.setVorlieben(k.getVorlieben());
            
            KundenHelper.speichern(loggedIn);
            return "saved";
        }
        catch(TicketLineSystemException e)
        {
            this.staticTextMessage.setText("Es trat ein unerwarteter Fehler auf!");
            return null;
        }
        catch(TicketLineException e)
        {
            this.staticTextMessage.setText(e.getMessage());
            return null;
        }
    }

}

