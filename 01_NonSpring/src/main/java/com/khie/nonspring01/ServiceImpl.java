package com.khie.nonspring01;

public class ServiceImpl {
	
	private DAO dao;
	
	public ServiceImpl() {} // 기본생성자
	
	public ServiceImpl(DAO dao) {
		this.dao = dao; // 전역변수를 가리킨다
	}
	
	
	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 비지니스 로직
	public void biz() {
		dao.add();
	};
	
}
