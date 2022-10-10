package xml.mainapp;

import xml.dbutil.DataBaseUtils;
import xml.entities.EmployeeNamedQueries;
import xml.util.DataFaker;

public class MainApp_XML {
	public static void main(String[] args) {
		DataBaseUtils dataBaseUtils = new DataBaseUtils();
//		for (int i = 0; i < 10; i++) {
//			dataBaseUtils.create(bootstrapEmployeeObject());
//		}
//		dataBaseUtils.executeNamedQuery_HQL();
		dataBaseUtils.executeNamedQuery_Native_SQL();

	}

	public static EmployeeNamedQueries bootstrapEmployeeObject() {
		EmployeeNamedQueries employee = new EmployeeNamedQueries();
		String f = DataFaker.getFirstName();
		String l = DataFaker.getLastName();
		Double salary = DataFaker.getSalary();
		employee.setfName(f);
		employee.setlName(l);
		employee.setSalary(salary);
		employee.setEmail(DataFaker.getEmailId(f, l));
		employee.setAddress(DataFaker.getAddress());
		System.out.println(employee);
		return employee;
	}
}
