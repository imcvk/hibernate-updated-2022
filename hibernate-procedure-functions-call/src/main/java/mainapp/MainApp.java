package mainapp;

import dbutil.DBUTILS;
import entities.Employee;
import util.DataFaker;

public class MainApp {
	public static void main(String[] args) {
		DBUTILS dbutils = new DBUTILS();
//		for (int i = 0; i < 10; i++) {
//			dbutils.create(bootstrapEmployeeObject());
//		}
//		dbutils.runProc();
	//	dbutils.runProcUsingStatement();
	}

	public static Employee bootstrapEmployeeObject() {
		Employee employee = new Employee();
		String f = DataFaker.getFirstName();
		String l = DataFaker.getLastName();
		Double salary = DataFaker.getSalary();
		employee.setFName(f);
		employee.setLName(l);
		employee.setSalary(salary);
		employee.setEmail(DataFaker.getEmailId(f, l));
		employee.setAddress(DataFaker.getAddress());
		employee.setPosition(DataFaker.getPosition());
		System.out.println(employee);
		return employee;
	}
}
