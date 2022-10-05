package mainapp;

import DBUtil.DBUtil;
import entities.Employee;
import util.DataFaker;

public class MainApp {
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
//		for (int i = 0; i < 50; i++) {
//			dbUtil.create(bootstrapEmployeeObject());
//		}
//		dbUtil.read_using_criteria_query();
//		dbUtil.getAllUsers();
//		dbUtil.getUserOrdered();
//		dbUtil.getUser_applying_WHERE_and_IN_clause_for_criteria_query();
//		dbUtil.using_expression();
//		dbUtil.multiSelectOperation();
//		dbUtil.getUserNamesStartsWith_S();
//		dbUtil.getCountOfEmployees();
//		dbUtil.min_max_avg_sumOfEmpSalary();
//		dbUtil.updateSalaryForPosition("Agent");
//		dbUtil.printUsersBasedOnPosition("Agent");
//		dbUtil.deleteEmployee_Using_ID_column(6952);
		dbUtil.deleteEmployeeUsingName();
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
