package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="ANSWERS")
@IdClass(AnswerId.class)
public class Answers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name = "FK_IS", referencedColumnName = "IS", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private People people;
	
	@Id
    @Basic(optional = false)
    @Column(name = "DATE_ANSWER", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date   answerDate;
	
	@Id
	@JoinColumn(name = "FK_QUESTION", referencedColumnName = "PK_QUESTION", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Questions questions;
	
	@Basic(optional = false)
    @Column(name = "ANSWER", nullable = false, length = 300)
	private String questionDesc;

	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}

	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(answerDate, people, questionDesc, questions);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answers other = (Answers) obj;
		return Objects.equals(answerDate, other.answerDate) && Objects.equals(people, other.people)
				&& Objects.equals(questionDesc, other.questionDesc) && Objects.equals(questions, other.questions);
	}
	@Override
	public String toString() {
		return new StringBuilder()
		.append("Answers [people=")
		.append(people)
		.append(", answerDate=")
		.append(answerDate)
		.append(", questions=")
		.append(questions)
		.append(", questionDesc=")
		.append(questionDesc)
		.append("]")
		.toString();
	}
}
