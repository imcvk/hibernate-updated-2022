package util;

import entities.Book;
import entities.Novel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
	public static SessionFactory getSessionFactoryForXmlCfg() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		Properties p = new Properties();
		if (sessionFactory == null) {
			p.put(Environment.URL, "jdbc:mysql://localhost/hibernateyt");
			p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			p.put(Environment.USER, "root");
			p.put(Environment.PASS, "Cs@2302$");
			p.put(Environment.SHOW_SQL, true);
			p.put(Environment.HBM2DDL_AUTO, "update");
			p.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		}
		Configuration configuration = new Configuration().setProperties(p).addAnnotatedClass(Novel.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(p).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
