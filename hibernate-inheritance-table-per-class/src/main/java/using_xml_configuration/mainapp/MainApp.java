package using_xml_configuration.mainapp;

import common.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import using_xml_configuration.entities.Cheque;
import using_xml_configuration.entities.CreditCard;

import java.util.Date;
import java.util.Random;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getXMLSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		CreditCard creditCard = new CreditCard();
		creditCard.setPayment_id(new Random().nextInt(111111, 999999));
		creditCard.setCc_type("card");
		creditCard.setCc_type("VISA");
		creditCard.setPayment_date(new Date());
		creditCard.setAmount(125000);

		Cheque cheque = new Cheque();
		cheque.setPayment_id(new Random().nextInt(111111, 999999));
		cheque.setCheque_type("Order");
		cheque.setPayment_date(new Date());
		cheque.setAmount(560000);

		session.persist(creditCard);
		session.persist(cheque);
		transaction.commit();
	}

}
