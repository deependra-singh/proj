/**
 * @author Deependra Singh
 * 
 * @purpose class student and show polymorphism with age parameter
 */

package org.extraassignment.four.utility;

import java.util.Scanner;

import org.extraassignment.four.student.Student;

public class Utility {

	public static void main(String[] args) {

		int id;
		String name;
		int age;
		String ch = "n";

		Student student = new Student();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter id of student");
		id = sc.nextInt();

		System.out.println("Enter name of student");
		name = sc.next();

		// ASKING USER IF HE WANTS TO SAVE AGE ELSE CALL TWO PARAMETER METHOD
		System.out.println("Would you like to save age as well(yes/no)?");
		ch = sc.next();
		if (ch.equalsIgnoreCase("yes")) {
			System.out.println("Enter age of student");
			age = sc.nextInt();
			student.setData(id, name, age);
		}

		else
			student.setData(id, name);

	}

}
