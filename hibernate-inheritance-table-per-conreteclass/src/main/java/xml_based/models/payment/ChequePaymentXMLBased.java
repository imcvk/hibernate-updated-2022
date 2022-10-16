package xml_based.models.payment;

public class ChequePaymentXMLBased extends xml_based.models.payment.PaymentXMLBased {
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
}
