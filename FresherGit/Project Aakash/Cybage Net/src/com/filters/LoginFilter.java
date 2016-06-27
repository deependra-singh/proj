package com.filters;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.utility.Utility;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private Connection con;
	private Utility utill;
	private PreparedStatement pst;
	private HttpSession session;
	private LoginDao logDao;
	
	public void init(FilterConfig fConfig) throws ServletException
	{
		try 
		{
			logDao = new LoginDao();
			System.out.println("connection");
		} 
		catch (Exception e)
		{
			System.out.println("connection faild");
			e.printStackTrace();
		}
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String type = request.getParameter("type");
		
		try(PrintWriter log = new PrintWriter(new FileOutputStream("D://userlog.txt",true));)
		{
			String result = logDao.checkUserCredintials(username, password, type);
		
			if(result.contains("s"))
			{
				System.out.println("login");
				
				log.write(username+"     ");
				log.println(new Date()+"    ");
				
				request.setAttribute("uname",username);
				request.setAttribute("type",type);
				request.setAttribute("con",con);
				request.setAttribute("status",result);
				
				RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
				rd.forward(request, response);
			}
			else
			{	
				System.out.println("failed");
				request.setAttribute("status",result);
				RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
				rd.forward(request, response);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	

}
