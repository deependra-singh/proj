package org.assignment.three.employee;

public class Employee {
	private String name;
	private  float salary;

	public Employee(){ 
	}
	
	public Employee(String name, float salary) {
		super();
		this.name = name;
		this.salary = salary ;
	}
	
	public float getSalary() {
		return salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}

	public void calcSalary(){
		System.out.println("Salary of employee is"+salary);
	}
	
	
	
}
