package com.calci;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletSecurityElement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo
 */
@WebServlet("/ContextDemo")
public class ContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx ;
	
	Enumeration<String> names;
    /**
     * Default constructor. 
     */
    public ContextDemo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		 ctx = getServletContext();
		 names = ctx.getInitParameterNames();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(ctx.getInitParameter("Url"));
		while(names.hasMoreElements())
		{	
			System.out.println(ctx.getInitParameter(names.nextElement()));
		}
		response.getWriter().append("Served at: ").append(request.getContextPath()+" "+ctx.getInitParameter("Url"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
