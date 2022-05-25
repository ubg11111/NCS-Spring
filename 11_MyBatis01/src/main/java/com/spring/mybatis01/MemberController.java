package com.spring.mybatis01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.MemberDAO;
import com.spring.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("member_list.do")
	public String list(Model model) {
		
		List<MemberDTO> list =  this.dao.getMeberList();
		
		model.addAttribute("List", list);
		
		return "member_list";
		
	}
	
	
	@RequestMapping("member_insert.do")
	public String insert() {
		
		return "member_insert";
				
		
	}
	
	@RequestMapping("member_insert_ok.do")
	public void insertOk(MemberDTO dto,
			HttpServletResponse response) throws IOException {
		
		int check =  this.dao.insertMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			out.println("<script>");
			out.println("alert('회원 등록 성공 !!!')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
			
		}else {
			out.println("<script>");
			out.println("alert('회원 등록 실패 !!!')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	@RequestMapping("member_content.do")
	public String content(@RequestParam("num") int num, Model model) {
		
		MemberDTO dto = this.dao.getMember(num);
		
		model.addAttribute("Cont", dto);
		
		return "member_content";
		
	}
	
	
	@RequestMapping("member_update.do")
	public String update(@RequestParam("num") int num, Model model) {
		
		MemberDTO dto = this.dao.getMember(num);
		
		model.addAttribute("Update", dto);
		
		return "member_update";
		
	}
	
	@RequestMapping("member_update_ok.do")
	public void updateOk(MemberDTO dto, HttpServletResponse response) throws IOException {
		
		int check = this.dao.updateMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			
			out.println("<script>");
			out.println("alert('수정성공!!')");
			out.println("location.href='member_content.do?num="+dto.getNum()+"'");
			out.println("</script>");
			
		}else {
			
			out.println("<script>");
			out.println("alert('수정실패!!!')");
			out.println("history.back()");
			out.println("</script>");
			
		}
	}
	
	@RequestMapping("member_delete.do")
	public void delete(@RequestParam("num") int num, HttpServletResponse response) throws IOException {
		
		int check = this.dao.deleteMember(num);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			this.dao.updateSequnce(num);
			
			out.println("<script>");
			out.println("alert('삭제 성공!!')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
			
		}else {
			
			out.println("<script>");
			out.println("alert('삭제 실패!!')");
			out.println("history.back()");
			out.println("</script>");
			
			
		}
		
		
	}
	
}
