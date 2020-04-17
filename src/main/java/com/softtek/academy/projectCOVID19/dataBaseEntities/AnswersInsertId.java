package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.Date;

public class AnswersInsertId implements Serializable{

	private static final long serialVersionUID = -2784058955778964588L;
	private String is;
	private Date   answerDate;
	private int questions;
	private String questionDesc;
	
	public AnswersInsertId() {
		
	}
	
	public AnswersInsertId(String is, Date answerDate, int questions, String questionDesc) {
		super();
		this.is = is;
		this.answerDate = answerDate;
		this.questions = questions;
		this.questionDesc = questionDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerDate == null) ? 0 : answerDate.hashCode());
		result = prime * result + ((is == null) ? 0 : is.hashCode());
		result = prime * result + ((questionDesc == null) ? 0 : questionDesc.hashCode());
		result = prime * result + questions;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswersInsertId other = (AnswersInsertId) obj;
		if (answerDate == null) {
			if (other.answerDate != null)
				return false;
		} else if (!answerDate.equals(other.answerDate))
			return false;
		if (is == null) {
			if (other.is != null)
				return false;
		} else if (!is.equals(other.is))
			return false;
		if (questionDesc == null) {
			if (other.questionDesc != null)
				return false;
		} else if (!questionDesc.equals(other.questionDesc))
			return false;
		if (questions != other.questions)
			return false;
		return true;
	}
	
	
}
