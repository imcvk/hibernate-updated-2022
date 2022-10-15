package hql.dbutil;

import hql.entities.Employee;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class HQL_Select {
	public static Session session = null;
	public static Transaction transaction = null;
	public static Query query = null;
	/*
	 * HQL Queries
	 * */
	public static final String select_simple = "from Employee";
	public static final String select_positional_parameter = "from Employee E WHERE E.ID=?";
	public static final String select_named_parameter = "from Employee E WHERE E.ID>=:ID";
	public static final String positional_and_named_parameter = "from Employee e where e.id>=?0 and e.id>=:id2";

	public HQL_Select() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	public void create(Employee e) {
		session.persist(e);
		transaction.commit();
		session.close();
	}

	/**
	 * SELECT * FROM EMPLOYEE;
	 */
	public void read_all_using_hql() {
		Query query = session.createQuery(select_simple, Employee.class);
		query.getResultList().forEach(System.out::println);
	}

	/**
	 * Using positional parameters
	 * select with where clause
	 * Query query1 = session.createQuery("from Employee where name in(?50,?51)");
	 * Query query1 = session.createQuery("from Employee where name in (?0,?1)");
	 * Query query1 = session.createQuery("from Employee where name in ( ?0, ?2)");//not allowed gap
	 * Query query1 = session.createQuery("from Employee where name in (?50, ?51)");//allowed
	 * Query query1 = session.createQuery("from Employee where name in (?-1, ?0)");//negative not allowed
	 * Query query1 = session.createQuery("from Employee where name in (?11, ?10)");//allowed
	 */
	public void read_all_using_positional_parameters(int id) {
		query = session.createQuery(select_positional_parameter, Employee.class);
		query.setParameter(0, id).getResultList().forEach(System.out::println);
	}

	/**
	 * Using named parameter
	 * select from Employee table where id>=5 and id<=10
	 * from Employee where id where id>=:min and id=:max
	 */
	public void read_all_using_named_parameter(int id) {
		query = session.createQuery(select_named_parameter);
		query.setParameter("ID", id).getResultList().forEach(System.out::println);
	}

	public void positional_and_named_parameter(int id1, int id2) {
		query = session.createQuery(positional_and_named_parameter);
		query.setParameter(1, id1);
		query.setParameter("id2", id2);
		query.getResultList().forEach(System.out::println);
	}

	// retriving the multiple specific col values
//select id,name, al from emp where id>=:lowId and id<=:highId
	public static final String specific = "select e.id,e.fName,e.lName,e.email from Employee e";

	public void retrieve_specific_columns() {
		query = session.createQuery(specific);
		List<Object[]> list = query.getResultList();
		list.forEach(ob -> {
			for (Object o : ob) {
				System.out.println(o);
			}
			System.out.println();
		});
	}

	public static final String single_select = "select fName from Employee order by fName desc ";

	public void retrieveSingleColumn() {
		session.createQuery(single_select).getResultList().forEach(System.out::println);
	}

	public static final String forSingleRecordUsingId = "from Employee where id=:id";

	public void where_clause() {
		query = session.createQuery(forSingleRecordUsingId).setParameter("id", 11652);
		Employee employee = (Employee) query.getSingleResult();
		System.out.println(employee);
	}

	//aggregate functions
	public void countEmployees() {
		query = session.createQuery("select count(*) from Employee");
		System.out.println("Count: " + query.getSingleResult());
	}

	public void average_sum_min_max() {
		query = session.createQuery("select max (salary),min(salary) ,sum(salary),avg (salary) from Employee");
		Object[] list = (Object[]) query.getSingleResult();
		System.out.println("Max salary:" + list[0]);
		System.out.println("Mim salary:" + list[1]);
		System.out.println("sum salary:" + (Double) list[2]);
		System.out.println("average salary:" + list[3]);
	}

	/**
	 * SUB QUERY
	 */
	public void subQueryDemo() {
		query = session.createQuery("from Employee WHERE salary =(SELECT max(salary) from Employee e )");
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);
	}
}
