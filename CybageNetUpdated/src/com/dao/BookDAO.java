package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.pojo.Book;

public class BookDAO {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	
	public void addBook()
	{
		
	}

	public void removeBook()
	{
		
	}
	
	public ResultSet searchBook(String bookName)
	{
		
		System.out.println("in search book");
		
		try {
				con = MyConnection.connect();
				
				String s = "select * from books where name like '%$bookname";
				String str = s.replace("$bookname", bookName);
				String query = str.concat("%'");
	
				pst = con.prepareStatement(query);
				rst = pst.executeQuery();
	
				System.out.println("rst in dao "+rst);
				/*if(rst.next())
				{
				while (rst.next()) {
					bookNames.add(rst.getString(1));
					System.out.println("list in dao is "+bookNames);
				}}
				else
				{
					bookNames.add("no records found");
				}
				
				
				*/
			}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return rst;
	}
	
}
