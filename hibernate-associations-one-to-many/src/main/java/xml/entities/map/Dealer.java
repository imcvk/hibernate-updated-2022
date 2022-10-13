package xml.entities.map;

import java.util.Map;

public class Dealer {
	private int dealerId;
	private String dealerName;
	private Map<String,Product> products;

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
