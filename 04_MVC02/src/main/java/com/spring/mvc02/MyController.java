package com.spring.mvc02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@RequestMapping("/input")
	public String abc() {
		
		return "insertForm";
		
	}
	
	@RequestMapping("/inputOk")
	public String aaa(HttpServletRequest request, Model model) {
		
		String user_name = request.getParameter("name").trim();
		String user_id = request.getParameter("id").trim();
		
		model.addAttribute("userName", user_name);
		model.addAttribute("userId", user_id);
		
		return "loginResult";
		
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "loginForm";
		
	}
	
	@RequestMapping("/loginOk")
	public String loginOk(@RequestParam("userId") String user_id, 
			@RequestParam("user_pwd") String user_pwd,
			Model model) {
		
		// String user_id  = request.getParameter("userId").trim();
		// String user_pwd =  request.getParameter("userPwd").trim();
		
		model.addAttribute("userId", user_id);
		model.addAttribute("userPwd", user_pwd);
		
		return "result";
		
	}
	
}
