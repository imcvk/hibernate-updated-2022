package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int eid;
	String fName;
	String lName;
	@ElementCollection
	@CollectionTable(name = "emp_friends", joinColumns = @JoinColumn(name = "eid"))
	@OrderColumn(name = "pos")
	private List<String> friends;

	@ElementCollection
	@CollectionTable(name = "emp_cards", joinColumns = @JoinColumn(name = "eid"))
	private Map<String, String> cards;

	@ElementCollection
	@CollectionTable(name = "emp_projects", joinColumns = @JoinColumn(name = "eid"))
	private Set<String> projects;

	public void printDetails(Employee e) {
		System.out.println("Employee ID:" + e.getEid());
		System.out.println("Employee Name:" + e.getFName() + " " + e.getLName());
		System.out.println("All Friends: " + e.getFriends());
		System.out.println("Cards added:");
		for (Map.Entry<String, String> card : e.getCards().entrySet()) {
			System.out.println(card.getKey() + ":" + card.getValue());
		}
		System.out.println();
		System.out.println("Projects:");
		for (String project : e.getProjects()) {
			System.out.print(project + ",");
		}
	}
}
