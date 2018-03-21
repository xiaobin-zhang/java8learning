package com.time.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

public class JodaLocalDate {

	@Test
	public void test0001() {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());
		
		LocalDate localDate2 = LocalDate.parse("2017-10-23");
		System.out.println(localDate2.toString());
		
		LocalDate localDate3 = new LocalDate(new Date());
		System.out.println(localDate3.toString());
	}
	
	@Test
	public void test0002() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();		
		int monthOfYear = localDate.getMonthOfYear(); //月份从1,2,3...开始
		int dayOfMonth = localDate.getDayOfMonth();
		System.out.println("joda lcoalDate: year["+year+"], monthOfYear["+monthOfYear+"], dayOfMonth["+dayOfMonth+"]");
	}
	
	@Test
	public void test0003() {
		LocalDate localDate1 = LocalDate.parse("2017-01-01");
		LocalDate localDate2 = LocalDate.parse("2017-02-01");
		
		int compareTo = localDate1.compareTo(localDate2);
		System.out.println(compareTo);
		
		boolean equal = localDate1.isEqual(localDate2);
		System.out.println(localDate1.toString() +" is equal "+ localDate2.toString() +" ? "+ equal);
		
		boolean after = localDate1.isAfter(localDate2);
		System.out.println(localDate1.toString() +" is after "+ localDate2.toString() +" ? "+ after);
		
		boolean before = localDate1.isBefore(localDate2);
		System.out.println(localDate1.toString() +" is before "+ localDate2.toString() +" ? "+ before);
	}
	
	@Test
	public void test0004() {
		LocalDate localDate1 = LocalDate.parse("2017-01-01");
		
		LocalDate localDate2 = localDate1.plusDays(1);
		System.out.println(localDate1.toString() + " add one day " + localDate2.toString());
		
		LocalDate localDate3 = localDate1.plusMonths(1);
		System.out.println(localDate1.toString() + " add one month " + localDate3.toString());
		
		LocalDate localDate4 = localDate1.plusMonths(2);
		System.out.println(localDate1.toString() + " add two month " + localDate4.toString());
	}
	
	@Test
	public void test0005() {
		//大小月问题
		LocalDate localDate1 = LocalDate.parse("2017-01-31");
		LocalDate localDate2 = localDate1.plusMonths(4);
		
		LocalDate localDate3 = LocalDate.parse("2017-04-30");
		LocalDate localDate4 = localDate3.plusMonths(1);
		
		System.out.println(localDate1.toString() + " add 4 month " + localDate2.toString());
		System.out.println(localDate3.toString() + " add 1 month " + localDate4.toString());
	}
	
	@Test
	public void test0006() {
		//Date --> LocalDate
		Date date = new Date();
		LocalDate localDate = new LocalDate(date);
		System.out.println(localDate.toString());
		
		//LocalDate --> Date
		Date date2 = localDate.toDate();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date2));
	}
}
