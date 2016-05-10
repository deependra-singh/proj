package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.MyConnection;

public class UserDAO {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	String pwd;
	String result;
	
	public String validateUser(String name, String pass)
	{
		try
		{
			con = MyConnection.connect();
			query = "select user_password from users where user_name = ?";
			pst = con.prepareStatement(query);
			pst.setString(1,name);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				pwd = rs.getString(1);
			}
			
			if(pwd.equals(pass))
			{
				result = "valid";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result = "invalid";
		}
		
		return result;
	}

}
