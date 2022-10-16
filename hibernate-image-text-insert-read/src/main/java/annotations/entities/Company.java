package annotations.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;
	@Lob
	@Column(length = 1000000)
	private byte[] image;
	@Lob
	@Column(length = 1000000)
	private char[] resume;
}
