package com.spring.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// String sql = null;
	
	
	@Override
	public List<MemberDTO> getMeberList() {
		
		return this.sqlSession.selectList("all");
		
	}

	@Override
	public int insertMember(MemberDTO dto) {
		
		return this.sqlSession.insert("add", dto);
		
	}

	@Override
	public MemberDTO getMember(int num) {
		
		return this.sqlSession.selectOne("content", num);
		
	}

	@Override
	public int updateMember(MemberDTO dto) {
		
		return this.sqlSession.update("update", dto);
		
	}

	@Override
	public int deleteMember(int num) {
		
		return this.sqlSession.delete("delete", num);
		
	}

	@Override
	public void updateSequnce(int num) {
		
		this.sqlSession.update("updateSeq", num);
		
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
