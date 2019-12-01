package com.javalec.di3;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javalec.di3.Student;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 10, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
}
