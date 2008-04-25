package ticketline.dao.interfaces;

import ticketline.db.Mitarbeiter;

/**
 * @author geezmo
 */
public interface MitarbeiterDAO extends DAO {

	/**
	 * returns the Mitarbeiter identified by the kartennr.
	 *
	 * @param kartennr
	 * @return Mitarbeiter
	 * @throws RuntimeException
	 */
	public Mitarbeiter get(Integer kartennr) throws RuntimeException;

	/**
	 * saves or updates the mitarbeiter.
	 */
	public void save(Mitarbeiter mitarbeiter) throws RuntimeException;

	/**
	 * deletes the mitarbeiter.
	 *
	 * @param mitarbeiter
	 * @throws RuntimeException
	 */
	public void remove(Mitarbeiter mitarbeiter) throws RuntimeException;
}
