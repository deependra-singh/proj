package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.utility.Utility;

public class AdminDao {

	private Connection con;
	private PreparedStatement pst;
	private Utility utill;
	
	public AdminDao() throws Exception 
	{
		utill=new Utility("jdbc:mysql://localhost/training","com.mysql.jdbc.Driver","root","root");
		con = utill.getConnection();
		pst = con.prepareStatement("select * from accounts where user_name=? and user_pass=? and user_type=?");
	}
	
}
