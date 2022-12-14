package annotation.util.dbutil;

import annotation.util.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBUtils {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction = null;

	public DBUtils() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}

	public void create(Object o) {
		transaction.begin();
		session.persist(o);
		transaction.commit();
	}
}
