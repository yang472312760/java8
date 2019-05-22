package com.yang.jdk8.lambda;

public class LambdaTest {

	public static void main(String[] args) {

		LambdaTest test = new LambdaTest();
		// ��������
		MathOperation operation1 = (int a, int b) -> a + b;
		// ������������
		MathOperation operation2 = (a, b) -> a - b;
		// �������еķ������
		MathOperation operation3 = (int a, int b) -> {
			return a * b;
		};
		// û�д����ż��������
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + test.operate(10, 5, operation1));
		System.out.println("10 - 5 = " + test.operate(10, 5, operation2));
		System.out.println("10 * 5 = " + test.operate(10, 5, operation3));
		System.out.println("10 / 5 = " + test.operate(10, 5, division));

		// ��������
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// ������
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");

	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

}
