package com.javalec.calculator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* �̿� ���� ����� ���� ���� ���
		 * �̸� �ذ��ϱ� ���ؼ� xml�� ����Ͽ� ���� �ܺηκ��� ������ ���Խ�Ű�� ����� �ַ� ���
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
