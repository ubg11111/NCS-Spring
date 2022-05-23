package com.spring.mvc04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/join")
	public String join() {
		
		return "join";
		
	}
	
	@RequestMapping("/join_ok")
	public String joinOk(Person person, Model model) { // person DTO객체를 만든후 객체를 아래와같은 형태로 한번에 가져올 수 있다.
		
		//String name =  request.getParameter("name").trim();
		//String id =  request.getParameter("id").trim();
		//String pwd =  request.getParameter("pwd").trim();
		//int age =  
				//Integer.parseInt(request.getParameter("age").trim());
		//String phone =  request.getParameter("phone").trim();
		//String email =  request.getParameter("email").trim();
		//String addr =  request.getParameter("addr").trim();
		
		
		//model.addAttribute("userName", name);
		//model.addAttribute("userId", id);
		//model.addAttribute("userPwd", pwd);
		//model.addAttribute("userAge", age);
		//model.addAttribute("userPhone", phone);
		//model.addAttribute("userEmail", email);
		//model.addAttribute("userAddr", addr);
		
		// DTO 객체를 가져오는 형태
		model.addAttribute("DTO", person);
		
		return "joinInfo";
	}
	
}
