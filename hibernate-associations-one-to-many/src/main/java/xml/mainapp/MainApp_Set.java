package xml.mainapp;

import xml.entities.set.Customer;
import xml.entities.set.Vendor;
import xml.util.dbutil.DBUtils;
import xml.util.dbutil.DataFaker;

import java.util.Set;

public class MainApp_Set {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();

			dbUtils.create(bootstrapVendor());
	}

	public static Vendor bootstrapVendor() {
		Vendor vendor = new Vendor();
		DataFaker faker = new DataFaker();

		String name = faker.getName();
		Set<Customer> customers = Set.of(bootstrapCustomer(), bootstrapCustomer(), bootstrapCustomer());
		vendor.setVendorName(name);
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
