package com.cybagenet.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybagenet.servlet.dao.BookDAO;

/**
 * Servlet implementation class AddBook
 */

// SERVLET TO SERVE REQUEST OF ADDING BOOK TO DATABASE (ADMIN FUNCTIONALITY)
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO book = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html");

		try {
			PrintWriter out = response.getWriter();

			// GETTING BOOK NAME, BOOK AUTHOR, BOOK PUBLISHER FROM REQUEST
			String bookName = request.getParameter("bookName");
			String bookAuthor = request.getParameter("bookAuthor");
			String bookPublisher = request.getParameter("bookPublisher");
			
			String checkStatus = book.addBook(bookName, bookAuthor, bookPublisher);
			

			if (checkStatus.equals("added")) {
				out.println("<div align = 'center'><b>" 
							+ bookName +
							" added successfully</b>"
							+ "<br>Wait until you are redirected to your home page</div>");
				response.setHeader("Refresh", "2;adminPage");
			}
			else if(checkStatus.equals("exist")){
				out.println("<div align = 'center'><b>" 
						+ bookName +
						" already exists. Please enter new book</b>"
						+ "<br>Wait until you are redirected to the addbook page</div>");
				response.setHeader("Refresh", "2;addBook.html");
			}
			else {
				out.println("<div align = 'center'><b>" +
						" something wrong</b>"
						+ "<br>Wait until you are redirected to your home page</div>");
				response.setHeader("Refresh", "2;addBook.html");
			}

		} catch (IOException e) {
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
