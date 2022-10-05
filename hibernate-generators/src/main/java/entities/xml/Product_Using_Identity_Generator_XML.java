package entities.xml;

public class Product_Using_Identity_Generator_XML {
	private int productId;
	private String productName;
	private String productPrice;

	public Product_Using_Identity_Generator_XML() {
	}

	public Product_Using_Identity_Generator_XML(int productId, String productName, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
		return "Product_Using_Increment_Generator_XML{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productPrice='" + productPrice + '\'' +
				'}';
	}
}
