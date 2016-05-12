package com.servlet;

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

import com.connection.MyConnection;
import com.dao.BookDAO;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/getReview")
public class GetReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReview() {
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

					out.print("<h3>Book details of ");
					while (rst.next()) {
						out.print(rst.getString(1));
						out.print(" are </h3><br><br>");
						out.print("Author: " + rst.getString(2));
						out.print("<br><br> Publisher: " + rst.getString(3));
						out.print("<br><br> Reviews:");
						if (rst.getString(4) != null) {
							String allReviews = rst.getString(4);
							String[] strArr = allReviews.split(",");
							for (int i = 0; i < strArr.length; i++) {
								out.println("<br>" + (i + 1) + " :- " + strArr[i]);
							}
						} else {
							out.print("<br>No reviews...");
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
