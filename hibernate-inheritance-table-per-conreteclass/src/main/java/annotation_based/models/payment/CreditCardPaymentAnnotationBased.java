package annotation_based.models.payment;

import jakarta.persistence.Entity;

@Entity
public class CreditCardPaymentAnnotationBased extends PaymentAnnotationBased {
	private String cardType;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
