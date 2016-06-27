package com.cybagenet.jsp.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.cybagenet.jsp.bean.CountBean;
import com.cybagenet.jsp.bean.UserBean;

/**
 * Servlet Filter implementation class LogFilter
 */

// FILTER TO SHOW LOGIN TIME OF VARIOUS USERS
@WebFilter("/logFilter")
public class LogFilter implements Filter {

	static int hitCount = 0;
	UserBean user = new UserBean();
	CountBean countBean = new CountBean();

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

		String userName = request.getParameter("userName");
		String ipAddress = request.getRemoteAddr();
		if (!(countBean.visitorCount(userName)))
			countBean.increaseHitCount();

		user.addUserLog(userName, ipAddress);

		// PASS REQUEST ALONG FILTER CHAIN
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
