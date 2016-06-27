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
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement pst1;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = (Connection)request.getSession().getAttribute("connection");
		
		try {
			pst1 = con.prepareStatement("select * from books where book_name like ?");
			pst1.setString(1, "%"+request.getParameter("book")+"%");
			ResultSet rst = pst1.executeQuery();
			
			pw.print("<table>");
			pw.print("<form action='ShowReviews' method='post'>");
			while(rst.next())
			{
				pw.print("<tr>");
				pw.print("<td><input type='radio' name='book' value='"+ rst.getString(2)+"-"+rst.getString(3)+"-"+rst.getInt(4)+"'>"+ rst.getString(2)+"");
				pw.print("</td>");
				pw.print("</tr>");
			}
			pw.print("<td colspan='2' align='center'> <input type='submit' value='Show Details'></td>");
			pw.print("</form>");
			pw.print("</table>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
