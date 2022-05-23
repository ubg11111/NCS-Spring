package com.khie.model;

import java.util.List;


public interface MemberDAO {
	
	// 추상메서드
	List<MemberDTO> getMemberList(); // 전체리스트조회
	int insertMember(MemberDTO dto); // 삽입
	MemberDTO getMember(int num); // 멤버조회
	int updateMember(MemberDTO dto); // 수정
	int deleteMember(int num); // 삭제
	void updateSequence(int num); // 삭제시 번호 정리
	List<MemberDTO> searchMemberList(String field, String keyword); // 검색기능
	
}
