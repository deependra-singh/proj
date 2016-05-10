package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.MyConnection;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		response.setContentType("text/html");
		
		Connection con;
		
		try {
			con = MyConnection.connect();
			PrintWriter out = response.getWriter();
			
		String bookName=request.getParameter("bookName");
		String bookAuthor=request.getParameter("bookAuthor");
		String bookPublisher=request.getParameter("bookPublisher");
		
		PreparedStatement pst=con.prepareStatement("insert into Books(name,author,publisher) values(?,?,?)");
		pst.setString(1,bookName);
		pst.setString(2,bookAuthor);
		pst.setString(3,bookPublisher);
		pst.execute();
		
		out.println(bookName +" added successfully");
		out.println("<br><br> Wait until you are redirected to your home page..") ;
		response.setHeader("Refresh", "5;adminPage");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
