package ticketline.dao.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ticketline.dao.interfaces.VeranstaltungDAO;
import ticketline.db.Veranstaltung;
import ticketline.db.VeranstaltungKey;

/**
 * Hibernate-Klasse fuer die Veranstaltung.
 *
 * @author geezmo
 */
public class VeranstaltungDAOHibernate implements VeranstaltungDAO {

	/**
	 *
	 * @see ticketline.dao.interfaces.VeranstaltungDAO#get(ticketline.db.VeranstaltungKey)
	 */
	public Veranstaltung get(VeranstaltungKey veranstaltungKey) {
		Veranstaltung newObject = null;

		try {
			Session session = HibernateSessionFactory.currentSession();
			newObject = (Veranstaltung) session.load(Veranstaltung.class,
					veranstaltungKey);
		} catch (HibernateException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			// HibernateSessionFactory.closeSession();
		}

		return newObject;
	}

	/**
	 *
	 * @see ticketline.dao.interfaces.VeranstaltungDAO#getAll()
	 */
	public List getAll() {
		List list = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			list = session.createQuery("from " + Veranstaltung.class.getName())
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
	 * @see ticketline.dao.interfaces.VeranstaltungDAO#save(ticketline.db.Veranstaltung)
	 */
	public void save(Veranstaltung veranstaltung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.saveOrUpdate(veranstaltung);
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
	 * @see ticketline.dao.interfaces.VeranstaltungDAO#remove(ticketline.db.Veranstaltung)
	 */
	public void remove(Veranstaltung veranstaltung) {
		try {
			Session session = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();
			session.delete(veranstaltung);
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
			list = session
					.createQuery(
							"from " + Veranstaltung.class.getName() + " where "
									+ where).list();
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
