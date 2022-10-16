package xml.mainapp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import xml.entities.Company;
import xml.util.HibernateUtil;

import java.io.FileInputStream;

public class MainApp {
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getXMLSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Company company = new Company();
		FileInputStream fis=new FileInputStream("src/main/java/pic.png");
		byte[] data=new byte[fis.available()];
		fis.read (data);
		company.setImage(data);
		company.setCompanyId(454);
		session.persist(company);
		transaction.commit();
		session.close();
	}

}
