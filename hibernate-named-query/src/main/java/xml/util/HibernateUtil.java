package xml.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
	public static SessionFactory sessionFactory = null;
	public static Properties p = new Properties();


	public static Session getSession_usingXML() {
		return getSessionFactory_xml().openSession();
	}

	public static SessionFactory getSessionFactory_xml() {
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
}
