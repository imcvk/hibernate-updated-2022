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

	public static  String getAadharNumber() {
		return String.valueOf(faker.number().randomDouble(0,1111111,999999));
	}
	public static  String getPanNumber(){
		return String.valueOf(faker.number().numberBetween(11111, 99999));
	}
	public static String getProjectName(){
		return faker.app().name();
	}
}
