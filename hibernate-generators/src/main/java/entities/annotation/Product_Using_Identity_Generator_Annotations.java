package entities.annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product_Using_Identity_Generator_Annotations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productPrice;

	public Product_Using_Identity_Generator_Annotations() {
	}

	public Product_Using_Identity_Generator_Annotations(int productId, String productName, String productPrice) {
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

	public String getProductPrice(String s) {
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
