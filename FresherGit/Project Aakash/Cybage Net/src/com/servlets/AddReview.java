package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection con = (Connection) request.getSession().getAttribute("connection");
		PrintWriter pw = response.getWriter();
		String bname = request.getParameter("b_name");
		String breview = request.getParameter("b_review");
		System.out.println("finish");
		try {
			PreparedStatement pst = con.prepareStatement("insert into reviews(book_name,book_review) values(?,?)");
			pst.setString(1,bname );
			pst.setString(2,breview );
			pst.executeUpdate();
			pw.print("Review added");
			RequestDispatcher rd = request.getRequestDispatcher("user.html");
			rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

	
}
