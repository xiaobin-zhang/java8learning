package com.time.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class JavaLocalDate {

	@Test
	public void test0001() {
		LocalDate localDate1 = LocalDate.of(2017, 10, 23);
		System.out.println(localDate1.toString());
		LocalDate localDate2 = LocalDate.now();
		System.out.println(localDate2.toString());
		LocalDate localDate3 = LocalDate.of(2017, Month.OCTOBER, 23);
		System.out.println(localDate3.toString());
	}
	
	@Test
	public void test0002() {
		LocalDate localDate1 = LocalDate.of(2017, 1, 23); //月份是从1,2,3.。。开始的
		int year = localDate1.getYear();
		int month = localDate1.getMonth().getValue();
		int dayOfMonth = localDate1.getDayOfMonth();
		System.out.println("localDate: year["+year+"], month["+month+"], dayOfMonth["+dayOfMonth+"]");
	}
	
	@Test
	public void test0003() {
		LocalDate localDate1 = LocalDate.of(2017, 1, 23); 
		boolean leapYear = localDate1.isLeapYear();
		System.out.println(localDate1.toString() + " is leapYear ? " + leapYear);
		
		LocalDate localDate2 = localDate1.plusYears(-1);
		leapYear = localDate2.isLeapYear();
		System.out.println(localDate2.toString() + " is leapYear ? " + leapYear);
	}
	
	@Test
	public void test0004() {
		LocalDate localDate1 = LocalDate.of(2017, 1, 31); 
		LocalDate localDate2 = localDate1.plusMonths(1);	//与calendar不同,localDate是不可变类
		System.out.println(localDate1.toString());
		System.out.println(localDate2.toString());
		
		LocalDate localDate3 = localDate1.plusMonths(2);
		LocalDate localDate4 = localDate2.plusMonths(1);
		System.out.println(localDate3.toString());
		System.out.println(localDate4.toString());
	}
	
	@Test
	public void test0005() {
		LocalDate localDate1 = LocalDate.of(2017, 10, 23);
		Period period = Period.ofDays(1);
		LocalDate localDate2 = localDate1.plus(period);
		System.out.println(localDate2.toString());
	}
	
	@Test
	public void test0006() {
		LocalDate localDate1 = LocalDate.of(2017, 10, 23);
		LocalDate localDate2 = LocalDate.of(2017, 9, 23);
		
		//两个日期的比较
		int compareTo = localDate1.compareTo(localDate2);	
		System.out.println(compareTo); 
		
		boolean equal = localDate1.isEqual(localDate2);
		System.out.println(localDate1 + " is equal " + localDate2 + " ? "+equal);
		
		boolean after = localDate1.isAfter(localDate2);
		System.out.println(localDate1 + " is after " + localDate2 + " ? "+after);
		
		boolean before = localDate1.isBefore(localDate2);
		System.out.println(localDate1 + " is before " + localDate2 + " ? "+before);
	}
	
	@Test
	public void test0007() {
		Date date = new Date();
		//Date --> LocalDate 
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		System.out.println(localDate.toString());
		
		//formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		String format1 = localDate.format(formatter);
		System.out.println(format1);
		
		formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		String format2 = localDate.format(formatter);
		System.out.println(format2);
		
		//LocalDate --> Date 
		SimpleDateFormat formate3 = new SimpleDateFormat("yyyyMMdd");
		Instant instant2 = localDate.atStartOfDay().atZone(zoneId).toInstant();
		Date date2 = Date.from(instant2);
		System.out.println(formate3.format(date2));
	}
}
