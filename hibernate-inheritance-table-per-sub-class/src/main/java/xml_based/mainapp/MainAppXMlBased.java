package xml_based.mainapp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import xml_based.models.employee.ContractEmployeeXMLBased;
import xml_based.models.employee.RegularEmployeeXMLBased;
import xml_based.models.payment.ChequePaymentXMLBased;
import xml_based.models.payment.CreditCardPaymentXMLBased;

import java.util.Date;

public class MainAppXMlBased {

	public static void main(String[] args) {
		Session session = HibernateUtil.getXMLSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		CreditCardPaymentXMLBased ccPayment = new CreditCardPaymentXMLBased();
		ccPayment.setPaymentId(74894561);
		ccPayment.setAmount(78945);
		ccPayment.setDateTime(new Date());
		ccPayment.setCardType("VISA");

		ChequePaymentXMLBased chequePayment = new ChequePaymentXMLBased();
		chequePayment.setChequeType("Order");
		chequePayment.setAmount(45454);
		chequePayment.setDateTime(new Date());
		chequePayment.setPaymentId(454514);



		ContractEmployeeXMLBased cEmployee = new ContractEmployeeXMLBased();
		cEmployee.setEmpName("Ramesh");
		cEmployee.setEmpId(45451);
		cEmployee.setContractPeriod(7);
		cEmployee.setPayPerHr(10);
		cEmployee.setEmpDesignation("SE");

		RegularEmployeeXMLBased rEmployee = new RegularEmployeeXMLBased();
		rEmployee.setEmpName("Ramesh");
		rEmployee.setEmpId(45458);
		rEmployee.setSalary(70000);
		rEmployee.setBonus(1000);
		rEmployee.setEmpDesignation("SE");

		session.persist(ccPayment);
		session.persist(chequePayment);
		session.persist(cEmployee);
		session.persist(rEmployee);
		transaction.commit();
	}

}
