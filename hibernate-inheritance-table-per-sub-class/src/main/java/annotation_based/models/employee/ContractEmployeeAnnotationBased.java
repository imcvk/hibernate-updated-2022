package annotation_based.models.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "empId")
public class ContractEmployeeAnnotationBased extends EmployeeAnnotationBased {
	private int contractPeriod;
	private int payPerHr;

	public int getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public int getPayPerHr() {
		return payPerHr;
	}

	public void setPayPerHr(int payPerHr) {
		this.payPerHr = payPerHr;
	}
}
