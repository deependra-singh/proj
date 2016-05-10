package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.listeners.SessionCounter;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/getValidUser")
public class GetValidUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetValidUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		SessionCounter counter = (SessionCounter) session.getAttribute(SessionCounter.COUNTER);

		try {
			PrintWriter out = response.getWriter();
			int noOfUsers = counter.getActiveSessionNumber();
			if(noOfUsers == 0)
			{
				out.print("<h3>Currently " + ((noOfUsers)) + " user(s) are logged in...</h3>");
			}
			else
			{
				out.print("<h3>Currently " + ((noOfUsers) - 1) + " user(s) are logged in...</h3>");
			}
			out.print("<h4 align = 'right'><a href = adminPage> Go back </a><h4>");
			out.print("<h4 align = 'right'><a href = index.html> Logout </a><h4>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
