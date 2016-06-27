/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a list employee object and sort them by name in alphabetical order.
 */

package org.assignment.five.tester;

import java.util.ArrayList;
import java.util.List;

import org.assignment.five.employeelist.AlphabetSortEmp;
import org.assignment.five.employeelist.EmployeeList;

public class SortAlphaEmployeeTester {

	public static void main(String[] args) {

		// List created to store Employees.
		List<EmployeeList> employeeList = new ArrayList<EmployeeList>();

		// hardcoded object values passed in employeelist
		employeeList.add(new EmployeeList("Deepu", 1001));
		employeeList.add(new EmployeeList("Kedar", 1100));
		employeeList.add(new EmployeeList("Ria", 1005));
		employeeList.add(new EmployeeList("Jinx", 1080));
		employeeList.add(new EmployeeList("Priyanshi", 1050));
		employeeList.add(new EmployeeList("Harsh", 1081));

		AlphabetSortEmp alphabetSortEmp = new AlphabetSortEmp();

		// Calling sort by alphabet method
		alphabetSortEmp.sortByAlphabet(employeeList);

		// for each loop to print sorted list of Employees.
		for (EmployeeList el : employeeList) {
			System.out.println(el);
		}

	}

}
