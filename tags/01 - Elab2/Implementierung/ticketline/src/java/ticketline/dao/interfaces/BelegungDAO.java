package ticketline.dao.interfaces;

import ticketline.db.Belegung;
import ticketline.db.BelegungKey;

/**
 * @author geezmo
 */
public interface BelegungDAO extends DAO {

	/**
	 * @param belegungKey
	 * @return Belegung
	 * @throws RuntimeException
	 */
	public Belegung get(BelegungKey belegungKey) throws RuntimeException;

	/**
	 * saves or updates the belegung.
	 */
	public void save(Belegung belegung) throws RuntimeException;

	/**
	 * deletes the belegung.
	 *
	 * @param belegung
	 * @throws RuntimeException
	 */
	public void remove(Belegung belegung) throws RuntimeException;

}
