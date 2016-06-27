package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowReviews
 */
@WebServlet("/ShowReviews")
public class ShowReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = (Connection)request.getSession().getAttribute("connection");
		try 
		{
			PreparedStatement pst= con.prepareStatement("select * from reviews where book_name = ?");
			String details[] = request.getParameter("book").split("-");
			
			pst.setString(1, details[0]);
			ResultSet rst = pst.executeQuery();
			pw.print("<h3 align='center'>");
			pw.print("Book details are = <br>");
			pw.println("Book name = "+details[0] +"   Book author = "+details[1]+"   Book price = "+details[2]+"<br>");
			pw.println("Reviews =<br>");
			pw.print("<table align='center'>");
			
			while(rst.next())
			{
				pw.print("<tr>");
				pw.print("<td>");
				pw.print(rst.getString(2));
				pw.print("</td>");
				pw.print("</tr>");
			}
			
			pw.print("<form action='AddReview' method='post'>");
			pw.print("<input type='hidden' name='b_name' value='"+details[0] +"'> ");
			pw.print("<tr>");
			pw.print("<td><input type='text' name='b_review'></td>");
			pw.print("<td> <input type='submit' value='ADD REVIEW'></td>");
			pw.print("</tr>");
			pw.print("</form>");
			pw.print("</table>");
			pw.print("</h3>");
			
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
	}

}
