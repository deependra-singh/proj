package org.assignment.eight.genericcolname;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Deependra Singh
 * @purpose Write generic code to display column names of a table alongwith the
 *          data in the table for employee table as well as student table.
 *
 */

public class ColumnName {

	public void retrieveColName(ResultSet resultSet) {

		try {
			// resultSet meta data to get meta data
			ResultSetMetaData metadata = resultSet.getMetaData();

			// count the number of columns in the table
			int columnCount = metadata.getColumnCount();

			// create an array list to store the column names
			ArrayList<String> columns = new ArrayList<String>();

			// loop to add column name to the array list
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metadata.getColumnName(i);
				columns.add(columnName);
			}

			// print the column names
			for (int i = 0; i < columnCount; i++) {
				System.out.print(columns.get(i) + "\t");
			}
			System.out.println();

			// if result set has next value, get into the loop
			while (resultSet.next()) {

				// loop to display data
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}