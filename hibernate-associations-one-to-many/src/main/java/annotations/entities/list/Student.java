package annotations.entities.list;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studId;
	private String studName;
	@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	private List<Book> books;

	public Student(int studId, String studName, List<Book> books) {
		this.studId = studId;
		this.studName = studName;
		this.books = books;
	}

	public Student() {
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
