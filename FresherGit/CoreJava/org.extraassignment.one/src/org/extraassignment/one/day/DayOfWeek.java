package org.extraassignment.one.day;

public class DayOfWeek {

	public enum day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	//METHOD TO FIND DAY
	public day findDay(int dayNo) {
		System.out.println("DAY IS: "+day.values()[dayNo-1]);
		return day.values()[dayNo];
	}

}
