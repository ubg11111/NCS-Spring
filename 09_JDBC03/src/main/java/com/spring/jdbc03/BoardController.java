package com.spring.jdbc03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.BoardDAO;
import com.spring.model.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	
	@RequestMapping("board_list.do")
	public String boardList(Model model) {
		
		List<BoardDTO> list =  this.dao.getBoardList();
		
		model.addAttribute("boardList", list);
		
		return "board_list";
	}
	
	@RequestMapping("board_insert.do")
	public String insert() {

		return "board_insert";
		
	}
	
	
	@RequestMapping("board_insert_ok.do")
	public void insertOk(BoardDTO dto, 
			HttpServletResponse response) throws IOException {
		
		int check = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('글 등록 성공')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	@RequestMapping("board_content.do")
	public String content(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto = this.dao.getBoardCont(no);
		
		model.addAttribute("Cont", dto);
		
		return "board_content";
		
	}
	
	@RequestMapping("board_update.do")
	public String update(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto =  this.dao.getBoardCont(no);
		
		model.addAttribute("update", dto);
		
		return "board_update";
		
	}
	
	@RequestMapping("board_update_ok.do")
	public void updateOk(BoardDTO dto, HttpServletResponse response) throws IOException {
		
		int check =  this.dao.updateBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			out.println("<script>");
			out.println("alert('수정성공')");
			out.println("location.href='board_list.do?no="+dto.getBoard_no()+'"');
			out.println("</script>");
		} else {
			
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_delete.do")
	public String delete(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto = this.dao.deleteBoard(no);
		
		model.addAttribute("delete", dto);
		
		return "board_delete";
		
	}
	
}
