package hql.dbutil;

import hql.entities.Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypeTemplate;
import org.hibernate.type.StandardBasicTypes;
import util.HibernateUtil;

import java.util.List;

public class DBUtil_Native_SQL {
	public static Session session = null;
	public static Transaction transaction = null;

	public DBUtil_Native_SQL() {
		session = HibernateUtil.getSession();
		transaction = session.beginTransaction();
	}

	public void create(Employee employee) {
		session.persist(employee);
	}

	public void commitTransactions() {
		if (transaction != null)
			transaction.commit();
	}

	public void simple_select_native_sql1() {
		String SELECT_QUERY = "select * from Employee e";
		NativeQuery<Object[]> query = session.createNativeQuery(SELECT_QUERY);
		List<Object[]> list = query.getResultList();
		list.forEach(emp -> {
			for (Object o : emp) {
				System.out.println(o);
			}
		});
	}

	public void simple_select_native_sql2() {
		String SELECT_QUERY = "select * from Employee e";
		NativeQuery<Employee> query = session.createNativeQuery(SELECT_QUERY, Employee.class);
		query.getResultList().forEach(System.out::println);
	}

	/*Scalar for multiple columns*/
	public void select_conditional() {
		String select_query = "select id,salary from Employee e where e.salary between ? and ?";
		NativeQuery query = session.createNativeQuery(select_query);
		query.addScalar("id", StandardBasicTypes.INTEGER);
		query.addScalar("salary", StandardBasicTypes.DOUBLE);
		query.setParameter(1, 371228);
		query.setParameter(2, 901228);

		List<Object[]> list = query.getResultList();
		list.forEach(emp -> {
			for (Object o : emp) {
				System.out.print(o + " ");
			}
			System.out.println();
		});
	}

	/*Scalar for single columns*/
	public void select_conditional1() {
		String select_query = "select id from Employee e where e.salary >?";
		NativeQuery query = session.createNativeQuery(select_query);
		query.addScalar("id", StandardBasicTypes.INTEGER);
		query.setParameter(1, 371228);
		List<Object> list = query.getResultList();
		list.forEach(System.out::println);
	}

	/*
	Update using native sql
	*/
	public void updateUsingNativeSQL() {
		String updateQuery = "update Employee e set e.salary=e.salary+100000 where e.position=?";
		NativeQuery query = session.createNativeQuery(updateQuery);
		query.setParameter(1, "Developer");
		query.executeUpdate();
		transaction.commit();
	}

	/*
	 * Insert using native sql
	 * */
	public void insertUsingSQL(Employee employee) {
		String insert_query = "insert into Employee(address, email, fName, lName, position, salary) values(?,?,?,?,?,?)";
		NativeQuery query = session.createNativeQuery(insert_query,Employee.class);
		query.setParameter(1, employee.getAddress());
		query.setParameter(2, employee.getEmail());
		query.setParameter(3, employee.getFName());
		query.setParameter(4, employee.getLName());
		query.setParameter(5, employee.getPosition());
		query.setParameter(6, employee.getSalary());

		int i = query.executeUpdate();
		System.out.println(i);
		transaction.commit();
	}
}
