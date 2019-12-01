package com.javalec.calculator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 이와 같은 방법은 좋지 못한 방법
		 * 이를 해결하기 위해서 xml을 사용하여 값을 외부로부터 의존성 주입시키는 방법을 주로 사용
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCarculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(20);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		*/
		
		String configloc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configloc);
		MyCalculator myCalculator = ctx.getBean("MyCalculator", MyCalculator.class);
		Calculator Calculator = ctx.getBean("Calculator", Calculator.class);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
		Calculator.add(4, 3);
	}
}
