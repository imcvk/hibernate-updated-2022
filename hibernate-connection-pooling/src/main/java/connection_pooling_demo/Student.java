package connection_pooling_demo;

public class Student {
	int studentId;
	String name;

	public Student(int studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}

	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
