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

// SERVLET TO SERVE REQUEST OF DISPLAYING DETAILS OF CHOSEN BOOK (USER
// FUNTIONALTY)
@WebServlet("/getReview")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;

		if (request.getParameter("book") != null) {
			try {

				out = response.getWriter();
				String bookName = request.getParameter("book");

				HttpSession hs = request.getSession();
				hs.setAttribute("bookname", bookName);

				String option = request.getParameter("op");
				switch (option) {
				case "Get Details":

					ResultSet rst = book.getBookDetails(bookName);

					out.print("<h3>Book details of &nbsp;");
					while (rst.next()) {
						out.print("<font color='blue'>" + rst.getString(1) + "</font>");
						out.print(" are </h3><br>");
						out.print("<b>Author: </b>" + rst.getString(2));
						out.print("<br><b>Publisher:</b> " + rst.getString(3));
						out.print("<br><br><b>Reviews:</b>");
						if (rst.getString(4) != null) {
							String allReviews = rst.getString(4);
							String[] strArr = allReviews.split(",");
							for (int i = 0; i < strArr.length; i++) {
								out.println("<br>" + (i + 1) + " :- " + strArr[i]);
							}
						} else {
							out.print("<div align = 'center'><br>No reviews...</div>");
						}
						out.println("<div align='right'>" + "<a href='userPage'>Go Back</a>" + "</div>");
					}
					break;

				case "Add Review":
					response.sendRedirect("addReview.html");
					break;

				default:
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				out = response.getWriter();
				out.println("Plzz select the option");
				out.println("<br><br> Wait until you are redirected to your home page..");
				response.setHeader("Refresh", "2;searchBook");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
