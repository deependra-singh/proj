package org.assignment.three.employee;

public class SalesManager extends Employee {
	private final float commission = 5000;
	
	public SalesManager(){
		
	}

	public SalesManager(String name, float salary) {
		super(name, salary);
	}

	@Override
	public void calcSalary(){
		float salary = getSalary();
		float totalSalary = salary + commission ;
		System.out.println("salary of manager" + totalSalary);	
	}
	
	
}
