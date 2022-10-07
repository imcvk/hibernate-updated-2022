package mainapp;

import DBUtil.DBUTILS;
import entities.Employee;
import entities.Student;
import util.DataFaker;

import java.util.*;

public class MainApp {
	public static void main(String[] args) {
		DBUTILS dbutils = new DBUTILS();
//		dbutils.create(bootstrapEmployeeObject());
//		dbutils.read();
		dbutils.create(bootstrapStudent());
		dbutils.read();
	}

	public static Employee bootstrapEmployeeObject() {
		Employee employee = new Employee();
		String f = DataFaker.getFirstName();
		String l = DataFaker.getLastName();
		employee.setFName(f);
		employee.setLName(l);
		/* List of friends*/
		List<String> list_of_friends = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String friend_name = DataFaker.getFirstName();
			list_of_friends.add(friend_name);
		}
		employee.setFriends(list_of_friends);
		/*Map of cards */
		Map<String, String> map_of_cards = null;
		String Aadhar = "AADHAR";
		String pan = "PAN";
		map_of_cards = Map.of(Aadhar, DataFaker.getAadharNumber(), pan, DataFaker.getPanNumber());
		employee.setCards(map_of_cards);
		/*Set of projects*/
		Set<String> set_of_projects = Set.of(DataFaker.getProjectName(), DataFaker.getProjectName());
		employee.setProjects(set_of_projects);
		return employee;
	}

	public static Student bootstrapStudent() {
		Student s = new Student();
		s.setName(DataFaker.getFirstName() + " " + DataFaker.getLastName());
		List<String> friends = List.of(DataFaker.getFirstName(), DataFaker.getFirstName());
		s.setFriends(friends);
		String projectName = "Name";
		Map<String, String> projects = Map.of(DataFaker.getProjectName(), DataFaker.getProjectName());
		s.setProjects(projects);
		Set<String> books = Set.of(DataFaker.faker.book().title(), DataFaker.faker.book().title());
		s.setBooks(books);
		return s;
	}
}
