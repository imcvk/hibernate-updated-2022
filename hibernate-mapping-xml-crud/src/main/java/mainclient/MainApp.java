package mainclient;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class MainApp {
	Session session = null;
	Transaction transaction = null;

	MainApp() {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		int id = -1820906452;//new Random().nextInt();
		Employee employee = new Employee(id, "Chaitanya");
	//	mainApp.create(employee);
	//	mainApp.read(id);
		mainApp.update(employee);
//		mainApp.delete(employee);
	}

	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}

	public void create(Employee employee) {
		session.persist(employee);
		transaction.commit();
	}

	public void read(int id) {
		Employee e = session.get(Employee.class, id);
		System.out.println(e);
	}

	public void update(Employee e) {
		e.setName("Vijay");
		session.saveOrUpdate(e);
		transaction.commit();
		System.out.println(session.get(Employee.class, e.getId()));
	}

	public void delete(Employee employee) {
		employee.setId(1882435786);
		System.out.println("Delete this: " + employee);
		session.remove(employee);
		transaction.commit();
	}
}
