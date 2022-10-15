package usingxml.mainapp;

import usingxml.entities.Address;
import usingxml.entities.Student;
import util.dbutil.DBUtilsXML;
import util.dbutil.DataFaker;


public class MainApp {
	public static void main(String[] args) {
		DBUtilsXML dbUtilsXML = new DBUtilsXML();
		dbUtilsXML.create(generateStudent(new DataFaker()));
	}

	public static Student generateStudent(DataFaker faker) {
		Student student = new Student();
		String name = faker.getName();
		Address address = generateAddress(faker);
		student.setStudentName(name);
		student.setAddress(address);
		return student;
	}

	public static Address generateAddress(DataFaker faker) {
		Address address = new Address();
		int hno = DataFaker.faker.number().numberBetween(111, 9999);
		String city = DataFaker.faker.address().city();
		String street = DataFaker.faker.address().streetAddress();
		address.setCity(city);
		address.setStreet(street);
		address.setHno(hno);
		return address;
	}
}
