package using_annotation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cheque")
public class Cheque extends Payment {
	@Column(name = "CTYPE")
	private String cheque_type;

	public String getCheque_type() {
		return cheque_type;
	}

	public void setCheque_type(String cheque_type) {
		this.cheque_type = cheque_type;
	}
}
