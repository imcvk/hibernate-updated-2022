package entities;

public class Book {

	private int bookId;
	private int isbn;
	private String name;
	private int price;

	public Book(int bookId, int isbn, String name, int price) {
		this.bookId = bookId;
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}

	public Book() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
