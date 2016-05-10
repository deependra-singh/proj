package com.listeners;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounter implements HttpSessionListener {

	int userCounter = 0;
	public static final String COUNTER = "session-counter";
	
    /**
     * Default constructor. 
     */
    public SessionCounter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		
		HttpSession hs = event.getSession();
    	userCounter++;
    	hs.setAttribute(SessionCounter.COUNTER, this);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
        
   	HttpSession hs = event.getSession();
   	userCounter--;
   	hs.setAttribute(SessionCounter.COUNTER, this);
		
	}
	
	public int getActiveSessionNumber()
	{
		return userCounter;
	}

	
}
