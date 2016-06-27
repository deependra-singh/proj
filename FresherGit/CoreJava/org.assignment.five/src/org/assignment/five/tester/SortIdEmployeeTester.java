/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create sorted set of employee objects and sort them on basis of employee-id
 */

package org.assignment.five.tester;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.assignment.five.employee.SortedSetEmployee;

public class SortIdEmployeeTester {

	public static void main(String[] args) {

		// Created set for employee objects.
		Set<SortedSetEmployee> employeeList = new TreeSet<SortedSetEmployee>();

		// hard coded values inserted into set
		employeeList.add(new SortedSetEmployee("Deepu", 1));
		employeeList.add(new SortedSetEmployee("Kedar", 2));
		employeeList.add(new SortedSetEmployee("Ria", 10));
		employeeList.add(new SortedSetEmployee("Cheepu", 4));
		employeeList.add(new SortedSetEmployee("Jinx", 8));

		System.out
				.println("The Employee Information as Sorted on Employee ID is:");

		// Iterator for employee set.
		Iterator<SortedSetEmployee> empolyeeIterator = employeeList.iterator();

		// loop to print sorted employee set
		while (empolyeeIterator.hasNext()) {
			System.out.print(empolyeeIterator.next());
		}

	}

}
