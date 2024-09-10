package com.yash.quiz_service.model;


public class Response 
{
	private int id;
	private String answer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Response(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	
	
}
