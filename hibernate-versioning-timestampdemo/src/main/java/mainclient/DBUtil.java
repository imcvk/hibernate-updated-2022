package mainclient;

import entities.Department;
import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Random;

public class DBUtil {
	Session session = null;
	Transaction transaction = null;

	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		return sessionFactory;
	}

	public void createEmployee(Object employee) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}

	public void readEmployee(int id) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		System.out.println(e);
		session.close();
	}

	public void updateEmployee(Employee e) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(e);
		transaction.commit();
		System.out.println(session.get(Employee.class, e.getId()));
		session.close();
	}

	public void deleteEmployee(Employee employee) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		employee.setId(1882435786);
		System.out.println("Delete this: " + employee);
		session.remove(employee);
		transaction.commit();
		session.close();
	}

	public void createDepartment(Department department) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		session.close();
	}

	public void deleteDepartment(Department department) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.remove(department);
		transaction.commit();
		session.close();
	}

	public void readDepartment(int id) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Department d = session.get(Department.class, id);
		System.out.println(d);
		session.close();
	}

	public void updateDepartment(Department d) {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Department d2=session.get(Department.class,d.getDept_id());
		System.out.println(d2);
		String newName = "TestUpdateName" + new Random().nextInt();
		d2.setDept_name(newName);
		session.update(d2);
		transaction.commit();
	}

	public void closeSession() {
		session.close();
	}
}
