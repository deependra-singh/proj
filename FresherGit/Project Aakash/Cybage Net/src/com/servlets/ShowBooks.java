package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBooks
 */
@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement pst1;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		System.out.println("show books");
		Connection con = (Connection)request.getSession().getAttribute("connection");
		PrintWriter pw = response.getWriter();
		try
		{
			pst1 = con.prepareStatement("select * from books");
			ResultSet rst = pst1.executeQuery();
			pw.print("<table>");
			pw.print("<form action='DeleteBook' method='post'>");
			while(rst.next())
			{
				pw.print("<tr>");
				pw.print("<td><input type='checkbox' name='book' value='"+ rst.getInt(1) +"'>"+ rst.getString(2)+"");
				pw.print("</td>");
				pw.print("<td>");
				pw.print(rst.getString(3));
				pw.print("</td>");
				pw.print("</tr>");
			}
			pw.print("<td colspan='2' align='center'> <input type='submit' value='DELETE'></td>");
			pw.print("</form>");
			pw.print("</table>");
			
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.include(request, response);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	

}
