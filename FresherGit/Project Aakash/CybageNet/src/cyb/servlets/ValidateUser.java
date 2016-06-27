package cyb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.connection.MyConnection;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ValidateUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("pass");
		Timestamp date = new Timestamp(new Date().getTime());
		MyConnection con = new MyConnection();

		Connection c = null;

		try {
			c = con.connect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement pst = null, pst2=null;

		String validateSql = "select user_password,role from users where user_name = ?";
		String userLogQuery = "insert into userlog values(?,?)";
		try {
			pst = c.prepareStatement(validateSql);
			pst2 = c.prepareStatement(userLogQuery);

			pst.setString(1, user);
			pst2.setString(1, user);
			pst2.setTimestamp(2, date);

			ResultSet rst = pst.executeQuery();
			int i  = pst2.executeUpdate();
			while (rst.next()) {
				String pass = rst.getString(1);
				String role = rst.getString(2);
				if (password.equals(pass)) {
					if(role.equals("a")){
						
					RequestDispatcher rd = request.getRequestDispatcher("AdminPage.html");
					rd.forward(request, response);
					}
					
				 else {
					RequestDispatcher rd = request.getRequestDispatcher("UserPage.html");
					rd.forward(request, response);

				}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
