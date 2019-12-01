package com.javalec.bmical;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String configLoc = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);	//������ �����̳� ����(IOC)
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);							//������ �����̳ʿ��� ������Ʈ �����
		myInfo.getInfo();
		ctx.close();
	}

}
