package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String name;

	@ElementCollection
	@CollectionTable(
			name = "stud_friends", joinColumns = @JoinColumn(name = "studentId"))
	private List<String> friends;
	@ElementCollection
	@CollectionTable(name = "stud_projects", joinColumns = @JoinColumn(name = "studentId"))
	private Map<String, String> projects;
	@ElementCollection
	@CollectionTable(name = "stud_books", joinColumns = @JoinColumn(name = "studentId"))
	private Set<String> books;

	public void printDetails(Student e) {
		System.out.println("Student ID:" + e.getStudentId());
		System.out.println("Student Name:" + e.getName());
		System.out.println("All Friends: " + e.getFriends());
		System.out.println("projects added:");
		for (Map.Entry<String, String> projects : e.getProjects().entrySet()) {
			System.out.println(projects.getKey() + ":" + projects.getValue());
		}
		System.out.println("Books:");
		for (String project : e.getBooks()) {
			System.out.print(project + ",");
		}
	}
}
