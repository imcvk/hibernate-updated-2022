package usingxml.entities;


import java.util.Date;

public class License {
	private int licenseId;
	private Date issuedDate;
	private Date expiryDate;
	private User user;

	public License() {
	}

	public License(int licenseId, Date issuedDate, Date expiryDate, User user) {
		this.licenseId = licenseId;
		this.issuedDate = issuedDate;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
