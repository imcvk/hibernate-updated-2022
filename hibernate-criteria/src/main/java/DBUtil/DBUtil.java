package DBUtil;

import entities.Employee;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DBUtil {
	public static Session session = null;
	public static Transaction transaction = null;
	public static CriteriaBuilder criteriaBuilder = null;
	public static CriteriaDelete<Employee> criteriaDelete = null;

	public DBUtil() {
		session = getSession();
		transaction = session.beginTransaction();
		criteriaBuilder = session.getCriteriaBuilder();
		criteriaDelete = criteriaBuilder.createCriteriaDelete(Employee.class);
	}

	public static SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}

	public void create(Object o) {
		session.persist(o);
		transaction.commit();

	}

	public void read_using_criteria_query() {

		CriteriaQuery<Employee> cq = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root).where(criteriaBuilder.and(criteriaBuilder.ge(root.get("id"), 1111), criteriaBuilder.le(root.get("id"), 99999)));
		Query query = session.createQuery(cq);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);
	}

	/**
	 * SIMPLE SELECT EXAMPLE CRITERIA QUERY
	 * select clause for criteria query
	 */
	public void getAllUsers() {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		Query query = session.createQuery(cq);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

	}

	/**
	 * SIMPLE ORDER BY EXAMPLE CRITERIA QUERY
	 * order by clause for a criteria query
	 */
	public void getUserOrdered() {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.orderBy(cb.asc(root.get("id")));
		Query query = session.createQuery(cq);
		query.getResultList().forEach(System.out::println);
	}

	public void getUser_applying_WHERE_and_IN_clause_for_criteria_query() {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root).where(cb.gt(root.get("id"), 1002));
		Query query = session.createQuery(cq);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);
	}

	public void using_expression() {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cb.like(root.get("fName"), "%S");
		Query query = session.createQuery(cq);
		query.getResultList().forEach(System.out::println);
	}

	public void multiSelectOperation() {

		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(List.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		//specify the specific multiple cols and the where clause condition
		//select id,name from employee where id>=5 and id<=1500 order by name
		criteriaQuery.multiselect(root.get("id"), root.get("fName")).where(criteriaBuilder.and(criteriaBuilder.le(root.get("id"), 1500)));
		Query query = session.createQuery(criteriaQuery);
		List<List> list = query.getResultList();
		list.forEach(row ->
		{
			for (Object l : row) {
				System.out.print(l + " ");
			}
			System.out.println();
		});

	}

	/**
	 * Fetch records based on given position
	 */
	public void printUsersBasedOnPosition(String position) {
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("position"), position));
		Query query = session.createQuery(criteriaQuery);
		query.getResultList().forEach(System.out::println);
		;
	}

	/**
	 * select a single column where name starts with s
	 */
	public void getUserNamesStartsWith_S() {

		CriteriaQuery<String> cq = criteriaBuilder.createQuery(String.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.multiselect(root.get("fName")).where(criteriaBuilder.like(root.get("fName"), "s%"));
		Query query = session.createQuery(cq);
		List list = query.getResultList();
		list.forEach(System.out::println);
	}

	/**
	 * Aggregate Function using criteria
	 */
	public void getCountOfEmployees() {
		CriteriaQuery<Long> cq = criteriaBuilder.createQuery(Long.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.multiselect(criteriaBuilder.count(root.get("id")));
		Query query = session.createQuery(cq);
		Long c = (Long) query.getSingleResult();
		System.out.println(c);

	}

	/**
	 * find the max min, avg, sum of salary
	 */
	public void min_max_avg_sumOfEmpSalary() {
		CriteriaQuery<Object[]> cq = criteriaBuilder.createQuery(Object[].class);
		Root<Employee> root = cq.from(Employee.class);
		cq.multiselect(
				criteriaBuilder.count(root.get("id")),
				criteriaBuilder.max(root.get("salary")),
				criteriaBuilder.min(root.get("salary")),
				criteriaBuilder.avg(root.get("salary")),
				criteriaBuilder.sum(root.get("salary")));
		Query query = session.createQuery(cq);
		Object[] obj = (Object[]) query.getSingleResult();
//print
		System.out.println("Count of emo " + obj[0]);
		System.out.println("max sal " + obj[1]);
		System.out.println("min of sal " + obj[2]);
		System.out.println("avg of sal " + obj[3]);
		System.out.println("Sum of sal " + obj[4]);
	}

	/**
	 * Update Salary based on position.
	 */
	public DBUtil updateSalaryForPosition(String position) {

		CriteriaUpdate<Employee> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Employee.class);
		Root<Employee> root = criteriaUpdate.from(Employee.class);
		criteriaUpdate.set(root.get("salary"), 8000d).where(criteriaBuilder.equal(root.get("position"), position));
		Query query = session.createQuery(criteriaUpdate);
		int i = query.executeUpdate();
		System.out.println(i);

		return this;
	}

	/**
	 * Delete employee using id- conditional delete
	 */
	public void deleteEmployee_Using_ID_column(int id) {

		Root<Employee> root = criteriaDelete.from(Employee.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
		Query query = session.createQuery(criteriaDelete);
		int i = query.executeUpdate();
		System.out.println(i);
		transaction.commit();
	}

	/**
	 * Delete employee whose name starts with s - conditional delete
	 */
	public void deleteEmployeeUsingName() {

		Root<Employee> root = criteriaDelete.from(Employee.class);
		criteriaDelete.where(criteriaBuilder.like(root.get("fName"), "s%"));
		Query query = session.createQuery(criteriaDelete);
		int i = query.executeUpdate();
		System.out.println(i);
		transaction.commit();
	}
}
