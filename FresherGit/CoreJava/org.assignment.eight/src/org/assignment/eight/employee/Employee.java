package org.assignment.eight.employee;

/**
 * @author Deependra Singh
 * @purpose Insert and update employee data in database and display it using
 *          prepared statement. Insert some records into employee table.
 *
 */

// employee class
public class Employee {
	// fields
	private int empId;
	private String name;
	private float salary;

	// constructor
	public Employee(int empId, String name, float salary) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
	}

	// getters
	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	public int getEmpId() {
		return empId;
	}

}
