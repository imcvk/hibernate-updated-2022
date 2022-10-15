package usingannotations.dbutil;

import usingannotations.entities.EmployeeNamedQueryAnnotation;
import usingannotations.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class DBUtils_Annotations {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction;

	public DBUtils_Annotations() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();

	}

	public void create(Object o) {
		transaction.begin();
		session.persist(o);
		transaction.commit();
	}

	public void runNamedQueries_HQL() {
		Query query = session.createNamedQuery("getAllEmployeeshql");
		List<EmployeeNamedQueryAnnotation> employeeNamedQueries = query.getResultList();
		System.out.println(employeeNamedQueries);
	}

	public void runNamedQueries_Native() {
		Query query = session.createNamedQuery("getAllEmployeesNative");
		List<Object[]> list = query.getResultList();
		for (Object[] user : list) {
			System.out.println(Arrays.stream(user).toList());
		}
	}
}
