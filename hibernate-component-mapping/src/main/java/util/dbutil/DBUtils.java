package util.dbutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.hibernateutil.HibernateUtil_Annotations;

public class DBUtils {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction = null;

	public DBUtils() {
//		sessionFactory = HibernateUtil_Xml.getSessionFactory();
		sessionFactory = HibernateUtil_Annotations.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}

	public void create(Object o) {
		transaction.begin();
		session.save(o);
		transaction.commit();
	}
}
