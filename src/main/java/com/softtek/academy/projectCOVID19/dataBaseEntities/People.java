package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity 
@Table(name="PEOPLE")
public class People implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6955426189297132391L;

	@Id
    @Column(name = "[IS]")
	@Size(min = 4, max=5, message="Debe tener entre 4 y 5 caracteres")
	private String is;
	
	@Size(min = 1, max=30, message="Debe tener máximo 30 caracteres")
	@Column(name = "NAME")
	private String name;
	
	@Size(min = 1, max=30, message="Debe tener máximo 30 caracteres")
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Size(min = 1, max=30, message="Debe tener máximo 30 caracteres")
	@Column(name = "LAST_NAME_M")
	private String lastNameM;
	
	@Size(min = 1, max=30, message="Debe tener máximo 30 caracteres")
	@Column(name = "EMAIL")
	private String email;
	
	@Size(min = 1, max=10, message="Debe tener máximo 10 caracteres")
	@Column(name = "PHONE")
	private String phone;
	
	@Size(min = 1, max=40, message="Debe tener máximo 40 caracteres")
	@Column(name = "PASSWORD_P")
	private String userPassword;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "people", fetch = FetchType.LAZY)
	private List<Answers> answersList;

	public String getIs() {
		return is;
	}

	public void setIs(String is) {
		this.is = is;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastNameM() {
		return lastNameM;
	}

	public void setLastNameM(String lastNameM) {
		this.lastNameM = lastNameM;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Answers> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<Answers> answersList) {
		this.answersList = answersList;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(answersList, email, is, lastName, lastNameM, name, phone, userPassword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(answersList, other.answersList) && Objects.equals(email, other.email)
				&& Objects.equals(is, other.is) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(lastNameM, other.lastNameM) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(userPassword, other.userPassword);
	}
	@Override
	public String toString() {
		return new StringBuilder()
		.append("People [is=")
		.append(is)
		.append(", name=")
		.append(name)
		.append(", lastName=")
		.append(lastName)
		.append(", lastNameM=")
		.append(lastNameM)
		.append(", email=")
		.append(email)
		.append(", phone=")
		.append(phone)
		.append(", userPassword=")
		.append(userPassword)
		.append(", answersList=")
		.append(answersList)
		.append("]")
		.toString();
	}
}
