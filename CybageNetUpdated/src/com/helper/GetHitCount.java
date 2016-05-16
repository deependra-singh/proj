package com.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class GetHitCount {
	public boolean getCount(String name)
	{
		
	UserDAO user=new UserDAO();
	ResultSet rs=user.getUserLog();

	try {
		while(rs.next())
		{
			if(rs.getString(1).equals(name))
					return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
	}
}
