package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		request.getSession();
		response.setContentType("text/html");
		try {

			PrintWriter out = response.getWriter();
			request.getSession();
			String bookName = request.getParameter("bookName");

			rst = book.searchBook(bookName);
			out.println("<h4><b>Books found as per your search for removal :</b></h4>");
			out.println("<br><br><form action = 'remove' method = 'post'>");
			while (rst.next()) {
				out.println("<br><input type = 'radio' name = 'book' required= 'required' value = '" + rst.getString(1) + "'>"
						+ rst.getString(1));
			}

			out.println("<br><input type = 'submit' name = 'op' value = 'Remove Book'/>");
			out.println("</form>");

		} catch (SQLException | IOException e) {
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
