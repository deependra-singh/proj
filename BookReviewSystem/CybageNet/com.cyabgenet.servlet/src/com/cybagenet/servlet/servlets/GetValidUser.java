package com.cybagenet.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybagenet.servlet.listeners.SessionCounter;

/**
 * Servlet implementation class AddBook
 */

// SERVLET TO SERVE REQUEST OF GETTING NUMBER OF LOGGED IN USER (ADMIN
// FUNCTIONALITY)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html");

		try {

			PrintWriter out = response.getWriter();

			// GETTING TOTAL NUMBER OF ACTIVE SESSIONS FROM LISTENER
			int noOfUsers = SessionCounter.getTotalActiveSessions();
			if (noOfUsers == 0) {
				out.print("<div align = 'center'><h3>Currently " + ((noOfUsers))
						+ " user(s) are logged in...</h3></div>");
			} else {
				out.print("<div align = 'center'><h3>Currently " + ((noOfUsers) - 1)
						+ " user(s) are logged in...</h3></div>");
			}
			out.print("<h4 align = 'right'><a href = adminPage> Go back </a><h4>");
			out.print("<h4 align = 'right'><a href = logout> Logout </a><h4>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
