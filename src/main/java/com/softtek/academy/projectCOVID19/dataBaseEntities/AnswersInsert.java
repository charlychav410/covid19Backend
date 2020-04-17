package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="ANSWERS")
@IdClass(AnswersInsertId.class)
public class AnswersInsert implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2784058955778964588L;

	@Id
	@Column(name = "FK_IS")
	private String is;
	
	@Id
    @Basic(optional = false)
    @Column(name = "DATE_ANSWER", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   answerDate;
	
	@Column(name = "FK_QUESTION")
	private int questions;
	
	@Basic(optional = false)
    @Column(name = "ANSWER", nullable = false, length = 300)
	private String questionDesc;

	public String getIs() {
		return is;
	}

	public void setIs(String is) {
		this.is = is;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public int getQuestions() {
		return questions;
	}

	public void setQuestions(int questions) {
		this.questions = questions;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

}
