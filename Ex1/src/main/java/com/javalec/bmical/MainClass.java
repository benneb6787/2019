package com.javalec.bmical;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String configLoc = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);	//스프링 컨테이너 생성(IOC)
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);							//스프링 컨테이너에서 컴포넌트 갖고옴
		myInfo.getInfo();
		ctx.close();
	}

}
