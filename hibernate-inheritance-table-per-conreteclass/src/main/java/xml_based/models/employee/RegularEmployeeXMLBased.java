package xml_based.models.employee;

public class RegularEmployeeXMLBased extends EmployeeXMLBased{
	private int salary;
	private int bonus;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
