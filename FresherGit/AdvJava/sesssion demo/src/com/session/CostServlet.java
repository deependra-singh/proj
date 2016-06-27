package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CostServlet
 */
@WebServlet("/cost")
public class CostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String[] menu = request.getParameterValues("game");
		String uname = (String)request.getSession().getAttribute("uname");
		PrintWriter out = response.getWriter();
		out.print("<h3>welcome<h3>" + uname);
		out.println("Selected game are =");
		int cost=0;
		for(int i = 0;i<menu.length;i++)
		{
		String[] value=menu[i].split("_");
		cost = cost +Integer.parseInt(value[1]);
		out.println(value[0]+"<br><br>");
		}
		out.print("Total cost ="+cost);
		out.println("<a href='logout'> Logout </a>");
	}

}
