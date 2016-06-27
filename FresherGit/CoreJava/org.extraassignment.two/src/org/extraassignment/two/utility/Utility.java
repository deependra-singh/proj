package org.extraassignment.two.utility;

import java.util.Scanner;

import org.extraassignment.two.student.Student;

public class Utility {

	public static void main(String[] args) {
		int totalStudents;

		try {
			int i;
			Student student = new Student();
			int n;

			Scanner sc = new Scanner(System.in);

			//ACCEPTING TOTAL NUMBER OF STUDENTS
			System.out.println("Enter number of students ");
			totalStudents = sc.nextInt();

			String[] students = new String[totalStudents];
			
			//POPULATING ARRAY WITH NAMES OF STUDENTS
			for (i = 0; i < students.length; i++) {
				System.out.println("Enter the name of " + (i+1) + " th student");
				students[i] = sc.next();
			}

			//ACCEPTING CHOICE AND PROCEEDING ACCORDINGLY
			System.out.println("Enter the index of student you want to search");
			n = sc.nextInt();
			System.out.println("student of" + n + "th index is :"
					+ student.searchStudent(n-1, students));

			sc.close();
		} catch (Exception e) {
			System.out.println("please enter no between 1 to 7");
		}

	}

}
