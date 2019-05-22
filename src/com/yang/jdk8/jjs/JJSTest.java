package com.yang.jdk8.jjs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JJSTest {

	public static void main(String[] args) {

		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine nashorn = engineManager.getEngineByName("js");

		String name = "yang";
		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		} catch (ScriptException e) {
			System.out.println("Ö´ÐÐ½Å±¾´íÎó: " + e.getMessage());
		}
		System.out.println(result.toString());
	}

}
