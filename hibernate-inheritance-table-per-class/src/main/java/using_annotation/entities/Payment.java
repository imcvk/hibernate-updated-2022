package using_annotation.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PMODE", discriminatorType = DiscriminatorType.STRING)
public class Payment {
	@Id
	@Column(name = "PAYMENTID")
	private int payment_id;
	@Column(name = "AMOUNT")
	private double amount;
	@Column(name = "PAYMENTDATE")
	private Date payment_date;

	public Payment(int payment_id, double amount, Date payment_date) {
		this.payment_id = payment_id;
		this.amount = amount;
		this.payment_date = payment_date;
	}

	public Payment() {
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
}
