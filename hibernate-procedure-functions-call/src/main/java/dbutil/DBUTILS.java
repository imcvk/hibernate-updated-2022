package dbutil;

import entities.Employee;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import util.HibernateUtil;

import java.sql.Connection;
import java.util.List;

public class DBUTILS {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction = null;
	Connection connection = null;

	public DBUTILS() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = HibernateUtil.getSession();
		transaction = session.getTransaction();
	}

	public void create(Employee e) {
		transaction.begin();
		session.persist(e);
		transaction.commit();
	}

	public void runProc() {
		ProcedureCall procedureCall = new ProcedureCall();
		try {
			connection = sessionFactory.
					getSessionFactoryOptions().getServiceRegistry().
					getService(ConnectionProvider.class).getConnection();
			procedureCall.execute(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
