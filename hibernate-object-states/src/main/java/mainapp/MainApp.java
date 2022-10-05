package mainapp;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Random;

public class MainApp {
	public static Session session = null;
	public static Transaction transaction = null;

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		int id = new Random().nextInt(1111, 9999);
		System.out.println("Employee object created and it is in Transient state");
		Employee e = new Employee(id, "Suresh");
		System.out.println(e);
		session.save(e);
		System.out.println("Employee is in Persistent state");
		e.setName("Ramesh");//this will reflect is database as well because an object is in Persistent state
		System.out.println("After update: "+e);
		transaction.commit();
		session.close();
	}

}
