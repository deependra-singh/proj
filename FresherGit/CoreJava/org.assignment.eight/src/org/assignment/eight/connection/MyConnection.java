package org.assignment.eight.connection;

import java.sql.*;

/**
 * @author Deependra Singh
 * @purpose This calss is common to get the connection established in the
 *          questions involved.
 *
 */
public class MyConnection {
	public Connection connect() throws ClassNotFoundException, SQLException {
		// load the driver
		Class.forName("com.mysql.jdbc.Driver");

		// establish connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/java", "root", "root");

		return con;

	}

}
