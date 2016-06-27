/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a list employee object and sort them by name in alphabetical order.
 */

package org.assignment.five.employeelist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// class to sort employees by alphabet
public class AlphabetSortEmp {

	// method
	public void sortByAlphabet(List<EmployeeList> employeeList) {

		// collections.sort is used in which list is passed and compare method
		// is overriden
		Collections.sort(employeeList, new Comparator<Object>() {

			@Override
			public int compare(Object employee1, Object employee2) {
				return ((EmployeeList) employee1).getEmployeeName().compareTo(
						((EmployeeList) employee2).getEmployeeName());

			}

		});

	}

}
