package com.functions;

public class HourThread implements Runnable {
	
	private int hr ;
	private Thread th;
	private DayThread dth;
	
	public HourThread(String name,DayThread dth,int hr)
	{
		this.hr = hr;
		this.dth = dth;
		th = new Thread(this,name);
		th.start();
	}
	
	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	@Override
	public void run() {
		
		while(true)
		{
			if(hr == 24)
			{
				hr = 0;
				dth.setDay(dth.getDay()+1);
				
			}
			
			try
			{
				th.sleep(1);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
