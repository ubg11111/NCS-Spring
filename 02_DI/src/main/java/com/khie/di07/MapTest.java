package com.khie.di07;

import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data // getter,setter를 자동 설정해준다
public class MapTest {
	
	private Map<Integer, String> map;
	
	// 비즈니스 로직
	public void prn() {
		
		// keySet() : Map에 있는 키를 전부 다 가져오는 메서드.
		Set<Integer> set = map.keySet();
		
		for(Integer k : set) {
			System.out.println(map.get(k));
		}
	}
}
