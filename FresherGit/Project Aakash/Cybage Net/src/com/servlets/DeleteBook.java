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



/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement pst1;
       
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		Connection con = (Connection)request.getSession().getAttribute("connection");
		PrintWriter pw = response.getWriter();
		try {
			pst1 = con.prepareStatement("delete from books where book_id=?");
			
			String[] ids = request.getParameterValues("book");
			
			for(int i =0;i<ids.length;i++)
			{
				int id = Integer.parseInt(ids[i]);
				pst1.setInt(1, id);
				pst1.executeUpdate();
			}
			pw.print("Deleted Succesfully");
			System.out.println("deleted");
			
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.include(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
