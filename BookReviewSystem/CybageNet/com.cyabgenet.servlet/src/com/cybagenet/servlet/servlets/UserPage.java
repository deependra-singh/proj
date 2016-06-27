package com.cybagenet.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminPage
 */

// SERVLET TO SERVE REQUEST OF DISPLAYING USER PAGE (ADMIN FUNCTIONALITY)
@WebServlet("/userPage")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			ServletContext context = request.getSession().getServletContext();

			int hitCount = (int) context.getAttribute("hitCount");

			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			out.print("<div align = 'center'><form action='searchBook' method='get'>" + "<br>" + "<br>" + "<br>"
					+ "<div align='center'>"
					+ "<h3 align='center'>To search books, get details of book and add review for a book... Please enter book name:</h3>"
					+ "<input type='text' name='bookName'>" + "&nbsp;&nbsp;<input type='submit' value='Search'>"
					+ "</div>" + "</form></div>" + "<br>" + "<br>" + "<p align='right'>" + "<font color = 'green'>"
					+ "SITE HIT COUNT: </font>" + "<font color = 'blue'>" + hitCount + "</font>" + "</p>" + "<br>"
					+ "<br>" + "<h3 align='right'><a href=logout>Logout</a></h3>");
			// response.sendRedirect("adminPage.html");

		} catch (Exception e) {
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
