package select_operation_in_hql.mainapp;

import com.github.javafaker.Faker;
import select_operation_in_hql.dbutil.DBUtils;
import select_operation_in_hql.entities.Employee;

import java.util.Random;

public class MainApp {
	public static Faker faker = null;

	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();

		int id = new Random().nextInt(1111, 9999);
		String name = getFirstName();
		Employee employee = new Employee(id, name);
		//	dbUtils.create(employee);

//		dbUtils.readUsing_HQL();
//		dbUtils.readRecordUsingHQL();
//		dbUtils.non_select_operations_using_hql();
//		dbUtils.insertRecordHQL_Query();
		dbUtils.update_using_HQL();
	}

	public static String getFirstName() {
		faker = new Faker();
		String name = faker.name().firstName();
		return name;
	}

	public String getLastName() {
		faker = new Faker();
		String name = faker.name().lastName();
		return name;
	}

	public String getFullName() {
		faker = new Faker();
		String name = faker.name().fullName();
		return name;
	}
}
