/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create sorted set of employee objects and sort them on basis of employee-id
 */

package org.assignment.five.employee;

public class SortedSetEmployee implements Comparable<SortedSetEmployee> {

	private String employeeName;
	private int employeeID;

	// default constructor
	public SortedSetEmployee() {
		super();
	}

	// parameterised constructor
	public SortedSetEmployee(String employeeName, int employeeID) {
		super();
		this.employeeName = employeeName;
		this.employeeID = employeeID;
	}

	// getter
	public int getEmployeeID() {
		return employeeID;
	}

	@Override
	public int compareTo(SortedSetEmployee e) {
		// check if employee id of first is greater than that of second employee
		if (this.getEmployeeID() > e.getEmployeeID())
			return 1;
		// check if employee id of first is smaller than that of second employee
		if (this.getEmployeeID() < e.getEmployeeID())
			return -1;
		// if equal then return 0;
		else
			return 0;

	}

	@Override
	public String toString() {
		return "Employee Name=" + employeeName + "\n" + "Employee ID="
				+ employeeID + "\n\n";
	}

}
