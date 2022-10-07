package util;

import com.github.javafaker.Faker;

import java.util.Date;

public class DataFaker {
	public static Faker faker = new Faker();

	public static String getFirstName() {
		return faker.name().firstName();
	}

	public static String getLastName() {
		return faker.name().lastName();
	}

	public static String getEmailId(String fName, String lName) {
		return fName + lName + "@gmail.com";
	}

	public static String getAddress() {
		return faker.address().fullAddress();
	}

	public static Date getBirthDateDate() {
		return faker.date().birthday();
	}
	public static Double getSalary(){
		return faker.number().randomDouble(0,11111,999999);
	}
	public static String getPosition(){
		return faker.job().position();
	}
}
