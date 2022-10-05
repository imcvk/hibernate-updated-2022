package mainclient;

import entities.Department;
import entities.Employee;

import java.util.Random;

public class MainApp {
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
/**
 * Timestamp demo using @CreationTimestamp, @UpdateTimestamp in hibernate
 */
//		Employee employee = new Employee();
//		employee.setName("Emp1");
//		dbUtil.createEmployee(employee);
//		dbUtil.updateEmployee(new Employee(1, "Employee11"));
/**
 * Versioning demo using @Version in hibernate
 * */
//to create new department
		//Department department = new Department();
		//department.setDept_name("Mathematics");
		//dbUtil.createDepartment(department);

		Department department1 = new Department();
		department1.setDept_id(152);
		dbUtil.updateDepartment(department1);
	}

}
