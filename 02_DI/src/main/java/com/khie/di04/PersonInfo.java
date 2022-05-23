package com.khie.di04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수 생성자
@NoArgsConstructor // 기본생성자
public class PersonInfo {
	
	private Person person;
	
	// 비즈니스 로직
	public void getPersonInfo() {
		// person이라는 객체가 데이터가 있다면
		if(person != null) {
			System.out.println("이름 >>> " + person.getName());
			System.out.println("성별 >>> " + person.getGender());
			System.out.println("나이 >>> " + person.getAge());
			System.out.println("주민번호 >>> " + person.getJuminNo());
		}
	}
	
}
