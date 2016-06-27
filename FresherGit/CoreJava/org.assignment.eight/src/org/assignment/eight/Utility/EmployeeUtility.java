package org.assignment.eight.Utility;

import java.sql.*;
import java.util.Scanner;

import org.assignment.eight.connection.MyConnection;
import org.assignment.eight.employee.Employee;

/**
 * @author Deependra Singh
 * @purpose Insert and update employee data in database and display it using
 *          prepared statement. Insert some records into employee table.
 *
 */

public class EmployeeUtility {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// create an instance of MyConnection class
		MyConnection con = new MyConnection();

		// connect and store the returned connection
		Connection c = con.connect();
		System.out.println("connected successfully");

		Scanner sc = new Scanner(System.in);

		// menu for the user
		System.out
				.println("MENU: \n 1. Add new Employee. \n 2. Update already existing Employee.");
		int ch = sc.nextInt();
		switch (ch) {
		// if employee has to be added
		case 1:
			// get details of the employee
			System.out.println("Enter name:");
			String name = sc.next();

			System.out.println("Enter employee ID:");
			int empId = sc.nextInt();

			System.out.println("Enter salary:");
			float salary = sc.nextFloat();

			// create an employee object
			Employee employee = new Employee(empId, name, salary);

			// create query, prepared statement is used as values has to be set
			// by the user
			PreparedStatement pst = c
					.prepareStatement("insert into employee values (?,?,?)");

			pst.setInt(1, employee.getEmpId());
			pst.setString(2, employee.getName());
			pst.setFloat(3, salary);
			// execute the query
			pst.execute();
			break;

		case 2:
			// enter the name of employee to be updated
			System.out.println("Enter name of employee to be updated:");
			String eName = sc.next();

			// enter salary to be updated
			System.out.println("Enter salary to be updated:");
			float eSalary = sc.nextFloat();

			// prepared statement to store the query
			PreparedStatement pst2 = c
					.prepareStatement("update employee set salary = ? where emp_name=?");

			// set the values
			pst2.setString(2, eName);
			pst2.setFloat(1, eSalary);

			// execute the statement
			System.out.println(pst2.executeUpdate());

			break;
		}
	}

}
