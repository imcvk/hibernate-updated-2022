package entities.xml;

public class Product_Using_UUID_Generator_XML {
	private String productId;
	private String productName;
	private String productPrice;

	public Product_Using_UUID_Generator_XML() {
	}

	public Product_Using_UUID_Generator_XML(String productId, String productName, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
