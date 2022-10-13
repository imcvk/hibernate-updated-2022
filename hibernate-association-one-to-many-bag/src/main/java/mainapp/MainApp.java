package mainapp;

import entities.Dealer;
import entities.Product;
import util.dbutil.DBUtils;
import util.dbutil.DataFaker;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		dbUtils.create(bootstrapDealer());
	}

	public static Dealer bootstrapDealer() {
		DataFaker dataFaker = new DataFaker();
		Dealer dealer = new Dealer();
		String name = dataFaker.getName();
		dealer.setDealerName(name);
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			products.add(bootstrapProduct());
		}
		dealer.setProducts(products);
		return dealer;
	}

	public static Product bootstrapProduct() {
		DataFaker dataFaker = new DataFaker();
		Product product = new Product();
		String productName = DataFaker.faker.app().name();
		product.setProductName(productName);
		return product;
	}
}
