package com.javalec.calculator;

public class MyCalculator {
	
	private Calculator carculator;
	private int firstNum;
	private int secondNum;
	
	public Calculator getCarculator() {
		return carculator;
	}
	public void setCarculator(Calculator carculator) {
		this.carculator = carculator;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void add() {
		carculator.add(firstNum, secondNum);
	}
	public void sub() {
		carculator.sub(firstNum, secondNum);
	}
	public void mul() {
		carculator.mul(firstNum, secondNum);
	}
	public void div() {
		carculator.div(firstNum, secondNum);
	}
}
