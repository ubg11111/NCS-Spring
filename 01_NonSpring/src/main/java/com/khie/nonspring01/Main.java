package com.khie.nonspring01;

public class Main {

	public static void main(String[] args) {
		
		// 기존에 Java, JSP 사용하던 방식
		MySqlDAO mysqldao = new MySqlDAO();
		mysqldao.add();
		
		
		OracleDAO oracledao = new OracleDAO();
		oracledao.add();
		
		System.out.println("===================");
		
		// 스프링방식
		// 1. 인자생성자를 이용하여 주입하는 방법
		ServiceImpl impl = new ServiceImpl(new MySqlDAO()); // 객체생성의 매개변수값만 수정
		
		impl.biz();
		
		// 2. setter() 메서드를 이용하여 주입하는 방법
		ServiceImpl impl2 = new ServiceImpl();
		impl2.setDao(new OracleDAO());
		impl2.biz();
		
	}
}
