package com.yang.jdk8.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateAPITest {

	public static void main(String[] args) {
		DateAPITest test = new DateAPITest();
		test.testLocalDateTime();
	}

	public void testLocalDateTime() {
		// 获取当前的日期时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("当前时间:" + localDateTime);

		LocalDate localDate = localDateTime.toLocalDate();
		System.out.println("date1:" + localDate);

		Month month = localDateTime.getMonth();
		int day = localDateTime.getDayOfMonth();
		int second = localDateTime.getSecond();
		System.out.println("月:" + month + ",日:" + day + ",秒:" + second);

		LocalDateTime date2 = localDateTime.withDayOfMonth(10).withYear(2013);
		System.out.println("date2:" + date2);

		LocalDate date3 = LocalDate.of(2014, Month.MAY, 15);
		System.out.println("date3:" + date3);

		LocalTime date4 = LocalTime.of(23, 25);
		System.out.println("date4:" + date4);
		// 解析字符串
		LocalTime date5 = LocalTime.parse("20:25:30");
		System.out.println("date5:" + date5);
	}

}
