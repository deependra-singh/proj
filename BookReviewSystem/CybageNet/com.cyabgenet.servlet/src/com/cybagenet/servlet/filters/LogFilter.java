package com.cybagenet.servlet.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;

import com.cybagenet.servlet.dao.UserDAO;
import com.cybagenet.servlet.helper.*;

/**
 * Servlet Filter implementation class LogFilter
 */

// FILTER TO SHOW LOGIN TIME OF VARIOUS USERS
@WebFilter("/logFilter")
public class LogFilter implements Filter {

	static int hitCount = 0;
	UserDAO user = new UserDAO();

	/**
	 * Default constructor.
	 */
	public LogFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String userName = request.getParameter("username");
		String ipAddress = request.getRemoteAddr();

		GetHitCount count = new GetHitCount();

		if (!count.getCount(userName)) {
			hitCount++;
			request.setAttribute("hitCount", hitCount);
		}

		else {
			request.setAttribute("hitCount", hitCount);
		}

		user.addUserLog(userName, ipAddress);

		// PASS THE REQUEST ALONG THE FILTER CHAIN
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
