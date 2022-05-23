package com.khie.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// AbstractApplicationContext 객체가 DI 작업을 해주는 스프링 컨테이너.
		// xml 파일을 이용하여 메모리로 해당 xml 파일이 로딩이 됨.
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:exam.xml");
		
		// 두번째 파라미터는 객체의 클래스타입을 의미한다. (형변환 대신 두번째 파라미터 형식으로 가져와도 됨)
		Exam exam =  ctx.getBean("exam", Exam.class);
	
		exam.output();
		
		ctx.close();
		
	}
}
