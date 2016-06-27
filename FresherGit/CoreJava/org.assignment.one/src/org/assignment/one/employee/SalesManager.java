package org.assignment.one.employee;

public class SalesManager extends Employee {

	// Variables Declaration
	private final float commission = 5000;

	// Default Constructor
	public SalesManager() {

	}

	// Parameterized Constructor
	public SalesManager(String nameOfEmployee, float salary) {
		super(nameOfEmployee, salary);
	}

	// Overridden blocks
	@Override
	public void calcSalary() {
		float salary = getSalary();
		float totalSalary = salary + commission;
		System.out.println("salary of manager" + totalSalary);
	}
}
