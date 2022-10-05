package entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Novel {
	@EmbeddedId
	private NovelComposite novelComposite;
	private String name;
	private int price;

	public Novel(NovelComposite novelComposite, String name, int price) {
		this.novelComposite = novelComposite;
		this.name = name;
		this.price = price;
	}

	public Novel() {
	}

	public NovelComposite getNovelComposite() {
		return novelComposite;
	}

	public void setNovelComposite(NovelComposite novelComposite) {
		this.novelComposite = novelComposite;
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
