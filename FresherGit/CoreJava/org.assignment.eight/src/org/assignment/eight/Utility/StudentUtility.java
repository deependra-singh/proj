package org.assignment.eight.Utility;

import java.sql.Connection;

/**
 * @author Ria Chawla
 * @purpose Insert and update student data in database and display it using
 *          prepared statement. Insert some records into student table.
 *
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.assignment.eight.connection.MyConnection;
import org.assignment.eight.student.Student;

/**
 * @author Deependra Singh
 * @purpose Insert and update student data in database and display it using
 *          prepared statement. Insert some records into students table.
 *
 */

public class StudentUtility {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		MyConnection con = new MyConnection();

		Connection c = con.connect();
		System.out.println("connected successfully");

		Scanner sc = new Scanner(System.in);
		System.out
				.println("MENU: \n 1. Add new Student. \n 2. Update already existing Student.");
		int ch = sc.nextInt();
		switch (ch) {

		case 1:
			System.out.println("Enter name:");
			String name = sc.next();

			System.out.println("Enter student's roll number:");
			int rollNumber = sc.nextInt();

			System.out.println("Enter student's address:");
			String address = sc.next();

			Student student = new Student(rollNumber, name, address);

			PreparedStatement pst = c
					.prepareStatement("insert into students values (?,?,?)");

			pst.setInt(1, student.getRollNumber());
			pst.setString(2, student.getStudentName());
			pst.setString(3, student.getAddress());

			pst.execute();
			break;

		case 2:
			System.out.println("Enter name of student to be updated:");
			String studentName = sc.next();

			System.out.println("Enter address to be updated:");
			String studentAddress = sc.next();

			PreparedStatement pst2 = c
					.prepareStatement("update students set address = ? where stud_name=?");
			pst2.setString(2, studentName);
			pst2.setString(1, studentAddress);

			System.out.println(pst2.executeUpdate());

			break;
		}
	}

}
