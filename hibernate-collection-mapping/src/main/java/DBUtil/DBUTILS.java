package DBUtil;

import entities.Employee;
import entities.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DBUTILS {
	public static Session session = null;
	public static Transaction transaction = null;
	public static Query query = null;

	public DBUTILS() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	public void create(Object e) {
		session.persist(e);
		transaction.commit();
	}

	public void read() {
//		Employee employee = session.get(Employee.class, 1);
//		employee.printDetails(employee);
//
		Student s = session.get(Student.class, 1);
		s.printDetails(s);
	}
}
