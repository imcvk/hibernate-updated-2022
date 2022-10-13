package annotations.entities.list;

import jakarta.persistence.*;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book(int bookid, String name, Student student) {
		this.bookid = bookid;
		this.name = name;
		this.student = student;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Book() {
	}


}
