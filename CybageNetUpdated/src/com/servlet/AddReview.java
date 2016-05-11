package com.servlet;

import java.io.IOException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		try {
		
			HttpSession hs = request.getSession();
			String bookName=(String) hs.getAttribute("bookname");
			
			ResultSet rs = book.getOldBookReview(bookName);
			while(rs.next())
			{
				oldReview = rs.getString(1);
			}
			
			if(oldReview.equals(null))
			 	newReview = request.getParameter("review");
			else
				newReview = oldReview.concat(",").concat(request.getParameter("review"));
		
		book.setNewBookReview(newReview, bookName);
		
		response.sendRedirect("userPage");
		
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
