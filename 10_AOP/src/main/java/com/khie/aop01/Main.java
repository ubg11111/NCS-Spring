package com.khie.aop01;

public class Main {
	public static void main(String[] args) {
		Person boy = new Boy();
		Person gilr = new Girl();
		PersonAdvice advice = new PersonAdvice();
		
		
		advice.setPerson(gilr);
		advice.doSomething();
		
	}
}
