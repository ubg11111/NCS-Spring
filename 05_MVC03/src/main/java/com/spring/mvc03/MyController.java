package com.spring.mvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/student")
	public String student() {
		
		return "student";
		
	}
	
	@RequestMapping("/report")
	public String report(HttpServletRequest request, Model model) {
		
		String student_name = request.getParameter("student_name").trim();
		int korScore = 
				Integer.parseInt(request.getParameter("kor").trim());
		int matScore = 
				Integer.parseInt(request.getParameter("mat").trim());
		int engScore = 
				Integer.parseInt(request.getParameter("eng").trim());
		
		// 총점
		int sum = korScore + matScore + engScore;
		// 평균
		double avg = sum / 3;
		
		// 평균 두자리수로 표현하기
		String avgFomat = 
				String.format("%.2f", avg);
		
		// 학점
		String grade;
		
		if(avg > 90) {
			grade = "A";
		}else if(avg > 80) {
			grade = "B";
		}else if(avg > 70) {
			grade = "C";
		}else if(avg > 60) {
			grade = "D";
		}else {
			grade = "F";
		}
			
		
		model.addAttribute("student_name", student_name);
		model.addAttribute("kor", korScore);
		model.addAttribute("mat", matScore);
		model.addAttribute("eng", engScore);
		model.addAttribute("sum", sum);
		model.addAttribute("avgFomat", avgFomat);
		model.addAttribute("grade", grade);
		
		return "report";
	}
	
}
