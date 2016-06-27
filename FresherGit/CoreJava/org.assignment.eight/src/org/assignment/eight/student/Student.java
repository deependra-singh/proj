package org.assignment.eight.student;

/**
 * @author Deependra Singh
 * @purpose Insert and update student data in database and display it using
 *          prepared statement. Insert some records into students table.
 *
 */

// student class
public class Student {
	// fields of student class
	private int rollNumber;
	private String studentName;
	private String address;

	// constructor
	public Student(int rollNumber, String studentName, String address) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.address = address;
	}

	// getters
	public int getRollNumber() {
		return rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getAddress() {
		return address;
	}

}
