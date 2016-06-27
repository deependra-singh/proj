package org.assignment.three.employee;

public class Manager extends Employee {
	
	private final float allowance = 4000;
	public Manager(){
		super();
		
	}

	public Manager(String name, float salary) {
		super(name, salary);
	}

	@Override
	public String toString() {
		return "Manager [allowance=" + allowance + "]";
	}
	
	@Override
	public void calcSalary(){
		float salary = getSalary();
		float totalSalary = salary + allowance ;
		System.out.println("salary of manager" + totalSalary);	
		
	}
	
}
