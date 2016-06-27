package com.functions;

public class DayThread implements Runnable {

	private Thread th;
	private int day;
	private MonthThread mon;
	
	public DayThread(String name,MonthThread mon,int day)
	{
		this.day = day;
		this.mon = mon;
		th = new Thread(this,name);
		th.start();
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public void run()
	{
		
		while(true)
		{
		switch (mon.getMon()) {
		case "jan":
			if(day == 32)
			{	
				mon.setMon("feb");
				day =1;
			}
			break;
			
		case "feb":
			if(day == 30)
			{
				mon.setMon("mar");
				day =1;
			}
			break;
			
		case "mar":
			if(day == 32)
			{
				mon.setMon("apr");
				day =1;
			}
			break;
			
		case "apr":
			if(day == 31)
			{
				mon.setMon("may");
			 	day =1;
			}
			break;
			
		case "may":
			if(day == 32)
			{
				day =1;
				mon.setMon("jun");
			}
			
		case "jun":
			if(day == 31)
			{
				day =1;
				mon.setMon("jul");
			}
			break;
			
		case "jul":
			if(day == 32)
			{
				day =1;
				mon.setMon("aug");
			}
			break;
			
		case "aug":
			if(day == 32)
			{
				day =1;
				mon.setMon("sep");
			}
			break;
			
		case "sep":
			if(day == 31)
			{
				day =1;
				mon.setMon("oct");
			}
			break;
			
		case "oct":
			if(day == 32)
			{
				day =1;
				mon.setMon("nov");
			}
			break;
			
		case "nov":
			if(day == 31)
			{
				mon.setMon("dec");
				day =1;
			}
			break;
			
		case "dec":
			if(day == 32)
			{
				mon.setMon("jan");
				mon.setYear(mon.getYear()+1);
				day =1;
			}
			break;

		}
		

		try {
			th.sleep(1);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		}
	}

}
