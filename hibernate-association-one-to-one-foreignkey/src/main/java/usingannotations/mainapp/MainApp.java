package usingannotations.mainapp;


import usingannotations.entities.Address;
import usingannotations.entities.Student;
import util.dbutil.DBUtilsAnnotations;
import util.dbutil.DataFaker;

public class MainApp {
	public static void main(String[] args) {
		DBUtilsAnnotations dbUtilsAnnotations = new DBUtilsAnnotations();
		dbUtilsAnnotations.create(generateStudent(new DataFaker()));
	}

	public static Student generateStudent(DataFaker faker) {
		Student student = new Student();
		String name = faker.getName();
		student.setStudentName(name);
		student.setAddress(generateAddress(faker));
		System.out.println(student);
		return student;
	}

	public static Address generateAddress(DataFaker faker) {
		int hno = DataFaker.faker.number().numberBetween(111, 9999);
		String city = DataFaker.faker.address().city();
		String street = DataFaker.faker.address().streetAddress();
		return new Address(hno, street, city);
	}

}
