package annotation.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_using_annotations")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vendorId;
	private String vendorName;

	public Vendor(int vendorId, String vendorName) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;

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

}
