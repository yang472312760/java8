package com.yang.jdk8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class BaseTest {

	public static void main(String[] args) {

		try {
			// ����
			String string = Base64.getEncoder().encodeToString("yangchenglin".getBytes("utf-8"));
			System.out.println("base64 ����(����)--" + string);

			// ����
			byte[] decode = Base64.getDecoder().decode(string);
			System.out.println("ԭʼ�ַ�--" + new String(decode));

			String string2 = Base64.getUrlEncoder().encodeToString("www.baidu.com".getBytes("utf-8"));
			System.out.println("base����(URL)--" + string2);

			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < 10; i++) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] bytes = stringBuilder.toString().getBytes("utf-8");
			String string3 = Base64.getMimeEncoder().encodeToString(bytes);
			System.out.println("base����(MIME)--" + string3);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
