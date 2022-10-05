package using_xml_configuration.entities;

public class CreditCard extends Payment{
	private String cc_type;

	public String getCc_type() {
		return cc_type;
	}

	public void setCc_type(String cc_type) {
		this.cc_type = cc_type;
	}
}
