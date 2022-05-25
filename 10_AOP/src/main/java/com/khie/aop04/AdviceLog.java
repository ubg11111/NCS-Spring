package com.khie.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {
	
	// ProceedingJoinPoint 객체는 원래 실행되어야 할 대상 메서드(핵심 기능) 대행(프록시) 객체
	public Object profile(ProceedingJoinPoint jp) throws Throwable {
		
		// getSignature() : 호출되는 메서드에 대한 정보를 알려주는 메서드
		String signStr = jp.getSignature().toString();
		
		System.out.println(signStr + "is start!!!");
		
		long startTime = System.currentTimeMillis();
		
		Object obj =  jp.proceed(); // 핵심기능을 실행하는 메서드
		
		System.out.println(signStr + "is end!!!!");
		
		System.out.println("경과 시간 >>> " + (System.currentTimeMillis() - startTime) + "ms");
		
		return obj;
		
	}
}
