package annotation_based.models.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeAnnotationBased {
	@Id
	private int empId;
	private String empName;
	private String empDesignation;

	public EmployeeAnnotationBased() {
	}

	public EmployeeAnnotationBased(int empId, String empName, String empDesignation) {
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
}
