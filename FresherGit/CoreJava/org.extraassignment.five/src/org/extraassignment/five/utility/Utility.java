/**
 * @author Deependra Singh
 * 
 * @purpose class employee and find highly paid employee and most senior
 * 			also sort on emp-id
 */

package org.extraassignment.five.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.extraassignment.five.employee.Employee;

public class Utility {

	public static void main(String[] args) {
		int ch;

		Employee employee = new Employee();
		List<Employee> list = new ArrayList<Employee>();
		list = Arrays.asList(new Employee(1, "Kedar", 22, 17750), new Employee(
				6, "Deepu", 22, 17751), new Employee(89, "Ria", 21, 10000));

		Scanner sc = new Scanner(System.in);

		// ACCEPTING CHOICE AND PROCEED ACCORDINGLY
		System.out
				.println("Choose \n 1. To find highest paid and senior most employee \n 2. Sort the employees based on employee id");

		ch = sc.nextInt();

		switch (ch) {
		case 1:
			employee.findSeniorMostEmp(list);
			break;

		case 2:
			employee.sortEmpOnId(list);
			break;

		default:
			System.out.println("Please enter a correct choice");
		}
		sc.close();
	}
}