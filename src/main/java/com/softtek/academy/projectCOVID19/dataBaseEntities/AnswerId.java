package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class AnswerId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private People people;
	private Date   answerDate;
	private Questions questions;
	
	public AnswerId() {
	}
	
	public AnswerId(People people, Date answerDate, Questions questions) {
		this.people = people;
		this.answerDate = answerDate;
		this.questions = questions;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(answerDate, people, questions);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerId other = (AnswerId) obj;
		return Objects.equals(answerDate, other.answerDate) && Objects.equals(people, other.people)
				&& Objects.equals(questions, other.questions);
	}
}
