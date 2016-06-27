package com.functions;

public class MonthThread  {

	
	private String mon;
	private int year;
	
	
	
	public MonthThread(int year,String mon)
	{
		this.year = year;
		this.mon = mon;
		
		
	}
	
	public String getMon() {
		return mon;
	}
	
	public void setMon(String mon) {
		this.mon = mon;
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

}
