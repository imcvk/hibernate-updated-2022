package mainclient;

import entities.Book;
import entities.Novel;
import entities.NovelComposite;
import util.DB_Operations;

public class MainApp {

	public static void main(String[] args) {
		DB_Operations db_operations = new DB_Operations();
//		Book b = new Book();
//		b.setBookId(1245);
//		b.setIsbn(8956);
//		b.setName("sdfsdfsdf");
//		b.setPrice(4545);
//		db_operations.createRecord(b);
		NovelComposite novelComposite = new NovelComposite(21244, 5656);
		Novel n = new Novel();
		n.setNovelComposite(novelComposite);
		n.setName("sdfsdfs");
		n.setPrice(1212);
		db_operations.createRecord(n);

	}
}
