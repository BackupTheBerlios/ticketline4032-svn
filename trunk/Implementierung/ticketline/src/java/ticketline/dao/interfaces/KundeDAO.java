package ticketline.dao.interfaces;

import ticketline.db.Kunde;

/**
 * @author geezmo
 */
public interface KundeDAO extends DAO {

	/**
	 * returns the Kunde identified by the kartennr.
	 *
	 * @param kartennr
	 * @return Kunde
	 * @throws RuntimeException
	 */
	public Kunde get(Integer kartennr) throws RuntimeException;

	/**
	 * saves or updates the kunde.
	 *
	 * @param kunde
	 * @throws RuntimeException
	 */
	public void save(Kunde kunde) throws RuntimeException;

	/**
	 * deletes the kunde.
	 *
	 * @param kunde
	 * @throws RuntimeException
	 */
	public void remove(Kunde kunde) throws RuntimeException;
}
