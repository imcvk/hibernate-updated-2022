package usingannotations.entities.map;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(schema = "DealerUsingAnnotations")
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dealerId;
	private String dealerName;
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	private Map<String, Product> products;

	public Dealer(int dealerId, String dealerName, Map products) {
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.products = products;
	}

	public Dealer() {
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Map getProducts() {
		return products;
	}

	public void setProducts(Map products) {
		this.products = products;
	}
}
