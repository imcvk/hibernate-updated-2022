package xml.entities;



public class Company {
	private int companyId;
	private byte[] image;
	private char[] resume;

	public Company(int companyId, byte[] image, char[] resume) {
		this.companyId = companyId;
		this.image = image;
		this.resume = resume;
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

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Company{" +
				"companyId=" + companyId +
				'}';
	}
}
