package cyb.servlet;
/**
 * @author Deependra Singh
 * @purpose Create a simple servlet demo to display a servlet's lifecycle.
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */

@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SimpleServlet() {
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("in servlet's init");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext sctx = getServletConfig().getServletContext();
		PrintWriter out = response.getWriter();
		
		Enumeration<String> en = sctx.getInitParameterNames();
		while(en.hasMoreElements())
		{
			String s = sctx.getInitParameter(en.nextElement());
			out.println(s);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.gc();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		super.service(arg0, arg1);
		System.out.println("in servlet's service");
		System.gc();
	}

	@Override
	public void destroy() {

		super.destroy();
		System.out.println("in servlet's destroy");
	}

}
