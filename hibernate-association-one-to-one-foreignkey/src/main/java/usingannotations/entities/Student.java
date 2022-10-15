package usingannotations.entities;

import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	@Embedded
	private Address address;

	public Student() {
	}

	public Student(int studentId, String studentName, Address address) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", studentName='" + studentName + '\'' +
				", address=" + address +
				'}';
	}
}
