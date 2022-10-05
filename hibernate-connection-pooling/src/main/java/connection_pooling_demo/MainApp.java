package connection_pooling_demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student(10, "Ram");
		session.persist(student);
		transaction.commit();
	}
}
