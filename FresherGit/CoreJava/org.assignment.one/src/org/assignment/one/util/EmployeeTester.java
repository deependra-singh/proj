package org.assignment.one.util;

import java.util.Scanner;

import org.assignment.one.employee.Employee;
import org.assignment.one.employee.Manager;
import org.assignment.one.employee.SalesManager;

public class EmployeeTester {
	
	public void testEmployee() {

		// Reference Declaration
		Employee m;

		Scanner sc = new Scanner(System.in);

		// Input Block
		System.out
				.println("Enter type of employee:(Manager/SalesManager/Others)");
		String type = sc.next();

		System.out.println("Enter name:");
		String nameOfEmployee = sc.next();

		System.out.println("Enter Salary:");
		float salary = sc.nextFloat();

		// Conditional Block
		if (type.equalsIgnoreCase("manager")) {
			m = new Manager(nameOfEmployee, salary);
			m.calcSalary();
		}

		else if (type.equalsIgnoreCase("salesmanager")) {
			m = new SalesManager(nameOfEmployee, salary);
			m.calcSalary();
		}

		else {
			m = new Employee(nameOfEmployee, salary);
			m.calcSalary();
		}

		sc.close();

	}
}