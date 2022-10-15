package hql.mainapp;

import com.github.javafaker.Faker;
import hql.dbutil.HQL_Non_Select;
import hql.dbutil.HQL_Select;
import hql.entities.Employee;
import util.DataFaker;

public class MainApp {
	public static Faker faker = null;

	public static void main(String[] args) {
		HQL_Non_Select hql_non_select=new HQL_Non_Select();
		//hql_non_select.update_using_hql("Technician");
		hql_non_select.delete(11852);
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
	public static void HQL_Select_Demo(){
		HQL_Select hql_operations = new HQL_Select();
		for (int i = 0; i < 50; i++) {
			hql_operations.create(bootstrapEmployeeObject());
		}
		hql_operations.read_all_using_hql();
		hql_operations.read_all_using_positional_parameters(11852);
		hql_operations.read_all_using_named_parameter(1500);
		hql_operations.positional_and_named_parameter(5000, 10000);
		hql_operations.retrieve_specific_columns();
		hql_operations.retrieveSingleColumn();
		hql_operations.where_clause();
		hql_operations.countEmployees();
		hql_operations.average_sum_min_max();
		hql_operations.subQueryDemo();
	}
}
