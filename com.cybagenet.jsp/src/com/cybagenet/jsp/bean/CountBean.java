package com.cybagenet.jsp.bean;

import java.util.*;

public class CountBean {

	public static int hitCount = 0;

	// CREATING OBJECTS
	UserBean user = new UserBean();
	List<String> list = new LinkedList<>();

	// METHOD TO ADD CURRENTLY LOGGED IN USER TO LIST
	public void addUser(String uname) {
		System.out.println(" in add");
		list.add(uname);
	}

	// METHOD TO REMOVE LOGGED OUT USER FROM LIST
	public void removeUser(String uname) {
		System.out.println(" in delete");
		list.remove(uname);
	}

	// METHOD TO GET NUMBER OF LOGGED IN USER
	public int userCount() {
		return list.size();
	}

	// METHOD TO GET UNIQUE VISITOR LOG
	public boolean visitorCount(String uname) {
		System.out.println(uname);
		System.out.println(user.checkUserLog(uname));
		return user.checkUserLog(uname);
	}

	// METHOD TO INCREASE UNIQUE VISIT COUNT
	public void increaseHitCount() {
		hitCount++;
	}

}
