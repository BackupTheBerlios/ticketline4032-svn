/*
 * SearchResultVeranstaltungen.java
 *
 * Created on 23.04.2008, 17:12:15
 */
 
package ticketline;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import ticketline.db.Belegung;
import ticketline.db.Reihe;
import ticketline.db.ReiheKey;
import ticketline.db.SaalKey;
import ticketline.exceptions.TicketLineException;
import ticketline.helper.SaalHelper;
import ticketline.manager.ReservierungsManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Chris
 */
public class PlatzAuswahl extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        anzahlDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "1 Platz"), new com.sun.webui.jsf.model.Option("2", "2 Plätze"), new com.sun.webui.jsf.model.Option("3", "3 Plätze"), new com.sun.webui.jsf.model.Option("4", "4 Plätze"), new com.sun.webui.jsf.model.Option("5", "5 Plätze"), new com.sun.webui.jsf.model.Option("6", "6 Plätze")});
        zahlartDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("Kreditkarte", "Kreditkarte"),new com.sun.webui.jsf.model.Option("Bar", "Bar"), new com.sun.webui.jsf.model.Option("PayPal", "PayPal")});
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
    private StaticText staticTextTitle = new StaticText();

    public StaticText getStaticTextTitle() {
        return staticTextTitle;
    }

    public void setStaticTextTitle(StaticText st) {
        this.staticTextTitle = st;
    }
    private HtmlOutputText outputText2 = new HtmlOutputText();

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setOutputText2(HtmlOutputText hot) {
        this.outputText2 = hot;
    }
    private HtmlOutputText outputText4 = new HtmlOutputText();

    public HtmlOutputText getOutputText4() {
        return outputText4;
    }

    public void setOutputText4(HtmlOutputText hot) {
        this.outputText4 = hot;
    }
    private HtmlOutputText outputText6 = new HtmlOutputText();

    public HtmlOutputText getOutputText6() {
        return outputText6;
    }

    public void setOutputText6(HtmlOutputText hot) {
        this.outputText6 = hot;
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
    private ImageComponent image1 = new ImageComponent();

    public ImageComponent getImage1() {
        return image1;
    }

    public void setImage1(ImageComponent ic) {
        this.image1 = ic;
    }
    private DropDown anzahl = new DropDown();

    public DropDown getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(DropDown dd) {
        this.anzahl = dd;
    }
    private SingleSelectOptionsList anzahlDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getAnzahlDefaultOptions() {
        anzahlDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "1 Platz"), new com.sun.webui.jsf.model.Option("2", "2 Plätze"), new com.sun.webui.jsf.model.Option("3", "3 Plätze"), new com.sun.webui.jsf.model.Option("4", "4 Plätze"), new com.sun.webui.jsf.model.Option("5", "5 Plätze"), new com.sun.webui.jsf.model.Option("6", "6 Plätze")});
       
        return anzahlDefaultOptions;
    }

    public void setAnzahlDefaultOptions(SingleSelectOptionsList ssol) {
        this.anzahlDefaultOptions = ssol;
    }
    private HiddenField startplatz = new HiddenField();

    public HiddenField getStartplatz() {
        return startplatz;
    }

    public void setStartplatz(HiddenField hf) {
        this.startplatz = hf;
    }
    private DropDown zahlart = new DropDown();

    public DropDown getZahlart() {
        return zahlart;
    }

    public void setZahlart(DropDown dd) {
        this.zahlart = dd;
    }
    private SingleSelectOptionsList zahlartDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getZahlartDefaultOptions() {
    
        zahlartDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("Kreditkarte", "Kreditkarte"),new com.sun.webui.jsf.model.Option("Bar", "Bar"), new com.sun.webui.jsf.model.Option("PayPal", "PayPal")});
        return zahlartDefaultOptions;
    }

    public void setZahlartDefaultOptions(SingleSelectOptionsList ssol) {
        this.zahlartDefaultOptions = ssol;
    }
    private DropDown dropDown1 = new DropDown();

    public DropDown getDropDown1() {
        return dropDown1;
    }

    public void setDropDown1(DropDown dd) {
        this.dropDown1 = dd;
    }
    private SingleSelectOptionsList dropDown1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDown1DefaultOptions() {
        return dropDown1DefaultOptions;
    }

    public void setDropDown1DefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDown1DefaultOptions = ssol;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PlatzAuswahl() {
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
            log("SearchResultVeranstaltungen Initialization Failure", e);
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

    public String button2_action() throws TicketLineException {
                String clicked=this.getStartplatz().getValue().toString();
        String split[]=clicked.split(":");
        SessionBean1 sb=this.getSessionBean1();
       SaalKey sk=sb.getRes().getSaal().getComp_id();
try{
       this.getRequestBean1().setTransaktion(ReservierungsManager.kaufeTickets(sb.getLogin(), 
                new Date(System.currentTimeMillis()), 
                sb.getRes().getComp_id(),
                new ReiheKey(split[1],split[0],sk.getBezeichnung(),sk.getOrtbez(),sk.getOrt()), new Integer(split[2]), 
                new Integer(this.getAnzahl().getValue().toString()),
                this.getZahlart().getValue().toString()       , false));
    
        return "buy";
}catch(Exception e){
    
    return "stay";
}
    }

    public String button1_action() throws TicketLineException {
    try{
        String clicked=this.getStartplatz().getValue().toString();
        String split[]=clicked.split(":");
        SessionBean1 sb=this.getSessionBean1();
       SaalKey sk=sb.getRes().getSaal().getComp_id();
        this.getRequestBean1().setTransaktion(ReservierungsManager.kaufeTickets(sb.getLogin(), 
                new Date(System.currentTimeMillis()), 
                sb.getRes().getComp_id(),
                new ReiheKey(split[1],split[0],sk.getBezeichnung(),sk.getOrtbez(),sk.getOrt()), new Integer(split[2]), 
                new Integer(this.getAnzahl().getValue().toString()),
                this.getZahlart().getValue().toString()       , true));
        return "book";
    }
    catch(Exception e){
        return "stay";
    }
    }
    
    private String platzformat;

    public String getPlatzformat() throws TicketLineException {
        try{
        List<Reihe> l=SaalHelper.sucheAlleReihen(this.getRequestBean1().getAuffuehrung().getSaal().getComp_id());
        List<Belegung> bl = ReservierungsManager.sucheBelegungen(this.getRequestBean1().getAuffuehrung().getComp_id());
        this.getSessionBean1().setRes(this.getRequestBean1().getAuffuehrung());
        if(l == null)
            return "Keine Plätze gefunden!";
        
        Iterator<Reihe> i=l.iterator();
        Iterator<Belegung> ib=bl.iterator();
        String ret="<table style='left: 20px; top: 100px; position: absolute'>";
        String akt=null,prev="";
        int col=10;
        while(i.hasNext()){
            Reihe r=i.next();
            Belegung b=ib.next();
            akt=r.getKategorie().getComp_id().getBezeichnung();
                if(!prev.equals(akt)){
                    prev=akt;
                    ret+="<tr/>";
                    col=(col+10)%90+10;
                }
                ret+="<tr>";
                ret+="<th style='width:100px; background-color:#"+col+"C0"+col+"'>"+r.getKategorie().getComp_id().getBezeichnung()+"</th>";
                ret+="<th style='width:100px; background-color:#"+col+"C0"+col+"'>"+r.getComp_id().getBezeichnung()+"</th>";
               for(int i2=1;i2<=r.getAnzplaetze();i2++){
                   if(b.getBelegung().substring(i2-1,i2).equals("F")){
                     ret+="<td style='background-color:#F0F0F0;'>"+
                           "<input  onClick='resClick(this)' style='height:10px;width:10px;' type='radio' class='Radio' name='abutton' "
                            + "value='"+r.getKategorie().getComp_id().getBezeichnung()+":"+r.getComp_id().getBezeichnung()+":"+i2+"'"
                            + "/>" 
                            + "</td>" ;
                   }
                   
                   else{
                    ret+="<td style='background-color:#F0F0F0;'>"+
                            b.getBelegung().substring(i2-1,i2)
                            +"</td>";
                   }
                }
                ret+="</tr>";
            }
            
        ret+="</table>";
          
        ret="<script type='text/javascript'>"
                +"function debuttons(ak){"
                +"document.getElementById('form1:button1').disabled=ak; "
                +"document.getElementById('form1:button2').disabled=ak; "
                +"}"
                +"function resClick(element) {"
                +"debuttons(false);"
                +"var tds=document.getElementsByTagName('td');"
                +"for(var k=0;k<tds.length;k++){ "
                +"tds[k].style.backgroundColor='#F0F0F0';"
                +"}"
                +"var anzahl=document.getElementById('form1:anzahl_list');"
                +"var startplatz=document.getElementById('form1:startplatz');"
                +"startplatz.setAttribute('value',element.getAttribute('value'));"
                
                 +"var count=parseInt(anzahl.options[anzahl.selectedIndex].value);" 
                 +"element=element.parentNode;"
                 +"for(var z=0;z<count;z++){"
                 +"if(element==null){alert('Ausserhalb des Bereichs');debuttons(true);}"
                 +"else if(element.tagName!='TD'){alert('Ausserhalb des Bereichs');debuttons(true);}"
                 +"else if(element.firstChild.tagName!='INPUT'){alert('Reserviert');debuttons(true); }"
                 
                +"element.style.backgroundColor = '#cc0000';"
                 +"element=element.nextSibling;"
                +"}}"
                
                +"</script>"
                +ret;
        
        return ret;
        }catch(Exception e){
            return "<div style='left: 20px; top: 160px; position: absolute'><h2 >Fehler</h2>"+e+"</div>";
        }
    }

    public void setPlatzformat(String platzformat) {
        this.platzformat = platzformat;
    }

    public void anzahl_processValueChange(ValueChangeEvent event) {
    }
    
    
}


