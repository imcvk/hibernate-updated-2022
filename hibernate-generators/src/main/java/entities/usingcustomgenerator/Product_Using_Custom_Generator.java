package entities.usingcustomgenerator;

public class Product_Using_Custom_Generator {
	private String productId;
	private String productName;
	private String productPrice;

	public Product_Using_Custom_Generator() {
	}

	public Product_Using_Custom_Generator(String productId, String productName, String productPrice) {
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
		return "Product_Using_Custom_Generator{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productPrice='" + productPrice + '\'' +
				'}';
	}
}
