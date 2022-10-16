package xml.entities;

import java.sql.Blob;

public class Company {
	private int companyId;
	private byte[] image;

	public Company(int companyId, byte[] image) {
		this.companyId = companyId;
		this.image = image;
	}

	public Company() {
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
