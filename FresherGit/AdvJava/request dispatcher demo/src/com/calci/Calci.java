package com.calci;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calci
 */
@WebServlet("/Calci")
public class Calci extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Calci() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generate0d method stub
		
		PrintWriter out = response.getWriter();
		response.sendRedirect("ContextDemo");
		
		float num1 = Integer.parseInt(request.getParameter("num1"));
		float num2 = Integer.parseInt(request.getParameter("num2"));
		float result = 0 ;
		String sym = request.getParameter("button");
		switch (sym) {
		case "+":
			result = num1 + num2;
			
			out.print(result);
			break;
		case "-":
			result = num1 - num2;
			
			break;
		case "/":
			result = num1 / num2;
			
			break;
		case "*":
			result = num1 * num2;
			
			break;
		
		}
		/*if(!sym.equals( null))
		{
			out.print(result);
			RequestDispatcher rqst = request.getRequestDispatcher("Calci");
			rqst.include(request, response);
		}*/
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
