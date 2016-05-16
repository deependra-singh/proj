package com.cybagenet.jsp.bean;

import java.util.*;

public class CountBean {
	
	public static int hitCount = 1;
	
	UserBean user = new UserBean();
	List<String> list = new LinkedList<>();
	
	public void addUser(String uname){
		System.out.println(" in add");
		list.add(uname);
	}
	
	public void removeUser(String uname){
		System.out.println(" in delete");
		list.remove(uname);
	}
	
	public int userCount(){
		return list.size();
	}
	
	public boolean visitorCount(String uname){
		System.out.println(uname);
		System.out.println(user.checkUserLog(uname));
		return user.checkUserLog(uname);
	}
	
	public void increaseHitCount(){
		hitCount++;
	}

}
