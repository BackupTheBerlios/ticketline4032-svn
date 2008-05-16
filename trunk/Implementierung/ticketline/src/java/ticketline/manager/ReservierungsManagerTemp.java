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

	    if (zeitVon != null) {
		sqlZeitVon = new java.sql.Date(zeitVon.getTime());
	    }

	    if (zeitBis != null) {
		sqlZeitBis = new java.sql.Date(zeitBis.getTime());
	    }

	    String query = "1=1 ";

	    if (k != null) {
		query += "AND LOWER(kartennr) = '" + SystemHelper.validateInput(k.getKartennr().toString()) + "' ";
	    }

	    if (sqlZeitVon != null && sqlZeitBis != null) {
		query += "AND datumuhrzeit BETWEEN '" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' AND '" + SystemHelper.validateInput(sqlZeitBis.toString()) + "' ";
	    }
	    if (sqlZeitVon != null && !(sqlZeitBis != null)) {
		query += "AND datumuhrzeit >'" + SystemHelper.validateInput(sqlZeitVon.toString()) + "' ";
	    }
	    if (!(sqlZeitVon != null) && sqlZeitBis != null) {
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
		query += "AND LOWER(ort.comp_id.ort) like '%" + SystemHelper.validateInput(ort) + "%' ";
	    }

	    log.info("Executing: " + query);
	    
	    List list = transaktion.find(query);

	    return list;

	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}
    }

    public static void kaufeWerbematerial(Kunde kunde, Bestellung bestellung) throws TicketLineException, TicketLineSystemException {

	try {
	    if (kunde != null && bestellung != null) {
		BestellungDAO bestellungDAO = DAOFactory.getBestellungDAO();
		bestellung.setKunde(kunde);

		log.info("Executing: " + bestellung);
		bestellungDAO.save(bestellung);
	    } else {
		log.info("Missing entity");
	    }

	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}


    }

    public static void kaufeReservierung(TransaktionKey transaktionKey) throws TicketLineException, TicketLineSystemException {

	try {
	    if (transaktionKey != null) {

		TransaktionDAO transaktionDAO = DAOFactory.getTransaktionDAO();

		Transaktion transaktion = new Transaktion();
		transaktion.setComp_id(transaktionKey);
		transaktion.setVerkauft(true);

		log.info("Executing: " + transaktion);
		transaktionDAO.save(transaktion);

	    } else {
		log.info("Missing entity (transaktionKey)");
	    }
	} catch (RuntimeException e) {
	    throw new TicketLineSystemException("Error during database access!", e);
	}

    }
}
