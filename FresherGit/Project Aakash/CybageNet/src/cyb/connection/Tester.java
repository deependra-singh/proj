package cyb.connection;

import java.sql.Connection;
import java.sql.SQLException;

import cyb.connection.MyConnection;

public class Tester {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		System.out.println("inside main");
		MyConnection con = new MyConnection();
				
				Connection c = con.connect();
				
				System.out.println("connected successfully");
				
				
	}	
}
