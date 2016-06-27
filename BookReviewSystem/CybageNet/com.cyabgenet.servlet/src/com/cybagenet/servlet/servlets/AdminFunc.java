package com.cybagenet.servlet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminFunc
 */

// SERVLET TO SERVE REQUEST OF ADMIN FUNCTIONALITY
@WebServlet("/adminFunc")
public class AdminFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("op");

		// REDIRECTING ADMIN BASED ON FUNCTIONALITY CHOSEN BY HIM
		if (option.equalsIgnoreCase("add book"))
			response.sendRedirect("addBook.html");
		else if (option.equalsIgnoreCase("removeBook"))
			response.sendRedirect("removeBook");
		else
			response.sendRedirect("checkUser.html");
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
