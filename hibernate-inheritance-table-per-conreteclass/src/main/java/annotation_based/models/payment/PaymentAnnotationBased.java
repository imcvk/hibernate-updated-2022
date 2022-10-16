package annotation_based.models.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PaymentAnnotationBased {
	@Id
	private int paymentId;
	private int amount;
	private Date dateTime;

	public PaymentAnnotationBased(int paymentId, int amount, Date dateTime) {
		this.paymentId = paymentId;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public PaymentAnnotationBased() {
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
