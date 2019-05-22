package com.yang.jdk8.optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {

		OptionalTest optionalTest = new OptionalTest();
		Integer v1 = null;
		Integer v2 = 15;

		// Optional.ofNullable - 允许传递为 null 参数
		Optional<Integer> a = Optional.ofNullable(v1);

		Optional<Integer> b = Optional.of(v2);
		Integer sum = optionalTest.sum(a, b);
		System.out.println(sum);
		
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - 判断值是否存在
		System.out.println("第一个参数是否存在:" + a.isPresent());
		System.out.println("第一个参数是否存在:" + b.isPresent());
		// Optional.orElse - 如果值存在，返回它，否则返回默认值
		Integer orElse = a.orElse(new Integer(0));

		// Optional.get - 获取值，值需要存在
		Integer integer = b.get();
		return integer + orElse;
	}

}
