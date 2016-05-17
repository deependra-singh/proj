package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.dao.UserDAO;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO user = new UserDAO();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

		
		String userType = request.getParameter("userType");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pass");

		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		/*Cookie[] cookie=request.getCookies();
		 if(cookie[0].getName().equals("count")) 
			 System.out.println("cookie value "+cookie[0].getValue());*/
		
		RequestDispatcher rd;
		try {

			PrintWriter out = response.getWriter();

			switch (userType) {
			case "admin":
				if (name.equals("admin") && pwd.equals("admin")) {

					rd = request.getRequestDispatcher("adminPage");
					rd.forward(request, response);
				} else {
					response.setContentType("text/html");
					out.print("Invalid password");
					rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
				}
				break;

			default:
			
				int hitCount;
				
				if(request.getAttribute("hitCount") != null)
					{
						hitCount =((Integer)request.getAttribute("hitCount"));
						
					}				
				else
				{
					hitCount = 1;
				}
				
			String result = user.validateUser(name, pwd);
				
				if (result.equals("valid")) {
					
				ServletContext context = request.getSession().getServletContext();
				context.setAttribute("hitCount", hitCount);

				rd = request.getRequestDispatcher("userPage");
					rd.forward(request, response);
					
				} else {
					response.setContentType("text/html");
					out.println("<p><font color='blue'>SITE HIT COUNT: " + hitCount + "</font></p><p><font color='red'>Invalid password</font></p><br>");
					rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
				}
				break;
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
