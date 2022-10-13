package annotations.mainapp;

import annotations.entities.map.Dealer;
import annotations.entities.map.Product;
import annotations.util.dbutil.DataFaker;
import xml.util.dbutil.DBUtils;

import java.util.HashMap;
import java.util.Map;

public class MainApp_Map {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		Dealer dealer = bootstrapDealer();
		dbUtils.create(dealer);
	}

	public static Dealer bootstrapDealer() {
		Dealer dealer = new Dealer();
		DataFaker dataFaker = new DataFaker();
		dealer.setDealerName(dataFaker.getName());
		Map<String, Product> products = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			products.put(DataFaker.faker.funnyName().name(), bootstrapProduct());
		}
		dealer.setProducts(products);
		return dealer;
	}

	public static Product bootstrapProduct() {
		Product product = new Product();
		DataFaker dataFaker = new DataFaker();
		product.setProductName(dataFaker.getName());
		return product;
	}
}
