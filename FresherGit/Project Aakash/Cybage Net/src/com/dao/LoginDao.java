package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.Utility;

public class LoginDao{

	private Connection con;
	private PreparedStatement pst;
	private Utility utill;
	
	public LoginDao() throws Exception {
		utill=new Utility("jdbc:mysql://localhost/training","com.mysql.jdbc.Driver","root","root");
		con = utill.getConnection();
		pst = con.prepareStatement("select * from accounts where user_name=? and user_pass=? and user_type=?");
	}
	
	public String checkUserCredintials(String username,String password,String type) throws SQLException
	{
		System.out.println("methode");
		pst.setString(1, username);
		pst.setString(2, password);
		pst.setString(3, type);
		ResultSet rst = pst.executeQuery();
		if(rst!=null)
		{
			return "succes";
		}
		return "failed";
	}
	
}
