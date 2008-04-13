package ticketline.dao.interfaces;

import ticketline.db.Ort;
import ticketline.db.OrtKey;

/**
 * @author geezmo
 */
public interface OrtDAO extends DAO {

	/**
	 * returns the Ort identified by the ortKey.
	 *
	 * @param ortKey
	 * @return Ort
	 * @throws RuntimeException
	 */
	public Ort get(OrtKey ortKey) throws RuntimeException;

	/**
	 * saves or updates the ort.
	 */
	public void save(Ort ort) throws RuntimeException;

	/**
	 * deletes the ort.
	 *
	 * @param ort
	 * @throws RuntimeException
	 */
	public void remove(Ort ort) throws RuntimeException;
}
