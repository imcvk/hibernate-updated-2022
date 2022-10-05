package using_annotation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "card")
public class CreditCard extends Payment {
	@Column(name = "CCTYPE")
	private String cc_type;

	public String getCc_type() {
		return cc_type;
	}

	public void setCc_type(String cc_type) {
		this.cc_type = cc_type;
	}
}
