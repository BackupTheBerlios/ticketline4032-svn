package ticketline.dao.interfaces;

import ticketline.db.Transaktion;
import ticketline.db.TransaktionKey;

/**
 * @author geezmo
 */
public interface TransaktionDAO extends DAO {

	/**
	 * returns the Transaktion identified by the transaktionKey.
	 *
	 * @param transaktionKey
	 * @return Transaktion
	 * @throws RuntimeException
	 */
	public Transaktion get(TransaktionKey transaktionKey)
			throws RuntimeException;

	/**
	 * saves or updates the transaktion.
	 */
	public void save(Transaktion transaktion) throws RuntimeException;

	/**
	 * deletes the transaktion.
	 *
	 * @param transaktion
	 * @throws RuntimeException
	 */
	public void remove(Transaktion transaktion) throws RuntimeException;
}
