package using_xml_configuration.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Payment {
	private int payment_id;
	private double amount;
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
