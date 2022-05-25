package com.khie.aop;

public class MyClass {
	
	// 공통사항은 다른곳에서 실행시키게끔 하고 핵심기능만을 수행하게끔 적용
	
	void aaa() {
		//System.out.println("이전에 실행되는 공통 메서드!!!"); // 이전 공통 기능
		System.out.println("aaa() 메서드 호출~"); // 핵심기능을 담당
		//System.out.println("이후에 실행되는 공통 메서드!!!"); // 이후 공통 기능
	}
	
	void bbb() {
		//System.out.println("이전에 실행되는 공통 메서드!!!"); // 이전 공통 기능
		System.out.println("bbb() 메서드 호출~");  // 핵심기능을 담당
		//System.out.println("이후에 실행되는 공통 메서드!!!"); // 이후 공통 기능
	}
	
	void ccc() {
		//System.out.println("이전에 실행되는 공통 메서드!!!"); // 이전 공통 기능
		System.out.println("ccc() 메서드 호출~");  // 핵심기능을 담당
		//System.out.println("이후에 실행되는 공통 메서드!!!"); // 이후 공통 기능
	}
	
	
	
}
