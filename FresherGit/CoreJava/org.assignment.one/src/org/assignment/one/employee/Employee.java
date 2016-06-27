package org.assignment.one.employee;

public class Employee {

	// Variables Declaration
	private String nameOfEmployee;
	private float salary;

	// Default Constructor
	public Employee() {
	}

	// Parameterized Constructor
	public Employee(String name, float salary) {
		super();
		this.nameOfEmployee = name;
		this.salary = salary;
	}

	// Getter for Name
	public String getName() {
		return nameOfEmployee;
	}

	// Getter for Salary
	public float getSalary() {
		return salary;
	}

	// Function to be overridden by child classes
	public void calcSalary() {
		System.out.println("Salary of employee is" + salary);
	}

}
