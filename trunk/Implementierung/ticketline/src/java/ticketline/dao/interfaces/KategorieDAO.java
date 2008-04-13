package ticketline.dao.interfaces;

import ticketline.db.Kategorie;
import ticketline.db.KategorieKey;

/**
 * @author geezmo
 */
public interface KategorieDAO extends DAO {

	/**
	 * returns the Kategorie identified by the kategorieKey.
	 *
	 * @param kategorieKey
	 * @return Kategorie
	 * @throws RuntimeException
	 */
	public Kategorie get(KategorieKey kategorieKey) throws RuntimeException;

	/**
	 * saves or updates the kategorie.
	 */
	public void save(Kategorie kategorie) throws RuntimeException;

	/**
	 * deletes the kategorie.
	 *
	 * @param kategorie
	 * @throws RuntimeException
	 */
	public void remove(Kategorie kategorie) throws RuntimeException;
}
