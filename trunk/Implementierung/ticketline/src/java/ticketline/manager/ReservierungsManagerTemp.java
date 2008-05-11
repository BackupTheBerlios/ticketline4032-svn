/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketline.manager;

import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticketline.dao.DAOFactory;
import ticketline.dao.interfaces.BestellungDAO;
import ticketline.dao.interfaces.TransaktionDAO;
import ticketline.db.Bestellung;
import ticketline.db.BestellungKey;
import ticketline.db.Kunde;
import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;
import ticketline.exceptions.TicketLineException;
import ticketline.exceptions.TicketLineSystemException;
import ticketline.helper.SystemHelper;

/**
 *
 * @author Not Needed
 */
public class ReservierungsManagerTemp {

    // ACHTUNG LOGGER DEFININITION FUER TEMP KLASSE ERSTELLT 
    private static final Logger log = LogManager.getLogger(ReservierungsManagerTemp.class);

    public static List<Transaktion> sucheReservierungen(Kunde k, Date zeitVon, Date zeitBis, String reihenBezeichnung,
	    String kategorieBezeichnung, String saalBezeichnung,
	    String ortsBezeichnung, String ort) throws TicketLineException, TicketLineSystemException {
	try {
	    TransaktionDAO transaktion = DAOFactory.getTransaktionDAO();

	    Kunde kunde = null;

	    java.sql.Date sqlZeitVon = null;
	    java.sql.Date sqlZeitBis = null;

	    if (k != null) {
		kunde = k;
	    }

	    if (zeitVon != null) {
		sqlZeitVon = java.sql.Date.valueOf(zeitVon.toString());
	    }

	    if (zeitBis != null) {
		sqlZeitBis = java.sql.Date.valueOf(zeitBis.toString());
	    }

	    String query = "1=1 ";

	    if (kunde != null) {
		query += "AND LOWER(kartennr) = '" + SystemHelper.validateInput(kunde.getKartennr().toString()) + "' ";
	    }

	    if (zeitVon != null && zeitBis != null) {
		query += "AND datumuhrzeit BETWEEN '" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' AND '" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
	    }
	    if (zeitVon != null && !(zeitBis != null)) {
		query += "AND datumuhrzeit >'" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' ";
	    }
	    if (!(zeitVon != null) && zeitBis != null) {
		query += "AND datumuhrzeit <'" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
	    }


	    if (reihenBezeichnung != null) {
		query += "AND LOWER(reihebez) like '%" + SystemHelper.validateInput(reihenBezeichnung) + "%' ";
	    }
	    if (kategorieBezeichnung != null) {
		query += "AND LOWER(kategoriebez) like '%" + SystemHelper.validateInput(kategorieBezeichnung) + "%' ";
	    }
	    if (saalBezeichnung != null) {
		query += "AND LOWER(saalbez) like '%" + SystemHelper.validateInput(saalBezeichnung) + "%' ";
	    }
	    if (ortsBezeichnung != null) {
		query += "AND LOWER(ortbez) like '%" + SystemHelper.validateInput(ortsBezeichnung) + "%' ";
	    }
	    if (ort != null) {
		query += "AND LOWER(ort) like '%" + SystemHelper.validateInput(ort) + "%' ";
	    }

	    List list = transaktion.find(query);

	    log.info("Executing: " + query);
//		log.info("Executing: " + list);
	    return list;

	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}
    }

    public static void kaufeWerbematerial(Kunde kunde, Bestellung bestellung) throws TicketLineException, TicketLineSystemException {
	
	try {
	    if(kunde != null && bestellung != null){
	    BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
	    bestellung.setKunde(kunde);
	    
	    log.info("Executing: " + bestellung);
	    bestellungDAO.save(bestellung);
	    } else log.info("Missing entity");
	    
	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}


    }

    public static void kaufeReservierung(Transaktion transaktion) throws TicketLineException, TicketLineSystemException {

	try {
	    if (transaktion == null){
	    TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
	
	    transaktion.setVerkauft(true);
	    
	    log.info("Executing: " + transaktion);
	    transaktionDAO.save(transaktion);
	    } else log.info("Missing entity (transaktion)");
	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}
	
    }

    public static void storniereReservierung(Transaktion transaktion) throws TicketLineException, TicketLineSystemException {

	try {
	    TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
	
	    transaktion.setStorniert(true);
	    
	    log.info("Executing: " + transaktion);
	    transaktionDAO.save(transaktion);
	    
	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}
	
    }

    //    
//    public static void storniereVerkauf(BestellungKey bestellung) throws TicketLineException, TicketLineSystemException {
//	
//	try {
//	    BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
//	    bestellung.
//	    
//	    log.info("Executing: " + bestellung);
//	    bestellungDAO.save(bestellung);
//	    
//	} catch (RuntimeException e) {
//	    throw new TicketLineSystemException("Error during database access!", e);
//	}
//
//
//    }
}

    
    
// KAUFE WERBEMATERIAL: SO NICHT!
//	    if (kunde != null && bestellung != null) {
//		
//		String menge = new Integer(bestellung.getMenge()).toString();
//		
//		if (bestellung.getComp_id().getDatumuhrzeit() != null && bestellung.getArtikel().getArtikelnr() != null && kunde.getKartennr() != null && menge != null && bestellung.getZahlart() != null) {
//		    BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
//
//		    java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(bestellung.getComp_id().getDatumuhrzeit().toString());
//		    String datumuhrzeit = timestamp.toString();
//		    String artikelnr = bestellung.getArtikel().getArtikelnr().toString();
//		    String kartennr = kunde.getKartennr().toString();
//		    
//		    String zahlart = bestellung.getZahlart();
//
//
//		    String query = "INSERT INTO bestellung (datumuhrzeit, artikelnr, kartennr, menge, zahlart) " +
//			    "VALUES ('" + datumuhrzeit + "','" + artikelnr + "','" + kartennr + "','" + menge + "','" + zahlart + "')";

//       create table bestellung (datumuhrzeit timestamp not null, artikelnr integer not null, kartennr integer not null, menge integer not null, zahlart varchar(20) not null, primary key (datumuhrzeit, artikelnr, kartennr));

    
//    try {

//transaktion (datumuhrzeit timestamp not null, kundennr integer not null, mitarbeiternr integer not null, verkauft bit not null, 
//	storniert bit not null, resnr integer, preis numeric not null, startplatz integer not null, anzplaetze integer not null, 
//	zahlart varchar(20), reihebez varchar(30), kategoriebez varchar(30), saalbez varchar(30), ortbez varchar(30), ort varchar(30), 
//	auffdatumuhrzeit timestamp, verkaufsstelle varchar(30), verkaufsort varchar(30), kartennr integer, primary key (datumuhrzeit, 
//	kundennr, mitarbeiternr), unique (resnr));

	
// KAUFE RESERVIERUNG SO NICHT	
//	    if (transaktion.getMitarbeiternr().toString() != null && transaktion.getKundennr() != null && transaktion.getDatumuhrzeit() != null) {
//		TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
//
//		String mitarbeiternr = transaktion.getMitarbeiternr().toString();
//		String kundennr = transaktion.getKundennr().toString();
//
//		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(transaktion.getDatumuhrzeit().toString());
//		String datumuhrzeit = timestamp.toString();
//
//		String query = "UPDATE transaktion WHERE datumuhrzeit = '" + datumuhrzeit +
//			"', AND kundennr = '" + kundennr + "', AND mitarbeiternr = '" + mitarbeiternr + "'";
//
//		log.info("Executing: " + query);
//		
//	    } else {
//		log.error("'NOT NULLABLE' attribute was can't get set to NULL");
//	    }
//
//
//	} catch (RuntimeException e) {
//	    throw new TicketLineSystemException("Error during database access!", e);
//	}
//
//
//
//    }