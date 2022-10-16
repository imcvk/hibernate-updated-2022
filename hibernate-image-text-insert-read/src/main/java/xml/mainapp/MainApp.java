package xml.mainapp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import xml.entities.Company;
import xml.util.HibernateUtil;

import java.io.*;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getXMLSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Company company = bootstrapCompany();
		System.out.println(company);
		session.persist(company);
		transaction.commit();
		session.close();
	}

	public static Company bootstrapCompany() {
		Company company = new Company();
		try {
			File picFile = new File("hibernate-image-text-insert-read/src/main/resources/pic.png");
			InputStream inputStream = new FileInputStream(picFile);
			byte[] pic = new byte[(int) picFile.length()];
			inputStream.read(pic);

			File resumeFile = new File("hibernate-image-text-insert-read/src/main/resources/test.txt");
			Reader reader = new FileReader(resumeFile);
			char[] resume = new char[(int) resumeFile.length()];
			reader.read(resume);
			company.setResume(resume);
			company.setImage(pic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}
}
