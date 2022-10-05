package util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DB_Operations {
	Session session = null;
	Transaction transaction = null;

	public void createRecord(Object o) {
		session = HibernateUtil.getSessionFactoryForXmlCfg().openSession();
		transaction = session.beginTransaction();
		session.persist(o);
		transaction.commit();
		session.close();
	}
}
