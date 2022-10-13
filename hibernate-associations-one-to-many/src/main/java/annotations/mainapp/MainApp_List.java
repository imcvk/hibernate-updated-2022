package annotations.mainapp;

import annotations.entities.list.Book;
import annotations.entities.list.Student;
import annotations.util.dbutil.DataFaker;
import annotations.util.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainApp_List {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = getStudent();
		session.persist(student);
		transaction.commit();
	}

	public static Student getStudent() {
		DataFaker dataFaker = new DataFaker();
		Student student = new Student();
		student.setStudName(dataFaker.getName());
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Book b = getBook();
			b.setStudent(student);
			books.add(b);
		}
		student.setBooks(books);
		return student;
	}

	public static Book getBook() {
		DataFaker dataFaker = new DataFaker();
		Book book = new Book();
		book.setName(dataFaker.getBookName());
		return book;
	}
}
