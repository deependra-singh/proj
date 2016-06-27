package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utility.Utility;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection con;
	private PreparedStatement pst1,pst2;
	
	
	@Override
	public void init() throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		response.setContentType("text/html");
		int bPrice,maxId=1;
		String bName,bAuthor;
		PrintWriter pw = response.getWriter();
		System.out.println("add book");
		Connection con = (Connection)request.getSession().getAttribute("connection");
		try 
		{
			bName = request.getParameter("Bookname");
			bAuthor = request.getParameter("Bookauthor");
			bPrice = Integer.parseInt(request.getParameter("Bookprice"));
			
			pst1 = con.prepareStatement("select max(book_id) from books");
			pst2 = con.prepareStatement("insert into books values(?,?,?,?)");
			
			ResultSet rs = pst1.executeQuery();
			System.out.println("pst1");
			if(rs.next())
				maxId = rs.getInt(1);
			
			pst2.setInt(1, maxId+1);
			pst2.setString(2, bName);
			pst2.setString(3, bAuthor);
			pst2.setInt(4, bPrice);
			int res =pst2.executeUpdate();
			
			if(res == 1)
				pw.print("Book Added Succesfully");
			else
				pw.print("Book not Added");
				
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.include(request, response);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	

}
