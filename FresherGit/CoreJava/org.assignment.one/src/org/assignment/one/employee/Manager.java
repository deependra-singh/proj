package org.assignment.one.employee;

public class Manager extends Employee {

	// Variables Declaration
	private final float allowance = 4000;

	// Default Constructor
	public Manager() {
		super();

	}

	// Parameterized Constructor
	public Manager(String nameOfEmployee, float salary) {
		super(nameOfEmployee, salary);
	}

	// Overridden blocks
	@Override
	public String toString() {
		return "Manager [allowance=" + allowance + "]";
	}

	@Override
	public void calcSalary() {
		float salary = getSalary();
		float totalSalary = salary + allowance;
		System.out.println("salary of manager" + totalSalary);

	}

}
