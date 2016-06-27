package com.signal;

import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.SliderUI;

public class Signal extends Thread{

	private List<Boolean> green,orange;
	
	
	
	public Signal() {
		
		green = new LinkedList<Boolean>();
		green.add(false);
		green.add(false);
		green.add(false);
		green.add(false);
		//green.add(false);
		orange = new LinkedList<Boolean>();
		orange.add(false);
		orange.add(false);
		orange.add(false);
		orange.add(false);
		//orange.add(false);
		start();
	}



	public List<Boolean> getGreen() {
		return green;
	}



	public List<Boolean> getOrange() {
		return orange;
	}

	@Override
	public void run() 
	{
	for(int i = 0;i <green.size();i++)
	{
		
		try 
		{
			green.set(i, true);
			//System.out.println(green +" "+orange);
			sleep(6000);
			green.set(i, false);
			orange.set(i, true);
			//System.out.println(green +" "+orange);
			sleep(2000);
			orange.set(i, false);
			
			if(i==3)
				i = -1;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
	}
		
	}

}
