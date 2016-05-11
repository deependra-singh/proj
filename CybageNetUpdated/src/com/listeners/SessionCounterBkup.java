package com.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterBkup implements HttpSessionListener {

	private static int userCounter = 0;

	/**
	 * Default constructor.
	 */
	public SessionCounterBkup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		userCounter++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		userCounter--;
	}

	public static int getActiveSessionNumber() {
		return userCounter;
	}

}
