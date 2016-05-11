package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.MyConnection;

public class BookDAO {

	Connection con;
	PreparedStatement pst;
	ResultSet rst;

	public boolean addBook(String bookName, String bookAuthor, String bookPublisher) {
		try{
			con = MyConnection.connect();
			
			pst=con.prepareStatement("insert into books(book_name,book_author,book_publisher) values(?,?,?)");
			pst.setString(1,bookName);
			pst.setString(2,bookAuthor);
			pst.setString(3,bookPublisher);
			return pst.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
			return true;
		}
	}

	public boolean removeBook(String option) {
		
		try{
			con = MyConnection.connect();
			pst = con.prepareStatement("delete from books where book_name=?");
			pst.setString(1,option);
			return pst.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
			return true;
		}

	}

	public ResultSet searchBook(String bookName) {
		try {
			con = MyConnection.connect();

			String s = "select book_name from books where book_name like '%$bookname";
			String str = s.replace("$bookname", bookName);
			String query = str.concat("%'");

			pst = con.prepareStatement(query);
			rst = pst.executeQuery();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return rst;
	}

}
