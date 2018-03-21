package com.time.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class JavaTime {

	@Test
	public void test001() {
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr1 = format1.format(date);
		System.out.println(dateStr1);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr2 = format2.format(date);
		System.out.println(dateStr2);
	}
	
	@Test
	public void test0002() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format1.format(calendar.getTime()));
		System.out.println("calendar: year["+year+"], month["+month+"], date["+date+"], dayOfMonth["+dayOfMonth+"], dayOfYear["+dayOfYear+"], hour["+hour+"]");
	}
	
	@Test
	public void test0003() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 9, 23);		//月份是从0,1,2,3.。。开始的
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format1.format(calendar.getTime()));
		
		//判断是否为闰年
		Boolean leapYear = isLeapYear(calendar.get(Calendar.YEAR));
		System.out.println(leapYear);
		
		calendar.add(Calendar.YEAR, -1);
		leapYear = isLeapYear(calendar.get(Calendar.YEAR));
		System.out.println(leapYear);
	}
	
	@Test
	public void test0004() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 1);
		Date date1 = calendar.getTime();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format1.format(date1));
		
		//add one day
		calendar.add(Calendar.DATE, 1);
		Date date2 = calendar.getTime();
		System.out.println(format1.format(date1) + " add one day " + format1.format(date2));
		
		//add one month
		calendar.add(Calendar.MONTH, 1);
		Date date3 = calendar.getTime();
		System.out.println(format1.format(date2) + " add one month " + format1.format(date3));
		
		//add one year
		calendar.add(Calendar.YEAR, 1);
		Date date4 = calendar.getTime();
		System.out.println(format1.format(date3) + " add one year " + format1.format(date4));
	}
	
	@Test
	public void test0005() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 31);
		Date date1 = calendar.getTime();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format1.format(date1));
		
		//add one month 大小月问题
		addOneMonth(calendar);
		addOneMonth(calendar);
		
		//大月月末加一个月是小于月末，而小月月末加一个月不是大月月末
		calendar.set(2017, 2, 31);
		Date date4 = calendar.getTime();
		System.out.println(format1.format(date4));
		
		addOneMonth(calendar);
		addOneMonth(calendar);
		
		calendar.set(2017, 1, 28);
		Date date5 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date date6 = calendar.getTime();
		System.out.println(format1.format(date5) + " add one day " + format1.format(date6));
	}
	
	@Test
	public void test0006() {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2017, 0, 31);
		Date date1 = calendar1.getTime();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format1.format(date1));
		
		int amount = 1;
		Calendar addMonth2 = addMonth(calendar1, amount);
		Date date2 = addMonth2.getTime();
		System.out.println(format1.format(date1) + " add "+amount+" month " + format1.format(date2));
		
		amount  = 2;
		Calendar addMonth3 = addMonth(addMonth2, amount);
		Date date3 = addMonth3.getTime();
		System.out.println(format1.format(date2) + " add "+amount+" month " + format1.format(date3));
		
	}
	
	//1月31号加4个月  != 4月30号加1个月
	@Test
	public void test0007() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2017, 0, 31);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2017, 3, 30);
		
		calendar1.add(Calendar.MONTH, 4);
		calendar2.add(Calendar.MONTH, 1);
		System.out.println(format.format(calendar1.getTime()));
		System.out.println(format.format(calendar2.getTime()));
	}
	
	@Test
	public void test0008() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2017, 0, 31);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2017, 3, 30);
		
		addMonth(calendar1, 2);
		addMonth(calendar2, 1);
		System.out.println(format.format(calendar1.getTime()));
		System.out.println(format.format(calendar2.getTime()));
	}
	
	@Test
	public void test0009() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2017, 3, 30);
		
		calendar1.add(Calendar.MONTH, 3);
		Date date = calendar1.getTime();
		System.out.println(format.format(date));
	}
	
	private void addOneMonth(Calendar calendar) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		Date date2 = calendar.getTime();
		System.out.println(format1.format(date) + " add one month " + format1.format(date2));
	}
	
	private Boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, 11, 31);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		if (dayOfYear == 366) {
			isLeapYear = true;
		}
		return isLeapYear;
	}
	
	private Calendar addMonth(Calendar calendar, int amount) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.MONTH, amount);
		int newYear = calendar.get(Calendar.YEAR);
		int newMonth = calendar.get(Calendar.MONTH);
		int newdayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		Boolean endOfMonth = isEndOfMonth(dayOfMonth, month, year);
		switch (newMonth) {
		case Calendar.JANUARY:
		case Calendar.MARCH:
		case Calendar.MAY:
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.OCTOBER:
			if (endOfMonth) {
				newdayOfMonth = 31;
			}
			break;
		case Calendar.APRIL:
		case Calendar.JUNE:
		case Calendar.SEPTEMBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			if (endOfMonth) {
				newdayOfMonth = 30;
			}
			break;
		case Calendar.FEBRUARY:
			if (isLeapYear(year)) {
				if (endOfMonth) {
					newdayOfMonth = 29;
				}
			} else {
				if (endOfMonth) {
					newdayOfMonth = 28;
				}
			}
			break;
		default:
			break;
		}
		
		calendar.set(newYear, newMonth, newdayOfMonth);
		return calendar;
	}
	
	//判断是否为月末
	private Boolean isEndOfMonth(int dayOfMonth, int month, int year) {
		boolean isEndOfMonth = false;
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.MARCH:
		case Calendar.MAY:
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.OCTOBER:
			if (dayOfMonth == 31) {
				isEndOfMonth = true;
			} 
			break;
		case Calendar.APRIL:
		case Calendar.JUNE:
		case Calendar.SEPTEMBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			if (dayOfMonth == 30) {
				isEndOfMonth = true;
			}
			break;
		case Calendar.FEBRUARY:
			if (isLeapYear(year)) {
				if (dayOfMonth == 29) {
					isEndOfMonth = true;
				}
			} else {
				if (dayOfMonth == 28) {
					isEndOfMonth = true;
				}
			}
			break;
		default:
			break;
		}
		return isEndOfMonth;
	}
}
