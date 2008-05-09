package ticketline.db;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class News extends Entity implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1457673923412787298L;

	/** identifier field */
	private Date erstellt;

	/** persistent field */
	private Date gueltig;

	/** nullable persistent field */
	private String titel;

	/** nullable persistent field */
	private String inhalt;

	/** full constructor */
	public News(Date erstellt, Date gueltig, String inhalt, String titel) {
		this.erstellt = erstellt;
                this.gueltig = gueltig;
                this.titel = titel;
                this.inhalt = inhalt;
	}

	/** default constructor */
	public News() {
		// do nothing
	}

	public Date getErstellt() {
		return this.erstellt;
	}

	public void setErstellt(Date erstellt) {
		this.erstellt = erstellt;
	}
        
        public Date getGueltig() {
		return this.gueltig;
	}

	public void setGueltig(Date gueltig) {
		this.gueltig = gueltig;
	}

	public String getTitel() {
		return this.titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
        
        public String getInhalt() {
		return this.inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

        public String toString() {
		return new ToStringBuilder(this).toString();
	}

}
