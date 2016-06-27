package cyb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cyb.connection.MyConnection;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
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
		MyConnection con = new MyConnection();

		Connection c = null;

		try {
			c = con.connect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		
		PreparedStatement pst = null;
		
		String searchQuery = "select * from book_details where book_title like ?";
		
		
		try {
			pst=c.prepareStatement(searchQuery);
			pst.setString(1, "%"+title+"%");
			
			ResultSet rst= pst.executeQuery();
			while(rst.next()){
				System.out.println("book details: "+rst.getInt(1)+" " + rst.getString(2)+" " +rst.getString(3));
				response.getWriter().append("book details:").append(+rst.getInt(1)+" " + rst.getString(2)+" " +rst.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
