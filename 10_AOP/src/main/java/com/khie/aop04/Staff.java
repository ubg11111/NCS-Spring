package com.khie.aop04;

import lombok.Data;

@Data
public class Staff {
	
	private String name;
	private int age;
	private String dept;
	
	
	// Staff에 대한 정보를 가져오는 메서드
	public void getStaffInfo() {
		System.out.println("스텝 이름 >>> " + getName());
		System.out.println("스텝 나이 >>> " + getAge());
		System.out.println("스텝 부서 >>> " + getDept());
	}
	
}
