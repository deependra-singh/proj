package cyb.connection;

import java.sql.*;

public class MyConnection {
	public Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book","root","root");
		
		return con;
		
		
	}

}
