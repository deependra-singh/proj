package com.watch;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.functions.DayThread;
import com.functions.HourThread;
import com.functions.MiliSecondThread;
import com.functions.MinuteThread;
import com.functions.MonthThread;
import com.functions.SecondThread;

public class Watch extends JFrame implements Runnable {

	private MiliSecondThread miliTh;
	private SecondThread sTh;
	private MinuteThread mTh;
	private HourThread hTh;
	private DayThread dTh;
	private MonthThread monTh;
	private Thread th;
	private TextArea ta;
	private JTextField tf;
	
	public Watch(MiliSecondThread miliTh, SecondThread sTh, MinuteThread mTh, HourThread hTh,
			DayThread dTh, MonthThread monTh) throws HeadlessException {
		super();
		th= new Thread(this,"watch");
		this.miliTh = miliTh; 
		this.sTh = sTh;
		this.mTh = mTh;
		this.hTh = hTh;
		this.dTh = dTh;
		this.monTh = monTh;
		setBounds(500, 300,460,150);
		setVisible(true);
		ta = new TextArea(1, 30);
		ta.setFont(new Font("SansSerif", Font.BOLD,40));
		add(ta);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		th.start();
	}



	@Override
	public void run() {
		while(true)
		{
		//ta.append();
		ta.setText("  "+dTh.getDay()+" : "+monTh.getMon()+" : "+monTh.getYear()+" || "+hTh.getHr()+" : "+mTh.getMin()+" : "+sTh.getSec()+" : "+miliTh.getMiliSec());
		}
	}

}
