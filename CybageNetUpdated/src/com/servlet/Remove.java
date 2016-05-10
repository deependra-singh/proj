package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.MyConnection;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option=request.getParameter("book");
		System.out.println(option);
		Connection con = null;
		response.setContentType("text/html");;
		PrintWriter out = response.getWriter();
		
		try {
			con = MyConnection.connect();
		
		if(option!=null) {
			PreparedStatement ps;
			
				ps = con.prepareStatement("delete from books where name=?");
		
			ps.setString(1,option);
			ps.execute();
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(option + " is removed from database ");
			
			out.println("<br><br>Wait until you are redirected to your home page..") ;
		
			response.setHeader("Refresh", "5;adminPage");
		}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
