package mainclient;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setId(4241);
		employee.setName("Test");
		session.persist(employee);
		transaction.commit();

	}
}
