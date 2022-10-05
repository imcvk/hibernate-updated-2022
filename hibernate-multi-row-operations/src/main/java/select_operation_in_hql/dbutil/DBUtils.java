package select_operation_in_hql.dbutil;

import select_operation_in_hql.entities.Employee;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DBUtils {
	Session session = null;
	Transaction transaction = null;

	public void create(Employee e) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.persist(e);
		transaction.commit();
		session.close();

	}

	//fetching element using simple hql
	public void readUsing_HQL() {
		session = HibernateUtil.getSessionFactory().openSession();
		String query = "from Employee";
		Query query1 = session.createQuery(query);
		List<Employee> e = query1.getResultList();
		for (Employee employee : e) {
			System.out.println(e);
		}
	}

	//fetching partial object using hql queries
	public void readRecordUsingHQL() {
		session = HibernateUtil.getSessionFactory().openSession();
		String query = "select e.name from Employee e";
		Query query1 = session.createQuery(query);
		List<String> e = query1.getResultList();
		for (Object employee : e) {
			System.out.println(employee);
		}
	}

	public void non_select_operations_using_hql() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("Update Employee e set e.name=:n where e.id=:i");
		query.setParameter("i", 1133);
		query.setParameter("n", "Chaitanya");
		int i = query.executeUpdate();
		transaction.commit();
	}
//insert values from one entity to another entity using hql
	public void insertRecordHQL_Query() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String hqlQuery = "insert into TestEmployee(id, name) select e.id, e.name from Employee e";
		Query query = session.createQuery(hqlQuery);
		int k = query.executeUpdate();
		transaction.commit();
	}
	public void update_using_HQL(){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String hqlQuery = "UPDATE TestEmployee te set te.name='Sachin' where te.id=1201";
		Query query = session.createQuery(hqlQuery);
		int k = query.executeUpdate();
		transaction.commit();
	}
}
