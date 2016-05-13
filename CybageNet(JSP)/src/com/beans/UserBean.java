package com.beans;

import com.dao.UserDAO;

public class UserBean {
	
	private String userType;
	private String userName;
	private String pass;
	private UserDAO user = new UserDAO();
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String authenticateUser()
	{
		return user.validateUser(userName, pass);
	}

}
