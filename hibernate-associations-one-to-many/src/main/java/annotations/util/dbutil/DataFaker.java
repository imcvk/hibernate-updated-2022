package annotations.util.dbutil;

import com.github.javafaker.Faker;

import java.util.Date;

public class DataFaker {
	public static Faker faker = new Faker();

	public String getName() {
		return getLastName() + "," + getLastName();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getEmailId(String fName, String lName) {
		return fName + lName + "@gmail.com";
	}

	public String getAddress() {
		return faker.address().fullAddress();
	}

	public Date getBirthDateDate() {
		return faker.date().birthday();
	}

	public Double getSalary() {
		return faker.number().randomDouble(0, 11111, 999999);
	}

	public String getPosition() {
		return faker.job().position();
	}

	public String getBookName() {
		return faker.book().title();
	}
}
