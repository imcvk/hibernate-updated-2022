package xml_based.mainapp;


import common.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import xml_based.models.employee.ContractEmployeeXMLBased;
import xml_based.models.employee.RegularEmployeeXMLBased;

public class MainAppXMlBased {

	public static void main(String[] args) {
		Session session = HibernateUtil.getXMLSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

//		CreditCardPayment ccPayment = new CreditCardPayment();
//		ccPayment.setPaymentId(7489456);
//		ccPayment.setAmount(78945);
//		ccPayment.setDateTime(new Date());
//		ccPayment.setCardType("VISA");
//
//		ChequePayment chequePayment = new ChequePayment();
//		chequePayment.setChequeType("Order");
//		chequePayment.setAmount(45454);
//		chequePayment.setDateTime(new Date());
//		chequePayment.setPaymentId(45454);
//
//		session.persist(ccPayment);
//		session.persist(chequePayment);
//		transaction.commit();

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

		session.persist(cEmployee);
		session.persist(rEmployee);
		transaction.commit();
	}

}
