package com.spring.model;

import java.util.List;
import java.util.Locale.Category;

public interface ProductDAO {
	
	List<ProductDTO> getProductList();
	
	int insertProduct(ProductDTO dto);
	
	ProductDTO getProductCont(int pnum);
	
	int updateProduct(ProductDTO dto);
	
	int deleteProduct(int pnum);
	
	void updateSeq(int pnum);
	
	List<ProductDTO> searchProduct(String field, String keyword);
	
	List<CategoryDTO> categoryList();
	
}
