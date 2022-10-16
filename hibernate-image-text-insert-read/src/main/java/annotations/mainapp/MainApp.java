package annotations.mainapp;

import annotations.entities.Company;
import annotations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bootstrapCompany());
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
