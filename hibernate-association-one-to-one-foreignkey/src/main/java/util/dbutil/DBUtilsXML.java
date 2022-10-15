package util.dbutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.hibernateutil.HibernateUtil_Xml;

public class DBUtilsXML {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction = null;

	public DBUtilsXML() {
		sessionFactory = HibernateUtil_Xml.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}

	public void create(Object o) {
		transaction.begin();
		session.save(o);
		transaction.commit();
	}
}
