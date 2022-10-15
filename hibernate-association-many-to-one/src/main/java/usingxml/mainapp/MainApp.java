package usingxml.mainapp;

import usingxml.entities.Customer;
import usingxml.entities.Vendor;
import usingxml.util.dbutil.DBUtils;
import usingxml.util.dbutil.DataFaker;

public class MainApp {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		Vendor vendor = bootstrapVendor();
		Customer customer;
		for (int i = 0; i < 10; i++) {
			customer = bootstrapCustomer();
			customer.setVendor(vendor);
			dbUtils.create(customer);
		}

	}

	public static Vendor bootstrapVendor() {
		Vendor vendor = new Vendor();
		DataFaker faker = new DataFaker();
		String name = faker.getName();
		vendor.setVendorName(name);
		return vendor;
	}

	public static Customer bootstrapCustomer() {
		DataFaker faker = new DataFaker();
		String name = faker.getName();
		String address = faker.getAddress();
		Customer customer = new Customer();
		customer.setCustomerName(name);
		customer.setCustomerAddress(address);
		customer.setVendor(bootstrapVendor());
		return customer;
	}
}
