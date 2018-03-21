package com.time.test;

import java.util.Calendar;

import org.joda.time.LocalTime;
import org.junit.Test;

public class JodaLocalTime {

	@Test
	public void test0001() {
		LocalTime localTime = LocalTime.fromCalendarFields(Calendar.getInstance());
		System.out.println(localTime.toString());
		
		LocalTime localTime2 = new LocalTime();
		System.out.println(localTime2.toString());
		
		LocalTime localTime3 = new LocalTime(9, 30, 30);
		System.out.println(localTime3.toString());
		
		LocalTime localTime4 = LocalTime.now();
		System.out.println(localTime4.toString());
	}
	
}
