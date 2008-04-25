package ticketline.dao.interfaces;

import ticketline.db.Auffuehrung;
import ticketline.db.AuffuehrungKey;

/**
 * @author geezmo
 */
public interface AuffuehrungDAO extends DAO {

	/**
	 * @param auffuehrungKey
	 * @return Auffuehrung
	 * @throws RuntimeException
	 */
	public Auffuehrung get(AuffuehrungKey auffuehrungKey)
			throws RuntimeException;

	/**
	 * saves or updates the auffuehrung.
	 */
	public void save(Auffuehrung auffuehrung) throws RuntimeException;

	/**
	 * deletes the auffuehrung.
	 *
	 * @param auffuehrung
	 * @throws RuntimeException
	 */
	public void remove(Auffuehrung auffuehrung) throws RuntimeException;

}
