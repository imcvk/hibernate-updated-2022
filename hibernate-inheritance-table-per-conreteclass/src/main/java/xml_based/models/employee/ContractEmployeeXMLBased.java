package xml_based.models.employee;

public class ContractEmployeeXMLBased extends EmployeeXMLBased{
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
