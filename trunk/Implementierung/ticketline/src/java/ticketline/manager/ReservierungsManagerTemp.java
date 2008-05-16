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
	    log.info("Executing: ");
	    
	    java.sql.Date sqlZeitVon = null;
	    java.sql.Date sqlZeitBis = null;
log.info("Executing: ");
//	    if (k != null) {
//		Kunde kunde = k;
//	    }
log.info("Executing: ");	    
	    log.info(zeitVon);
	    log.info(zeitBis);
/**
	    if (zeitVon != null) {
		log.info(sqlZeitVon = java.sql.Date.valueOf(zeitVon.toString()));
	    }
log.info("Executing: ");
	    if (zeitBis != null) {
		sqlZeitBis = java.sql.Date.valueOf(zeitBis.toString());
	    }
log.info("Executing: ");
 * 
 * */
	    String query = "1=1 ";
	    
	    log.info("Executing: " + query);
	    
	    if (k != null) {
		query += "AND LOWER(kartennr) = '" + SystemHelper.validateInput(k.getKartennr().toString()) + "' ";
	    }
// Hier liegt der hund auch begraben
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
	    // HIER LIEGT DER HUND BEGRABEN
	    if (ort != null) {
		query += "AND LOWER(ort) like '%" + SystemHelper.validateInput(ort) + "%' ";
	    }

	    	log.info("Executing: " + query);
		log.info(transaktion.find(query));	
	    List list = transaktion.find(query);

	    log.info("Executing: " + query);
		log.info("Executing: " + list);
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

    public static void kaufeReservierung(TransaktionKey transaktionKey) throws TicketLineException, TicketLineSystemException {

	try {
	    if (transaktionKey != null){
	    
		TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();
	
		Transaktion transaktion = new Transaktion();
		transaktion.setComp_id(transaktionKey);
		transaktion.setVerkauft(true);
	    
		log.info("Executing: " + transaktion);
		transaktionDAO.save(transaktion);
		
	    } else log.info("Missing entity (transaktionKey)");
	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}
	
    }

}
