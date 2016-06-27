package com.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Config extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig cfg;
	
	Enumeration<String> names;
  
	@Override
	public void init() throws ServletException {
		 
		 cfg = getServletConfig();
		 names = cfg.getInitParameterNames();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(cfg.getInitParameter("Url"));
		System.out.println(cfg.getInitParameter("abc"));
		while(names.hasMoreElements())
		{	
			System.out.println(cfg.getInitParameter(names.nextElement()));
		}
		response.getWriter().append("Served at: ").append(request.getContextPath()+" "+cfg.getInitParameter("Url"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
