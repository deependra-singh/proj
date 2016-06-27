package com.cybagenet.servlet.servlets;

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

import com.cybagenet.servlet.connection.MyConnection;
import com.cybagenet.servlet.dao.BookDAO;

/**
 * Servlet implementation class Remove
 */

// SERVLET TO SERVE REQUEST OF REMOVING BOOK FROM DATABASE (ADMIN FUNCTIONALITY)
@WebServlet("/remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Remove() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = null;

		option = request.getParameter("book");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// CHECKING IF A BOOK IS CHOSEN AND THEN REMOVING THE SAME FROM DATABASE
		// BY CALLING A METHOD
		if (option != null) {
			if (!(book.removeBook(option))) {

				out.println("<div align = 'center'>" + option + " is removed from database");

				out.println("<br>Wait until you are redirected to your home page..</div>");

				response.setHeader("Refresh", "2;adminPage");
			}
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
