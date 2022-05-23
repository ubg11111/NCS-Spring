package com.khie.di06;

import lombok.Data;

@Data
public class BaseballTeam {
	
	private String manager;
	private String battingCoach;
	private String pitcherCoach;
	private String hitter;
	private String pitcher;
	
	
	public BaseballTeam() {} // 기본생성자
	
	public BaseballTeam(String manager,
			String battingCoach, String pitcherCoach) {
		this.manager = manager;
		this.battingCoach = battingCoach;
		this.pitcherCoach = pitcherCoach;
	} // 인자 생성자
	
}
