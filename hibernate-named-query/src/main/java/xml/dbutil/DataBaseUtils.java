package xml.dbutil;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import xml.entities.EmployeeNamedQueries;
import xml.util.HibernateUtil;

import java.util.Arrays;
import java.util.List;

public class DataBaseUtils {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction;

	public DataBaseUtils() {
		sessionFactory = HibernateUtil.getSessionFactory_xml();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();

	}

	public void create(Object o) {
		transaction.begin();
		session.persist(o);
		transaction.commit();
	}

	public void executeNamedQuery_HQL() {
		Query query = session.getNamedQuery("hql_query");
		query.setParameter(1, 12);
		List<EmployeeNamedQueries> employeeNamedQueries = query.getResultList();
		employeeNamedQueries.forEach(System.out::println);
	}

	public void executeNamedQuery_Native_SQL() {
		Query query = session.getNamedQuery("native_sql_query");
		query.setParameter(1, 11);
		List<Object[]> list = query.getResultList();
		for (Object[] user : list) {
			System.out.println(Arrays.stream(user).toList());
		}
	}

}
