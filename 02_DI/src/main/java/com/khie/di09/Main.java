package com.khie.di09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:baseball3.xml");
		
		Player player1 =  ctx.getBean("player1", Player.class);
		
		System.out.println("선수 이름 >>> "  + player1.getName());
		System.out.println("선수 나이 >>> "  + player1.getAge());
		System.out.println("선수 포지션 >>> "  + player1.getPosition());
		System.out.println("선수 체중 >>> "  + player1.getWeight());
		System.out.println("선수 신장 >>> "  + player1.getHeight());
		
		System.out.println("====================================");
		
		Player player2 =  ctx.getBean("player2", Player.class);
		
		System.out.println("선수 이름 >>> "  + player2.getName());
		System.out.println("선수 나이 >>> "  + player2.getAge());
		System.out.println("선수 포지션 >>> "  + player2.getPosition());
		System.out.println("선수 체중 >>> "  + player2.getWeight());
		System.out.println("선수 신장 >>> "  + player2.getHeight());
		
		
		System.out.println("====================================");
		
	}
}
