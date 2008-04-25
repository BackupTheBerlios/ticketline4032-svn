package ticketline.dao.interfaces;

import ticketline.db.Saal;
import ticketline.db.SaalKey;

/**
 * @author geezmo
 */
public interface SaalDAO extends DAO {

	/**
	 * returns the Saal identified by the key.
	 *
	 * @param key
	 * @return Saal
	 * @throws RuntimeException
	 */
	public Saal get(SaalKey key) throws RuntimeException;

	/**
	 * saves or updates the saal.
	 */
	public void save(Saal saal) throws RuntimeException;

	/**
	 * returns the void identified by the saal.
	 *
	 * @param saal
	 * @throws RuntimeException
	 */
	public void remove(Saal saal) throws RuntimeException;
}
