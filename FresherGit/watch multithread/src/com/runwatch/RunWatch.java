package com.runwatch;

import java.util.Scanner;

import com.functions.DayThread;
import com.functions.HourThread;
import com.functions.MiliSecondThread;
import com.functions.MinuteThread;
import com.functions.MonthThread;
import com.functions.SecondThread;
import com.watch.Watch;

public class RunWatch {

	public static void main(String[] args) throws InterruptedException {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter sec =");
		int secv = sc.nextInt();
		
		System.out.println("Enter min =");
		int  minv = sc.nextInt();
		
		System.out.println("Enter hr =");
		int hrv = sc.nextInt();
		
		System.out.println("Enter day =");
		int dayv = sc.nextInt();
		
		System.out.println("Enter mon =");
		String monv = sc.next();
		
		System.out.println("Enter year =");
		int yeav = sc.nextInt();
		
		
		
		MonthThread mon = new MonthThread(yeav, monv);
		DayThread day = new DayThread("day",mon,dayv);
		HourThread hr = new HourThread("hour",day,hrv);
		MinuteThread min = new MinuteThread("min",hr,minv);
		SecondThread sec = new SecondThread("second",min,secv);
		MiliSecondThread msec = new MiliSecondThread(sec);
		
		Watch th = new Watch(msec,sec, min, hr, day, mon);
		

	}

}
