package annotations.util.hibernateutil;

import annotations.entities.list.Book;
import annotations.entities.list.Student;
import annotations.entities.map.Dealer;
import annotations.entities.map.Product;
import annotations.entities.set.Customer;
import annotations.entities.set.Vendor;
import org.hibernate.Session;
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
			p.put(Environment.AUTOCOMMIT, "true");
		}
		Configuration configuration = new Configuration().setProperties(p).addAnnotatedClass(Vendor.class)
				.addAnnotatedClass(Customer.class).addAnnotatedClass(Student.class).addAnnotatedClass(Book.class)
				.addAnnotatedClass(Dealer.class).addAnnotatedClass(Product.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(p).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
