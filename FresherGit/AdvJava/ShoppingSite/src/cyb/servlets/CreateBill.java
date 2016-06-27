package cyb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateBill
 */
@WebServlet("/CreateBill")
public class CreateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBill() {
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
		response.setContentType("text/html");
		int total = 0 ;
		PrintWriter out = response.getWriter();
		if(request.getParameter("pen").equals("Pen"))
		{
			total = 100;
			out.print(total);
			
		}
		
		else if(request.getParameter("pen").equals("Pencil")){
			total = 50;
			out.print(total);
			
		}
		
		else if(request.getParameter("pen").equals("WaterBottle")){
			total = 150;
			out.print(total);
		}
		out.println("<form method='post' action='logout.jsp'>");
		out.println("<input type='submit' name='logout' value='LogOut'>");
		out.println("</form>");
		
		
		
	}

}
