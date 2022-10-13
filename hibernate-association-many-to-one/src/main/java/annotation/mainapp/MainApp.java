package annotation.mainapp;

import annotation.entities.Customer;
import annotation.entities.Vendor;
import annotation.util.dbutil.DBUtils;
import annotation.util.dbutil.DataFaker;

public class MainApp {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		DataFaker faker = new DataFaker();
		Vendor vendor = bootstrapVendor(faker);
		Customer customer;
		for (int i = 0; i < 10; i++) {
			customer = bootstrapCustomer(faker);
			customer.setVendor(vendor);
			dbUtils.create(customer);
		}

	}

	public static Vendor bootstrapVendor(DataFaker faker) {
		Vendor vendor = new Vendor();
		String name = faker.getName();
		vendor.setVendorName(name);
		return vendor;
	}

	public static Customer bootstrapCustomer(DataFaker faker) {
		Customer customer = new Customer();
		String name = faker.getName();
		String address = faker.getAddress();
		customer.setCustomerName(name);
		customer.setCustomerAddress(address);
		customer.setVendor(bootstrapVendor(faker));
		return customer;
	}
}
