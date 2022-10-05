package select_operation_in_hql.dbutil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
public class DB_Util_using_Criteria_API {
	Session session = null;
	Transaction transaction = null;

	public void get_rows_using_criteria(){
		session= HibernateUtil.getSessionFactory().openSession();
		//Read Partial object using Criteria API
	}
}
