package com.yang.jdk8.dateapi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAPITest2 {

	public static void main(String[] args) {
		DateAPITest2 test2 = new DateAPITest2();
		test2.testZondDateTime();
	}

	public void testZondDateTime() {
		ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
		System.out.println("date1:" + date1);
	
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId:" + id);
		
		ZoneId id2 = ZoneId.systemDefault();
		System.out.println("当前时区:" + id2);
	}

}
