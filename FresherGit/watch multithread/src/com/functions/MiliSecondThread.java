package com.functions;

public class MiliSecondThread implements Runnable {

	private Thread th;
	private int miliSec;
	private SecondThread sth;
	
	public MiliSecondThread( SecondThread sth)
	{
		
		th = new Thread(this,"milisec");
		miliSec = 0;
		this.sth = sth;
		th.start();
	}
	
	

	public int getMiliSec() {
		return miliSec;
	}



	@Override
	public void run()
	{
		while(true)
		{
		if(miliSec == 99)
		{
			miliSec = 0;
			sth.setSec(sth.getSec()+1);
		}
		else
		{
			miliSec = miliSec + 1;
			try
			{
				th.sleep(10);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		}

	}

}
