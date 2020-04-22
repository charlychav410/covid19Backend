package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;
import java.util.Objects;

public class AnwersSelectDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String message;
	
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AnwersSelectDTO other = (AnwersSelectDTO) obj;
		return Objects.equals(answer1, other.answer1) && Objects.equals(answer2, other.answer2)
				&& Objects.equals(answer3, other.answer3) && Objects.equals(answer4, other.answer4)
				&& Objects.equals(message, other.message);
	}
	@Override
	public int hashCode() {
		return Objects.hash(answer1, answer2, answer3, answer4, message);
	}
	@Override
	public String toString() {
		return  new StringBuilder()
		.append("AnwersSelectDTO [answer1=")
		.append(answer1)
		.append(", answer2=")
		.append(answer2)
		.append(", answer3=")
		.append(answer3)
		.append(", answer4=")
		.append(answer4)
		.append(", message=")
		.append(message)
		.append("]")
		.toString();
	}
}
