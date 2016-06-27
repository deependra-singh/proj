package org.extraassignment.one.uitility;

import java.util.Scanner;

import org.extraassignment.one.day.DayOfWeek;

public class Utility {

	public static void main(String[] args) {
		int dayNo;
		DayOfWeek dow = new DayOfWeek();
		try {
			Scanner scanner = new Scanner(System.in);
			
			//ACEPTING CHOICE OF DAY NUMBER
			System.out
					.println("enter the day number starting from sunday as 1 ");
			dayNo = scanner.nextInt();
			dow.findDay(dayNo);
			scanner.close();
		} catch (Exception e) {
			System.out.println("please enter no between 1 to 7");
		}

	}

}
