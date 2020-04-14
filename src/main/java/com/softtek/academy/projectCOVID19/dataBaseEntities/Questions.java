package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="QUESTIONS")
public class Questions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "PK_QUESTION", nullable = false)
	private int idQuestion;
	
	@Basic(optional = false)
    @Column(name = "QUESTION", nullable = false, length = 300)
	private String question;

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idQuestion, question);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		return idQuestion == other.idQuestion && Objects.equals(question, other.question);
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Questions [idQuestion=")
		.append(idQuestion)
		.append(", question=")
		.append(question)
		.append("]")
		.toString();
	}
}
