package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utility.Utility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> count;
	private Connection con;
	private HttpSession session;

    public LoginServlet() throws Exception 
    {
    	count = new ArrayList<>();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String status = (String)request.getAttribute("status");
		if(status.contains("f"))
		{
			pw.println("Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
			rd.include(request, response);
		}
		else
		{
		String username = request.getParameter("uname");
		con =(Connection)request.getAttribute("con");
		String type = request.getParameter("type");
		
		session=request.getSession();
				if(type.equals("A"))
				{	
					pw.println("Welcome "+username+"<br>");
					pw.print("Count of online users are:"+count.size());
					RequestDispatcher rd = request.getRequestDispatcher("admin.html");
					rd.include(request, response);
				}
				else
				{
					count.add(type);
					session.setAttribute("count", count);
					pw.println("Welcome "+username);
					RequestDispatcher rd = request.getRequestDispatcher("user.html");
					rd.include(request, response);
				}
				session.setAttribute("count", count);
				session.setAttribute("uname",username);
				session.setAttribute("con",con);
					
			}
			
		
	}
}

