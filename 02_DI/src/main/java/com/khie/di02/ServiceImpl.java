package com.khie.di02;

public class ServiceImpl {
	
	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 비지니스로직
	public void biz() {
		// DAO객체의 add메서드에 접근
		this.dao.add();
	}
}
