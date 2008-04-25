package ticketline.dao.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ticketline.dao.interfaces.AuffuehrungDAO;
import ticketline.db.Auffuehrung;
import ticketline.db.AuffuehrungKey;

/**
 * Hibernate-Klasse fuer die Auffuehrung.
 *
 * @author geezmo
 */
public class AuffuehrungDAOHibernate implements AuffuehrungDAO {

	/**
	 *
	 * @see ticketline.dao.interfaces.AuffuehrungDAO#get(ticketline.db.AuffuehrungKey)
	 */
	public Auffuehrung get(AuffuehrungKey auffuehrungKey) {
		Auffuehrung newObject = null;

		try {
			Session session = HibernateSessionFactory.currentSession();
			newObject = (Auffuehrung) session.load(Auffuehrung.class,
					auffuehrungKey);
		} catch (HibernateException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}

		return newObject;
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.AuffuehrungDAO#getAll()
	 */
	public List getAll() {
		List list = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			list = session.createQuery("from " + Auffuehrung.class.getName())
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
	 * @see ticketline.dao.interfaces.AuffuehrungDAO#save(ticketline.db.Auffuehrung)
	 */
	public void save(Auffuehrung auffuehrung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.saveOrUpdate(auffuehrung);
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
	 * @see ticketline.dao.interfaces.AuffuehrungDAO#remove(ticketline.db.Auffuehrung)
	 */
	public void remove(Auffuehrung auffuehrung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.delete(auffuehrung);
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
	 * @see ticketline.dao.interfaces.DAO#find(java.lang.String)
	 */
	public List find(String where) {
		List list = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			list = session.createQuery(
					"from " + Auffuehrung.class.getName() + " where " + where)
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
