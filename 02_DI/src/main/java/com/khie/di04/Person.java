package com.khie.di04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수 생성자 이노테이션
@NoArgsConstructor // 기본생성자 이노테이션
public class Person {
	
	private String name;
	private String gender;
	private int age;
	private String juminNo;
	
}
