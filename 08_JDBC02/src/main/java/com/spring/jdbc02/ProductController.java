package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("product_content.do")
	public String content(@RequestParam("pnum") int num, Model model) {
		
		// 상품의 상세정보를 호출
		ProductDTO dto = this.dao.getProductCont(num);
		
		model.addAttribute("Cont", dto);
		
		return "product_content";
		
		
	}
	
	@RequestMapping("product_modify.do")
	public String modify(@RequestParam("pnum") int pnum, Model model) {
		
		// 상품의 상세정보를 호출
		ProductDTO dto = this.dao.getProductCont(pnum);
		
		model.addAttribute("modify", dto);
		
		return "product_modify";
	}
	
	
	@RequestMapping("product_modify_ok.do")
	public void modifyOk(ProductDTO dto, HttpServletResponse response) throws IOException {
		
		int check = this.dao.updateProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('제품수정성공')");
			out.println("location.href='product_content.do?pnum="+dto.getPnum()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품수정실패')");
			out.println("histroy.go(-1)");
			out.println("</script>");
		}
		
		
	}
	
	@RequestMapping("product_delete.do")
	public void delete(@RequestParam("pnum") int pnum, HttpServletResponse response) throws IOException {
		
		int check = this.dao.deleteProduct(pnum);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		if(check > 0) {
			// 삭제된 제품번호보다 큰 번호에 대해서 다시 번호를 재작업
			this.dao.updateSeq(pnum);
			
			
			out.println("<script>");
			out.println("alert('제품 삭제 성공 !!!!')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('제품 삭제 실패 !!!!')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	@RequestMapping("products_search.do")
	public String search(@RequestParam("field") String field,
			@RequestParam("keyword") String keyword, Model model) {
		
		List<ProductDTO> search =  this.dao.searchProduct(field, keyword);
		
		model.addAttribute("Search",search );
		
		return "product_searchList";
		
	}
}
