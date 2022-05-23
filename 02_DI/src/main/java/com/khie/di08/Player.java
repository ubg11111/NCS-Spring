package com.khie.di08;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Player {
	
	private String name;
	private int age;
	private ArrayList<String> position;
	private double weight;
	private double height;
	
	public Player() {}; //기본생성자
	
	public Player(String name, int age, ArrayList<String> position) {
		
		this.name = name;
		this.age = age;
		this.position = position;
	
	}; // 인자생성자
	
}
