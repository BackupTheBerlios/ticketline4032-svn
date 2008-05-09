package ticketline.dao.interfaces;

import java.util.Date;
import ticketline.db.News;

/**
 * @author Michael Morak
 */
public interface NewsDAO extends DAO {

	public News get(Date erstellt) throws RuntimeException;

	public void save(News n) throws RuntimeException;

	public void remove(News n) throws RuntimeException;
}
