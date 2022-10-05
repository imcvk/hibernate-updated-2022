package util;

import com.github.javafaker.Faker;

public class test {
	public static void main(String[] args) {
		Faker faker=new Faker();
		String job=faker.job().field();
		System.out.println(job);
	}
}
