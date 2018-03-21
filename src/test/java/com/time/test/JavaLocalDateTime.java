package com.time.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class JavaLocalDateTime {

	@Test
	public void test0001() {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(localDateTime.toString());
		
		LocalDateTime localDateTime2 = LocalDateTime.now();
		System.out.println(localDateTime2.toString());
		
		LocalTime localTime = LocalTime.of(14, 30);
		LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.now(), localTime);
		System.out.println(localDateTime3.toString());
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = localDateTime2.format(timeFormatter);
		System.out.println(format);
	}
	
	@Test
	public void test0002() {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		//Date --> LocalDateTime
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		LocalDateTime localDateTime = LocalDateTime.from(zonedDateTime);
		System.out.println(localDateTime.format(timeFormatter));
		
		//LocalDateTime --> Date
		Instant instant2 = localDateTime.atZone(zoneId).toInstant();
		Date date2 = Date.from(instant2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date2));
	}
	
	@Test
	public void test0003() {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 00));
		LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 00));
		
		int compareTo = localDateTime1.compareTo(localDateTime2);
		System.out.println(compareTo);
		
		boolean equal = localDateTime1.isEqual(localDateTime2);
		System.out.println(localDateTime1.format(timeFormatter) + " is equal " + localDateTime2.format(timeFormatter) + " ? " + equal);
		
		boolean after = localDateTime1.isAfter(localDateTime2);
		System.out.println(localDateTime1.format(timeFormatter) + " is after " + localDateTime2.format(timeFormatter) + " ? " + after);
		
		boolean before = localDateTime1.isBefore(localDateTime2);
		System.out.println(localDateTime1.format(timeFormatter) + " is before " + localDateTime2.format(timeFormatter) + " ? " + before);
	}
	
	
}
