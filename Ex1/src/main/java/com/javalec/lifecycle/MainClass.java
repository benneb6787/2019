package com.javalec.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX9.xml");
		ctx.refresh();
		ctx.close();
	}
}
