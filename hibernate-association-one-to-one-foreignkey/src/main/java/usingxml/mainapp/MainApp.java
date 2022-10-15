package usingxml.mainapp;

import usingxml.entities.License;
import usingxml.entities.User;
import util.dbutil.DBUtils;
import util.dbutil.DataFaker;

import java.util.Date;

public class MainApp {
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		dbUtils.create(bootstrapLicense(new DataFaker()));

	}

	public static User bootstrapUser(DataFaker faker) {
		User user = new User();
		String username = faker.getName();
		user.setUsername(username);
		return user;
	}

	public static License bootstrapLicense(DataFaker faker) {
		License license = new License();
		Date issuedDate = new Date();
		Date expiryDate = new Date();
		User user = bootstrapUser(faker);
		license.setIssuedDate(issuedDate);
		license.setExpiryDate(expiryDate);
		license.setUser(user);
		return license;
	}
}
