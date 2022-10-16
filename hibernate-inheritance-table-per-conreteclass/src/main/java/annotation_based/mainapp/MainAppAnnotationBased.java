package annotation_based.mainapp;

import annotation_based.models.employee.ContractEmployeeAnnotationBased;
import annotation_based.models.employee.RegularEmployeeAnnotationBased;
import annotation_based.models.payment.ChequePaymentAnnotationBased;
import annotation_based.models.payment.CreditCardPaymentAnnotationBased;
import common.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class MainAppAnnotationBased {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		CreditCardPaymentAnnotationBased ccPayment = new CreditCardPaymentAnnotationBased();
		ccPayment.setPaymentId(7489456);
		ccPayment.setAmount(78945);
		ccPayment.setDateTime(new Date());
		ccPayment.setCardType("VISA");

		ChequePaymentAnnotationBased chequePayment = new ChequePaymentAnnotationBased();
		chequePayment.setChequeType("Order");
		chequePayment.setAmount(45454);
		chequePayment.setDateTime(new Date());
		chequePayment.setPaymentId(45454);

		ContractEmployeeAnnotationBased cEmployee = new ContractEmployeeAnnotationBased();
		cEmployee.setEmpName("Ramesh1");
		cEmployee.setEmpId(45451);
		cEmployee.setContractPeriod(7);
		cEmployee.setPayPerHr(10);
		cEmployee.setEmpDesignation("SE");

		RegularEmployeeAnnotationBased rEmployee = new RegularEmployeeAnnotationBased();
		rEmployee.setEmpName("Ramesh2");
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
