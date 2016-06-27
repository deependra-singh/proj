package cyb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterImplementation
 */
@WebFilter("/filterImplementation")
public class FilterImplementation implements Filter {

    /**
     * Default constructor. 
     */
    public FilterImplementation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	/*filter is mapped with corresponding servlet in web.xml file and its doFilter method is called
	 * the request parameters are fetched and checked and then sent to validateuser servlet.
	 * 
	 * */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		if(request.getParameter("username").equals("ria") && request.getParameter("password").equals("123"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ValidateUser");
			rd.forward(request, response);
		}else
		{
			PrintWriter out = response.getWriter();
			out.println("Sorry, invalid username or password.");
		}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
