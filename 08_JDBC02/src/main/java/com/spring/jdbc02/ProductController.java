package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.CategoryDTO;
import com.spring.model.ProductDAO;
import com.spring.model.ProductDTO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	
	@RequestMapping("product_list.do")
	public String productList(Model model) {
		
		List<ProductDTO> list =  this.dao.getProductList();
		
		model.addAttribute("ProductList", list);
		
		return "productList";
	}
	
	@RequestMapping("product_insert.do")
	public String insert(Model model) {
		
		// 제품 카테고리 코드 목록을 조회하여 제품 등록 폼페이지로 이동
		
		List<CategoryDTO> list =  this.dao.categoryList();
		
		model.addAttribute("cartList", list);
		
		return "product_insert";
		
	}
	
	@RequestMapping("product_insert_ok.do")
	public void insertOk(ProductDTO dto, 
			HttpServletResponse response) throws IOException {
		
		int check = this.dao.insertProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			out.println("<script>");
			out.println("alert('제품 등록 성공')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
			
		}else {
			out.println("<script>");
			out.println("alert('제품 등록 실패')");
			out.println("history.back()'");
			out.println("</script>");
		}
		
	}
	
}
