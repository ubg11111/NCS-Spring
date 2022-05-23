package com.spring.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private JdbcTemplate template;
	
	String sql = null;
	
	@Override
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = null;
		
		sql = "select * from Products order by pnum desc";
		
		return list = this.template.query(sql, new RowMapper<ProductDTO>() {
			
			public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductDTO dto = new ProductDTO();
				
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mailge"));
				dto.setCompany(rs.getString("company"));
				
				return dto;
			}
			
		});
		
		
	}

	@Override
	public int insertProduct(final ProductDTO dto) {
		
		sql = "select max(pnum) from products";
		
		final int count = this.template.queryForInt(sql);
		
		sql = "insert into products values(?,?,?,?,?,?,?,?,?)";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setInt(1, count + 1);
				ps.setString(2, dto.getCategory_fk());
				ps.setString(3, dto.getCategory_name());
				ps.setString(4, dto.getEp_code_fk());
				ps.setInt(5, dto.getInput_price());
				ps.setInt(6, dto.getOutput_price());
				ps.setInt(7, dto.getTrans_cost());
				ps.setInt(8, dto.getMileage());
				ps.setString(9, dto.getCompany());
				
			}
		});
	}

	@Override
	public ProductDTO getProductCont(int pnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int pnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSeq(int pnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> searchProduct(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> categoryList() {
		
		List<CategoryDTO> cartList = null;
		
		sql = "select * from category order by cnum desc";
		
		return cartList = this.template.query(sql, new RowMapper<CategoryDTO>() {

			@Override
			public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				CategoryDTO dto = new CategoryDTO();
				
				dto.setCnum(rs.getInt("cnum"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setCategory_name(rs.getString("category_name"));
			
				
				return dto;
			}
		});
	}
}
