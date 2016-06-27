package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String pass = request.getParameter("pass");
		HttpSession hs = request.getSession();
		hs.setAttribute("uname", uname);
		out.print("<h3>welcome<h3>" + uname);
		if(uname.equals("aakash") && pass.equals("12345"))
		{
			out.print("<form method='post' action='cost'>");
			out.print("<input type='checkbox' name='game' value='hockey_100'>hockey<br><br>");
			out.print("<input type='checkbox' name='game' value='cricket_200'>cricket<br><br>");
			out.print("<input type='checkbox' name='game' value='football_300'>football<br><br>");
			out.print("<input type='submit' name='submit' value='submit'>");
		}
			
			
	}

}
