package hql.mainapp;

import com.github.javafaker.Faker;
import hql.dbutil.DBUtil_Native_SQL;
import hql.entities.Employee;
import util.DataFaker;

public class MainApp {
	public static Faker faker = null;

	public static void main(String[] args) {
		DBUtil_Native_SQL dbUtil_native_sql = new DBUtil_Native_SQL();
//		insertBulk(dbUtil_native_sql);
//		dbUtil_native_sql.simple_select_native_sql1();
//		dbUtil_native_sql.simple_select_native_sql2();
//		dbUtil_native_sql.select_conditional();
//		dbUtil_native_sql.select_conditional1();
//		dbUtil_native_sql.updateUsingNativeSQL();
		dbUtil_native_sql.insertUsingSQL(bootstrapEmployeeObject());
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

	public static void insertBulk(DBUtil_Native_SQL dbUtil_native_sql) {
		for (int i = 0; i < 10; i++) {
			dbUtil_native_sql.create(bootstrapEmployeeObject());
		}
		dbUtil_native_sql.commitTransactions();
	}
}
