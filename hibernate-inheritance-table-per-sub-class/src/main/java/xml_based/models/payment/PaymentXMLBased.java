package xml_based.models.payment;

import java.util.Date;

public class PaymentXMLBased{
	private int paymentId;
	private int amount;
	private Date dateTime;

	public PaymentXMLBased(int paymentId, int amount, Date dateTime) {
		this.paymentId = paymentId;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public PaymentXMLBased() {
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
