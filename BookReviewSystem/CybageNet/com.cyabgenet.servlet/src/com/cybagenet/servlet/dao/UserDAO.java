package com.cybagenet.servlet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cybagenet.servlet.connection.MyConnection;

public class UserDAO {

	// CREATING REFRENCES
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	String pwd;
	String result;
	CallableStatement cstmt;

	// METHOD TO AUTHENTICATE USER
	public String validateUser(String name, String pass) {
		try {

			con = MyConnection.connect();
			if (con != null) {
				query = "select user_password from users where user_name = ?";
				pst = con.prepareStatement(query);
				pst.setString(1, name);
				rs = pst.executeQuery();

				while (rs.next()) {
					pwd = rs.getString(1);
				}

				if (pwd != null && pwd.equals(pass))
					result = "valid";
				else
					result = "invalid";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			result = "invalid";
		}

		return result;
	}

	// METHOD TO LOG USER VISITING SITE
	public void addUserLog(String name, String ipAddress) {
		try {

			con = MyConnection.connect();
			if (con != null) {
				query = "{call addUserLog (?, ?)}";
				cstmt = con.prepareCall(query);
				cstmt.setString(1, name);
				cstmt.setString(2, ipAddress);
				cstmt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METHOD TO GET LOGIN NAME FROM USER LOG TO CHECK UNIQUENESS OF VISITOR FOR
	// VISIT COUNT
	public ResultSet getUserLog() {
		try {
			con = MyConnection.connect();
			if (con != null) {
				query = "select userlog_loginname from userlog";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

}
