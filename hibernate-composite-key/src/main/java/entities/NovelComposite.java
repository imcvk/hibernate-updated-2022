package entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NovelComposite implements Serializable {

	private static final long serialVersionUID = -3171389488657584830L;
	private int novelId;
	private int isbn;

	public NovelComposite(int novelId, int isbn) {
		this.novelId = novelId;
		this.isbn = isbn;
	}

	public NovelComposite() {
	}

	public int getNovelId() {
		return novelId;
	}

	public void setNovelId(int novelId) {
		this.novelId = novelId;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
