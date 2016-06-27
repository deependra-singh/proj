/**
 * @author Deependra Singh
 * 
 * @purpose class employee and find highly paid employee and most senior
 * 			also sort on emp-id
 */

package org.extraassignment.five.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int exp;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int exp, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.salary = salary;
	}

	// METHOD TO SORT EMPLOYEES ON ID BASIS
	public void sortEmpOnId(List<Employee> empList) {

		Collections.sort(empList, new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				if (o1.id > o2.id)
					return 1;
				else if (o1.id < o2.id)
					return -1;
				else
					return 0;

			}
		});
		System.out.println("Sorted list on employee id " + empList);
	}

	// METHOD TO FIND HIGHEST PAID AND SENIOR EMPLOYEE
	public Employee findHighPaidEmp(List<Employee> empList) {
		double maxSalary = empList.get(0).salary;
		Employee e = new Employee();
		for (Employee employee : empList) {
			if (employee.salary > maxSalary) {
				maxSalary = employee.salary;
				e = employee;
			}
		}
		System.out.println("Highest paid and senior most employee is " + e);
		return e;
	}

	// TO FIND MOST EXPERIENCED EMPLOYEE
	public void findSeniorMostEmp(List<Employee> list) {
		Collections.sort(list);
	}

	// OVERRIDDEN METHOD TO FIND MOST EXPIRIENCED EMPLOYEE
	@Override
	public int compareTo(Employee o) {
		Employee emp = new Employee();
		if (this.exp < o.exp) {
			return -1;
		} else if (this.exp > o.exp) {
			return 1;
		} else {
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(o);
			empList.add(this);
			emp.findHighPaidEmp(empList);
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Employee id: " + id + ", name: " + name + ", exp: " + exp
				+ ", salary: " + salary;
	}

}
