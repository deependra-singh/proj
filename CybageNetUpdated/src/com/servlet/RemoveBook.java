package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/removeBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();
	ResultSet rst;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		Connection con;
		HttpSession session = request.getSession();

		try {

			PrintWriter out = response.getWriter();
			HttpSession hs = request.getSession();
			String bookName = request.getParameter("bookName");

			rst = book.searchBook(bookName);

			out.println("<br><br><br> <form action = 'remove' method = 'post'>");
			while (rst.next()) {
				out.println("<br><input type = 'radio' name = 'book' value = '" + rst.getString(2)+ "'>" + rst.getString(2));
			}

			out.println("<input type = 'submit' name = 'op' value = 'Remove Book'/>");
			out.println("</form>");

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
