package usingannotations.util.dbutil;

import usingannotations.entities.set.Customer;
import usingannotations.entities.set.Vendor;
import usingannotations.util.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class DBUtils {
	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Transaction transaction = null;

	public DBUtils() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}

	public void create(Vendor o) {
		transaction.begin();
		session.persist(o);
		transaction.commit();
	}

	public void read(int id) {

		Vendor vendor = session.get(Vendor.class, id);
		System.out.println("\nVendor id: " + vendor.getVendorId() +
				"\nVendor name: " + vendor.getVendorName());
		List customers = vendor.getCustomers().stream().toList();
		System.out.println("Customers associated with Vendor:");
		customers.forEach(System.out::println);
	}

	public void addChild(Customer customer, int vendorId) {
		transaction.begin();
		Vendor vendor = session.get(Vendor.class, vendorId);
		System.out.println("\nVendor id: " + vendor.getVendorId() +
				"\nVendor name: " + vendor.getVendorName());
		List customers = vendor.getCustomers().stream().toList();
		System.out.println("Customers associated with Vendor:");
		customers.forEach(System.out::println);
		System.out.println("New customer to add:" + customer);
		vendor.getCustomers().add(customer);
		customer.setVendor(vendor);
		session.update(vendor);
		transaction.commit();
	}
	public void removeChildFromParent(int customerId, int vendorId){
		transaction.begin();

		Vendor vendor = session.get(Vendor.class, vendorId);
		Customer c=session.get(Customer.class,customerId);

		System.out.println("customer to remove:" + c);
		Set customers=vendor.getCustomers();
		customers.remove(c);
		vendor.setCustomers(customers);
		session.persist(vendor);
		System.out.println(session.get(Vendor.class,vendorId));
		transaction.commit();
	}
	public void delete(int id){
		transaction.begin();
		Vendor vendor=session.get(Vendor.class,id);
		session.remove(vendor);
		transaction.commit();
	}
}
