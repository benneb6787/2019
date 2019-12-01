package com.javalec.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;

	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@PostConstruct
	public void initMethod() {
		System.out.println("InitMethod()");
	}

	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
}
