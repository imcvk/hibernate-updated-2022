package using_xml_configuration.entities;

public class Cheque extends Payment {
	private String cheque_type;

	public String getCheque_type() {
		return cheque_type;
	}

	public void setCheque_type(String cheque_type) {
		this.cheque_type = cheque_type;
	}
}
