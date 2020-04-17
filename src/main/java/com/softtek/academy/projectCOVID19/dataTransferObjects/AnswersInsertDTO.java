package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.util.Date;

public class AnswersInsertDTO {
	private String is;
	private Date date;
	private String question;
	private String answer;
	
	
	public String getIs() {
		return is;
	}
	public void setIs(String is) {
		this.is = is;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
