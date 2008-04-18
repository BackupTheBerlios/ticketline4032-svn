package ticketline.dao.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ticketline.dao.interfaces.BelegungDAO;
import ticketline.db.Belegung;
import ticketline.db.BelegungKey;

/**
 * Hibernate-Klasse fuer die Belegung.
 *
 * @author geezmo
 */
public class BelegungDAOHibernate implements BelegungDAO {

	/**
	 *
	 * @see ticketline.dao.interfaces.BelegungDAO#get(ticketline.db.BelegungKey)
	 */
	public Belegung get(BelegungKey belegungKey) {
		Belegung newObject = null;

		try {
			Session session = HibernateSessionFactory.currentSession();
			newObject = (Belegung) session.load(Belegung.class, belegungKey);
		} catch (HibernateException e) {

			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}

		return newObject;
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.BelegungDAO#getAll()
	 */
	public List getAll() {
		List list = null;
		try {
			Session session = HibernateSessionFactory.currentSession();

			list = session.createQuery("from " + Belegung.class.getName())
					.list();

		} catch (HibernateException e) {

			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return list;
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.BelegungDAO#save(ticketline.db.Belegung)
	 */
	public void save(Belegung belegung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.saveOrUpdate(belegung);
			HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			HibernateSessionFactory.rollbackTransaction();
			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.BelegungDAO#remove(ticketline.db.Belegung)
	 */
	public void remove(Belegung belegung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.delete(belegung);
			HibernateSessionFactory.commitTransaction();
			session.flush();
		} catch (HibernateException e) {
			HibernateSessionFactory.rollbackTransaction();
			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.DAO#find(java.lang.String)
	 */
	public List find(String where) {
		List list = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			list = session.createQuery(
					"from " + Belegung.class.getName() + " where " + where)
					.list();

		} catch (HibernateException e) {

			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}

		return list;
	}

	public Set initSet(Set set) {
		try {
			Hibernate.initialize(set);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return set;
	}

}
