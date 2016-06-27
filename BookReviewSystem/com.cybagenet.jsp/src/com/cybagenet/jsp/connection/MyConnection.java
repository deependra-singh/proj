package com.cybagenet.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	// STATIC METHOD TO RETURN OBJECT OF CONNECTION
	public static Connection connect() {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/book?useSSL=false", "root", "root");

			return con;
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
