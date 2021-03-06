package cyb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserClick")
public class UserClick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserClick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String option = request.getParameter("option");
		
		if(option.equals("SearchBook"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("SearchBook.html");
			rd.forward(request, response);
		}
		else if(option.equals("ShowDetails"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ShowDetails.html");
			rd.forward(request, response);
		}
		else if(option.equals("AddReview"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("AddReview.html");
			rd.forward(request, response);
		}
		
	}

}
