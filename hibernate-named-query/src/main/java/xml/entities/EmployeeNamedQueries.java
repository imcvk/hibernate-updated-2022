package xml.entities;

public class EmployeeNamedQueries{

	int id;
	String fName;
	String lName;
	String email;
	String address;
	Double salary;

	public EmployeeNamedQueries(int id, String fName, String lName, String email, String address, Double salary) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public EmployeeNamedQueries() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "------------------------------------------------------------------------------------------------\n"
				+ "EmployeeNamedQueries{" +
				"id=" + id +
				", fName='" + fName + '\'' +
				", lName='" + lName + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", salary=" + salary +
				"}" + "\n------------------------------------------------------------------------------------------------";

	}
}
