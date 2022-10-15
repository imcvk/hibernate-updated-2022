package usingannotations.mainapp;

import usingannotations.dbutil.DBUtils_Annotations;
import usingannotations.entities.EmployeeNamedQueryAnnotation;
import usingxml.util.DataFaker;

public class MainApp_Annotation {

	public static void main(String[] args) {
		DBUtils_Annotations dbUtils_annotations = new DBUtils_Annotations();
//		for (int i = 0; i < 10; i++) {
//			dbUtils_annotations.create(bootstrapEmployeeObject());
//		}
//		dbUtils_annotations.runNamedQueries_HQL();
		dbUtils_annotations.runNamedQueries_Native();
	}

	public static EmployeeNamedQueryAnnotation bootstrapEmployeeObject() {
		EmployeeNamedQueryAnnotation employee = new EmployeeNamedQueryAnnotation();
		String f = DataFaker.getFirstName();
		String l = DataFaker.getLastName();
		Double salary = DataFaker.getSalary();
		employee.setFName(f);
		employee.setLName(l);
		employee.setSalary(salary);
		employee.setEmail(DataFaker.getEmailId(f, l));
		employee.setAddress(DataFaker.getAddress());
		System.out.println(employee);
		return employee;
	}
}
