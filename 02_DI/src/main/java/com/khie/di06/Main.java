package com.khie.di06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		String path1 = "classpath:baseball.xml";
		String path2 = "classpath:baseball2.xml";
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path1, path2);
		
		PlayerInfo info =  ctx.getBean("info", PlayerInfo.class);
		
		info.getPlayerInfo();
		
		System.out.println("===========================================");
		
		BaseballTeam team = (BaseballTeam)ctx.getBean("team");
		
		System.out.println(":::::::: 국가대표 야구 선수단 :::::::::::");
		System.out.println("대표팀 감독 >>> " + team.getManager());
		System.out.println("대표팀 타격코치 >>> " + team.getBattingCoach());
		System.out.println("대표팀 투수코치 >>> " + team.getPitcherCoach());
		System.out.println("대표팀 타자 >>> " + team.getHitter());
		System.out.println("대표팀 투수 >>> " + team.getPitcher());
		
		
		ctx.close();
		
		
	}
}
