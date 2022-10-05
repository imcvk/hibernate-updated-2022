package hql.dbutil;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HQL_Non_Select {
	public static Session session = null;
	public static Transaction transaction = null;
	public static Query query = null;

	public HQL_Non_Select() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

	}

	String updateQuery = "update Employee e set e.salary=e.salary+1000 where e.position=:position";

	public void update_using_hql(String position) {
		query = session.createQuery(updateQuery);
		query.setParameter("position", position);
		int i = query.executeUpdate();
		System.out.println(i);
		transaction.commit();
	}

	String deleteQuery = "delete from Employee e where e.id=:id";

	public void delete(int id) {
		query = session.createQuery(deleteQuery);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
	}
}
