package com.spring.model;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int pnum;
	private String category_fk;
	private String category_name;
	private String ep_code_fk;
	private int input_price;
	private int output_price;
	private int trans_cost;
	private int mileage;
	private String company;
	
}
