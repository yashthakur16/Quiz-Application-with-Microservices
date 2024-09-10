package com.yash.quiz_service.model;

import org.springframework.stereotype.Component;

@Component
public class quizDto 
{
	private String level;
	private int num;
	private String title;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
