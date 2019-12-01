package com.javalec.pencil;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MailClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLoc = "classpath:applicationCTX4.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		ctx.close();
	}

}
