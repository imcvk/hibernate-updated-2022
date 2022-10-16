package annotation_based.models.payment;

import annotation_based.models.payment.PaymentAnnotationBased;
import jakarta.persistence.Entity;

@Entity
public class ChequePaymentAnnotationBased extends PaymentAnnotationBased {
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
}
