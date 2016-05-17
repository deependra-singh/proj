package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.dao.BookDAO;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/searchBook")
public class searchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();
	ArrayList<String> bookNames = new ArrayList<>();
	ResultSet rst;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		request.getSession();
		response.setContentType("text/html");
		try {

			PrintWriter out = response.getWriter();

			request.getSession();
			System.out.println(request.getParameter("bookName"));

			if ((request.getParameter("bookName")) != "") {
				if ((request.getParameter("bookName")) != null) {
					String bookName = request.getParameter("bookName");

					rst = book.searchBook(bookName);

					if (rst.next()) {
						out.println("<h2>Books found as per your search :</h2>");
						out.println("<br><br><form action = 'getReview' method = 'post'>");
						while (rst.next()) {
							out.println("<br><input type = 'radio' name = 'book' value = '" + rst.getString(1) + "'>"
									+ rst.getString(1));
						}
						
						out.print("<br><br><br><br><input type = 'submit' name = 'op' value = 'Get Details'/>");
						out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type = 'submit' name = 'op' value = 'Add Review'/>");
						out.println("</form>");

					} else {
						out.print("No books found modify your search");
						out.println("<br><br> Wait until you are redirected to your home page..");
						response.setHeader("Refresh", "3;userPage");
					}

				} else {
					response.sendRedirect("userPage");
				}
			} else {
				response.sendRedirect("userPage");
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * HttpSession session = request.getSession();
		 * 
		 * response.setContentType("text/html");
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * String bookName = request.getParameter("bookName");
		 * 
		 * rst = book.searchBook(bookName);
		 * 
		 * { out.println("<br>" + itr.next()); }
		 * 
		 * out.println(
		 * "<br><br><br> <form action = 'getReview' method = 'post'>");
		 * out.print("<input type = 'text' name = 'bookName'/> &nbsp;"); if
		 * (session.getAttribute("user").equals("admin")) { out.println(
		 * "<input type = 'submit' name = 'op' value = 'Remove Book'/>"); } else
		 * { out.println(
		 * "<input type = 'submit' name = 'op' value = 'Get Details'/>");
		 * out.println(
		 * "<input type = 'submit' name = 'op' value = 'Add Review'/>"); }
		 * out.println("</form>");
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
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
