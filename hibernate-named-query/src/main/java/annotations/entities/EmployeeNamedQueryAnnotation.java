package annotations.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "getAllEmployeeshql", query = "from EmployeeNamedQueryAnnotation e")
@NamedQuery(name = "getAllEmployeesNative", query = "select e.id,e.address,e.email,e.fName,e.lName,e.salary from EmployeeNamedQueryAnnotation e")
public class EmployeeNamedQueryAnnotation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String fName;
	String lName;
	String email;
	String address;
	Double salary;

}
