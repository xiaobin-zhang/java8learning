package com.time.test;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.junit.Test;

public class JodaLocalDateTime {

	@Test
	public void test0001() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toString());
		
		LocalDateTime localDateTime2 = new LocalDateTime(new Date());
		System.out.println(localDateTime2.toString());
	}
}
