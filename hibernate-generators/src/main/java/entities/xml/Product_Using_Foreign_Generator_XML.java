package entities.xml;

public class Product_Using_Foreign_Generator_XML {
	private int productId;
	private Lab lab;
	private String productName;
	private String productPrice;

	public Product_Using_Foreign_Generator_XML() {
	}

	public Product_Using_Foreign_Generator_XML(int productId, Lab lab, String productName, String productPrice) {
		this.productId = productId;
		this.lab = lab;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product_Using_Foreign_Generator_XML{" +
				"productId=" + productId +
				", labId=" + lab +
				", productName='" + productName + '\'' +
				", productPrice='" + productPrice + '\'' +
				'}';
	}
}
