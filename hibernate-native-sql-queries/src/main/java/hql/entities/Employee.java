package hql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fName;
	String lName;
	String email;
	String address;
	Double salary;
	String position;

	public static String printData(Employee employee) {
		return "id:" + employee.id
				+ "fName:" + employee.fName
				+ "lName:" + employee.lName
				+ "email:" + employee.email
				+ "address:" + employee.address
				+ "salary:" + employee.salary
				+ "position:" + employee.position;
	}
}
