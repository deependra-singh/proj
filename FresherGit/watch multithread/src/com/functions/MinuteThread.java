package com.functions;

public class MinuteThread implements Runnable {

	private Thread th;
	private int min;
	private HourThread hth;
	
	public MinuteThread(String name,HourThread hth,int min)
	{
		this.min = min;
		th = new Thread(this,name);
		th.start();
		this.hth = hth;
	}

	
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min=min;
	}



	@Override
	public void run() {
		System.out.println("in run min");
		while(true)
		{
			
			if(min == 60)
			{
				min = 0;
				hth.setHr(hth.getHr()+1);
			}
			try {
				th.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}
