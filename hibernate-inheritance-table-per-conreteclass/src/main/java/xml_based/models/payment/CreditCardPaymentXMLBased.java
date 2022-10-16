package xml_based.models.payment;

public class CreditCardPaymentXMLBased extends PaymentXMLBased {
	private String cardType;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
