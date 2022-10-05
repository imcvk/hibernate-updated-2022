package using_annotation.mainapp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import using_annotation.entities.Cheque;
import using_annotation.entities.CreditCard;
import common.util.HibernateUtil;

import java.util.Date;
import java.util.Random;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		CreditCard creditCard = new CreditCard();
		creditCard.setPayment_id(new Random().nextInt(111111, 999999));
		creditCard.setCc_type("card");
		creditCard.setCc_type("RUPAY");
		creditCard.setPayment_date(new Date());
		creditCard.setAmount(125000);

		Cheque cheque = new Cheque();
		cheque.setPayment_id(new Random().nextInt(111111, 999999));
		cheque.setCheque_type("Order1");
		cheque.setPayment_date(new Date());
		cheque.setAmount(560000);

		session.persist(creditCard);
		session.persist(cheque);
		transaction.commit();
	}

}
