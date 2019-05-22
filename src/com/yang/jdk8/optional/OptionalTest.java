package com.yang.jdk8.optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {

		OptionalTest optionalTest = new OptionalTest();
		Integer v1 = null;
		Integer v2 = 15;

		// Optional.ofNullable - ������Ϊ null ����
		Optional<Integer> a = Optional.ofNullable(v1);

		Optional<Integer> b = Optional.of(v2);
		Integer sum = optionalTest.sum(a, b);
		System.out.println(sum);
		
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - �ж�ֵ�Ƿ����
		System.out.println("��һ�������Ƿ����:" + a.isPresent());
		System.out.println("��һ�������Ƿ����:" + b.isPresent());
		// Optional.orElse - ���ֵ���ڣ������������򷵻�Ĭ��ֵ
		Integer orElse = a.orElse(new Integer(0));

		// Optional.get - ��ȡֵ��ֵ��Ҫ����
		Integer integer = b.get();
		return integer + orElse;
	}

}
