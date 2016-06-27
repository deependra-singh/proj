package com.way;

import java.awt.Color;

import javax.swing.JFrame;

import com.signal.Signal;

public class Way extends JFrame implements Runnable {

	private Thread th;
	private Signal sig;
	private int way;
	
	public Way(int i,Signal s)
	{
		super("WAY "+(i+1));
		th = new Thread(this,way +" "+(i+1));
		sig = s;
		way = i;
		th.start();
		setSize(150, 180);
		System.out.println("in ctor");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void run()
	{
		System.out.println("in run");
		
		while(true)
		{
			
		if(sig.getOrange().get(way))
		{
			getContentPane().setBackground(Color.ORANGE);
			
		}
		else if(sig.getGreen().get(way))
		{
			getContentPane().setBackground(Color.GREEN);
			
		}
		else
		{
			getContentPane().setBackground(Color.RED);
			
		}
		
		}

	}

}
