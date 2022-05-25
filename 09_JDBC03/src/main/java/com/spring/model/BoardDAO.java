package com.spring.model;

import java.util.List;

public interface BoardDAO {
	
	List<BoardDTO> getBoardList();
	int insertBoard(BoardDTO dto);
	BoardDTO getBoardCont(int board_no);
	int updateBoard(BoardDTO dto);
	BoardDTO deleteBoard(int board_no);
	void updateSeq(int board_no);
	List<BoardDTO> searchBoard(String field, String keyword);
	
}
