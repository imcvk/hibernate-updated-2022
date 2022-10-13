package entities;

import java.util.List;

public class Dealer {
	private int dealerId;
	private String dealerName;
	private List products;

	public Dealer(int dealerId, String dealerName, List products) {
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

	public List getProducts() {
		return products;
	}

	public void setProducts(List products) {
		this.products = products;
	}
}
