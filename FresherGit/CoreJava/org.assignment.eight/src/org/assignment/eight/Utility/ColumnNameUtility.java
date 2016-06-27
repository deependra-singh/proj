package org.assignment.eight.Utility;

import java.sql.*;
import java.util.Scanner;

import org.assignment.eight.connection.MyConnection;
import org.assignment.eight.genericcolname.ColumnName;

/**
 * @author Deependra Singh
 * @purpose Write generic code to display column names of a table alongwith the
 *          data in the table for employee table as well as student table.
 *
 */

public class ColumnNameUtility {

	public static void main(String[] args) {

		// create an instance of MyConnection class
		MyConnection con = new MyConnection();
		Scanner scanner;

		try {
			Connection c = con.connect();
			System.out.println("connected successfully");

			Statement statement = c.createStatement();
			scanner = new Scanner(System.in);

			System.out
					.println("Enter the table you want data from:(employee/students)");
			String tableName = scanner.next();

			// Check the tablename exist in DB or not
			DatabaseMetaData dbm = c.getMetaData();
			ResultSet rs = dbm.getTables(null, null, tableName, null);

			if (rs.next()) {
				System.out.println("Table exists");

				// execute the query and store the result in result set
				String strQuery = "select * from $tableName";
				String query = strQuery.replace("$tableName", tableName);
				ResultSet resultSet = statement.executeQuery(query);

				// call the method to show column names and its data
				ColumnName columnName = new ColumnName();
				columnName.retrieveColName(resultSet);

			} else {
				System.out.println("Table does not exist");
			}

			scanner.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
