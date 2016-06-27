package com.functions;

public class SecondThread implements Runnable {

	private Thread th;
	private int sec;
	private MinuteThread min;
	
	public SecondThread(String name,MinuteThread min,int sec)
	{	
		this.sec = sec;
		this.min = min;
		th = new Thread(this,name);
		th.start();
	}
		
	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	@Override
	public void run() {
		while(true)
		{
			
			try
			{
				if(sec == 60)
				{
					sec = 0;
					min.setMin(min.getMin()+1);
				}
				/*else
				{
					sec=sec+1;
				}*/
				th.sleep(1);
				
			} 
			catch (InterruptedException e)
			{
				//e.printStackTrace();
			}
			
		}

	}

}
