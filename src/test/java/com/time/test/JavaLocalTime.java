package com.time.test;

import java.time.LocalTime;

import org.junit.Test;

public class JavaLocalTime {

	@Test
	public void test0001() {
		LocalTime localTime = LocalTime.of(9, 30);
		System.out.println(localTime.toString());
		
		LocalTime localTime2 = LocalTime.now();
		System.out.println(localTime2.toString());
	}
	
	@Test
	public void test0002() {
		LocalTime localTime = LocalTime.of(22, 30);
		LocalTime localTime2 = LocalTime.of(20, 30);
		
		int compareTo = localTime.compareTo(localTime2);
		System.out.println(compareTo);
		
		boolean equals = localTime.equals(localTime2);
		System.out.println(equals);
		
		boolean after = localTime.isAfter(localTime2);
		System.out.println(after);
		
		boolean before = localTime.isBefore(localTime2);
		System.out.println(before);
	}
	
	@Test
	public void test0003() {
		LocalTime localTime = LocalTime.of(22, 30);
		
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
	}
	
	@Test
	public void test0004() {
		LocalTime localTime = LocalTime.of(22, 30);
		LocalTime plusHours = localTime.plusHours(1);
		System.out.println(plusHours);
	}
	
}
