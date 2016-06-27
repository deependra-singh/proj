package com.cybagenet.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPage
 */

// SERVLET TO SERVE REQUEST DISPLAYING THE ADMIN FUNTIONALITY PAGE
@WebServlet("/adminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPage() {
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

			PrintWriter out = response.getWriter();

			out.println(
					"<h2 align='center' style='font: monospace; font-family: cursive; color: olive;'>ADMIN FUNCTIONALTIES</h2>");
			out.print("<form action='adminFunc' method='get'>" + "<br>" + "<br>" + "<br>" + "<center>"
					+ "<input type='submit' value='Add Book' name='op' formaction='addBook.html'>"
					+ "&nbsp;&nbsp;&nbsp;<input type='submit' value='Remove Book' name='op' formaction='removeBook.html'>"
					+ "&nbsp;&nbsp;&nbsp;<input type='submit' value='Check User Log' name='op' formaction='getValidUser'>"
					+ "</center>" + "</form>" + "<br>" + "<br>" + "<h3 align='right'><a href=logout>Logout</a></h3>");

		} catch (IOException e) {
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
