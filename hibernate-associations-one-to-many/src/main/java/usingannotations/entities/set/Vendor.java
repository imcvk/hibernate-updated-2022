package usingannotations.entities.set;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vendorId;
	private String vendorName;
	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendor")
	private Set customers;

	public Vendor(int vendorId, String vendorName, Set customers) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.customers = customers;
	}

	public Vendor() {

	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Set getCustomers() {
		return customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

}
