/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a list employee object and sort them by name in alphabetical order.
 */

package org.assignment.five.employeelist;

public class EmployeeList {

	private String employeeName;
	private int employeeID;

	// parameterised constructor
	public EmployeeList(String employeeName, int employeeID) {
		super();
		this.employeeName = employeeName;
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "employeeName=" + employeeName + ", employeeID=" + employeeID;
	}

}
