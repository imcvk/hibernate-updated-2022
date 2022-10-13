package annotations.mainapp;

import annotations.entities.set.Customer;
import annotations.entities.set.Vendor;
import annotations.util.dbutil.DBUtils;
import annotations.util.dbutil.DataFaker;

import java.util.*;

public class MainApp_Set {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		for (int i = 0; i < 10; i++) {
			dbUtils.create(bootstrapVendor());
		}
	}

	public static Vendor bootstrapVendor() {
		Vendor vendor = new Vendor();
		DataFaker faker = new DataFaker();
		String name = faker.getName();
		vendor.setVendorName(name);
		Set<Customer> customers = new HashSet<>();
		int random = new Random().nextInt(1, 9);
		for (int i = 0; i < random; i++) {
			Customer customer = bootstrapCustomer();
			customer.setVendor(vendor);
			customers.add(customer);
		}
		vendor.setCustomers(customers);
		return vendor;
	}

	public static Customer bootstrapCustomer() {
		DataFaker faker = new DataFaker();
		String name = faker.getName();
		String address = faker.getAddress();
		Customer customer = new Customer();
		customer.setCustomerName(name);
		customer.setCustomerAddress(address);
		return customer;
	}

}
