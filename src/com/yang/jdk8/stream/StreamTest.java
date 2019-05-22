package com.yang.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {

		// 计算空字符创
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		System.out.println("列表:" + strings);
		int c7_1 = getCountEmptyStringUsingJava7(strings);
		System.out.println("java7空字符数量:" + c7_1);
		long c8_1 = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("java8空字符数量:" + c8_1);

		// 计算长度为3的字符串
		int c7_2 = getCountLength3UsingJava7(strings);
		System.out.println("java7长度为3的字符串个数:" + c7_2);
		long c8_2 = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("java8长度为3的字符串个数:" + c8_2);

		// 删除空字符串并
		List<String> c7_3 = deleteEmptyStringUsingJava7(strings);
		System.out.println("java7筛选后的列表:" + c7_3);
		List<String> c8_3 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("java8筛选后的列表:" + c7_3);

		// 删除空字符串，并使用-把它们合并起来
		String c7_4 = getMergedStringUsingJava7(strings, ",");
		System.out.println("java7合并字符串:" + c7_4);
		String c8_4 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
		System.out.println("java8合并字符串:" + c8_4);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取列表元素平方数
		List<Integer> c7_5 = getSquares(numbers);
		System.out.println("java7平方数列表: " + c7_5.toString());
		List<Integer> c8_5 = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("java8平方数列表: " + c8_5.toString());

		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		// 列表中最大数
		int c7_6 = getMax(integers);
		System.out.println("java7列表中最大数:" + c7_6);
		IntSummaryStatistics c8_6 = integers.stream().mapToInt((i) -> i).summaryStatistics();
		System.out.println("java8列表中最大数:" + c8_6.getMax());

		// 列表中最小数
		int c7_7 = getMin(integers);
		System.out.println("java7列表中最小数:" + c7_7);
		System.out.println("java8列表中最小数:" + c8_6.getMin());

		// 列表总数
		System.out.println("java7列表总数:" + getSum(integers));
		System.out.println("java8列表总数:" + c8_6.getSum());

		// 平均数
		System.out.println("java7列表平均数" + getAverage(integers));
		System.out.println("java8列表平均数" + c8_6.getAverage());

		System.out.print("java7随机数:\n");
		Random random = new Random();
		for (int j = 0; j < 10; j++) {
			System.out.print(random.nextInt() + ",");
		}
		System.out.println("\njava8随机数:");
		random.ints().limit(10).sorted().forEach(System.out::print);

		long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("\n空字符串的数量为: " + count);
	}

	private static int getAverage(List<Integer> integers) {
		return getSum(integers) / integers.size();
	}

	private static int getSum(List<Integer> integers) {
		int sum = (int) (integers.get(0));
		for (int i = 1; i < integers.size(); i++) {
			sum += (int) integers.get(i);
		}
		return sum;
	}

	private static int getMin(List<Integer> integers) {
		int min = integers.get(0);
		for (int i = 0; i < integers.size(); i++) {
			Integer num = integers.get(i);
			if (num.intValue() < min) {
				min = num.intValue();
			}
		}
		return min;
	}

	private static int getMax(List<Integer> integers) {
		int max = integers.get(0);
		for (int i = 0; i < integers.size(); i++) {
			Integer num = integers.get(i);
			if (num.intValue() > max) {
				max = num.intValue();
			}

		}
		return max;
	}

	private static List<Integer> getSquares(List<Integer> numbers) {
		List<Integer> squaresList = new ArrayList<Integer>();

		for (Integer integer : numbers) {
			Integer square = new Integer(integer.intValue() * integer.intValue());
			if (!squaresList.contains(square)) {
				squaresList.add(square);
			}
		}
		return squaresList;
	}

	private static String getMergedStringUsingJava7(List<String> strings, String separator) {

		StringBuilder builder = new StringBuilder();

		for (String string : strings) {
			if (!string.isEmpty()) {
				builder.append(string);
				builder.append(separator);
			}

		}
		String string = builder.toString();
		return string.substring(0, string.length() - 1);
	}

	private static List<String> deleteEmptyStringUsingJava7(List<String> strings) {

		List<String> list = new ArrayList<String>();

		for (String string : strings) {
			if (!string.isEmpty()) {
				list.add(string);
			}
		}
		return list;
	}

	private static int getCountLength3UsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings) {
			if (string.length() == 3) {
				count++;
			}
		}
		return count;
	}

	// 计算空字符串长度
	private static int getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings) {
			if (string.isEmpty()) {
				count++;
			}
		}
		return count;
	}

}
