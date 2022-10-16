package xml.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
	public static SessionFactory sessionFactory = null;
	public static Properties p = new Properties();

	public static SessionFactory getXMLSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}
}
