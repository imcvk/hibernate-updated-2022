package mainapp;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Random;

public class MainApp {
	Session session = null;
	Transaction transaction = null;

	public static void main(String[] args) {
		int id = new Random().nextInt(1111, 9999);
		Employee e = new Employee();
		e.setId(id);
		e.setName("Suresh");
		MainApp mainApp = new MainApp();
		mainApp.update2(new Employee(4028,"testName"));
		//insert
//		mainApp.create(e);
//		mainApp.read(e);
//		mainApp.update(e);
//		mainApp.delete(e);
	}

	public void create(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(e);
		transaction.commit();
		session.close();

	}

	public void read(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		System.out.println(session.get(Employee.class, e.getId()));
		session.close();
	}

	public void delete(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.remove(e);
		transaction.commit();
		session.close();
	}

	//approach 1
	public void update(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		e.setName("Chaitanya");
		session.update(e);
		transaction.commit();
		System.out.println(session.get(Employee.class, e.getId()));
		session.close();
	}

	//approach 2
	public void update2(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Employee e2 = session.get(Employee.class, e.getId());
		e2.setName("sdfsdfsdf");
		session.update(e2);
		transaction.commit();
		System.out.println(session.get(Employee.class, e2.getId()));
	}
}
