package com.cybagenet.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybagenet.servlet.connection.MyConnection;
import com.cybagenet.servlet.dao.BookDAO;

/**
 * Servlet implementation class AddBook
 */

// SERVLET TO SERVE REQUEST OF ADDING BOOK REVIEW TO DATABASE (USER
// FUNTIONALITY)
@WebServlet("/addReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();

	String newReview;
	String oldReview;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			// RETRIEVING BOOK NAME FROM SESSION
			HttpSession hs = request.getSession();
			String bookName = (String) hs.getAttribute("bookname");

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			ResultSet rs = book.getOldBookReview(bookName);
			while (rs.next()) {
				oldReview = rs.getString(1);
			}

			if (oldReview == null)
				newReview = request.getParameter("review");
			else

				newReview = oldReview.concat(",").concat(request.getParameter("review"));

			out.println("<div align = 'center'><b>Review added successfully</b>");
			out.println("<br><br> Wait until you are redirected to your home page..</div>");
			book.setNewBookReview(newReview, bookName);

			response.setHeader("Refresh", "3;userPage");

		} catch (Exception e) {
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
