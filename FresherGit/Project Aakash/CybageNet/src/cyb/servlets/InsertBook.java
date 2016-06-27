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
 * Servlet implementation class InsertBook
 */
@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		
		
		try {
			PreparedStatement pst = null;
			String insertQuery = "insert into book_details values(?,?,?)";
			pst = c.prepareStatement(insertQuery);

			
			pst.setInt(1, id);
			pst.setString(2, title);
			pst.setString(3, "");
			int i = pst.executeUpdate();
			response.getWriter().append("Book added successfully! ");
		
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
