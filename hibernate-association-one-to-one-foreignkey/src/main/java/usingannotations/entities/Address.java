package usingannotations.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private int addressId;
	private String street;
	private String city;

	public Address() {
	}

	public Address(int addressId, String street, String city) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address{" +
				"addressId=" + addressId +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
