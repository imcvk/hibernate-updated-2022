package util;

import entities.Department;
import entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
	public static SessionFactory sessionFactory = null;
	public static Properties p = new Properties();

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			p.put(Environment.URL, "jdbc:mysql://localhost/hibernateyt");
			p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			p.put(Environment.USER, "root");
			p.put(Environment.PASS, "Cs@2302$");
			p.put(Environment.SHOW_SQL, true);
			p.put(Environment.HBM2DDL_AUTO, "update");
			p.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		}
		Configuration configuration = new Configuration().setProperties(p)
				.addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(p).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}