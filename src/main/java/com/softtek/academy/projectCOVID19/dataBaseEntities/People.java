package com.softtek.academy.projectCOVID19.dataBaseEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((is == null) ? 0 : is.hashCode());
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
		People other = (People) obj;
		if (is == null) {
			if (other.is != null)
				return false;
		} else if (!is.equals(other.is))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "People [is=" + is + ", name=" + name + ", lastName=" + lastName + ", lastNameM=" + lastNameM
				+ ", email=" + email + ", phone=" + phone + ", userPassword=" + userPassword + "]";
	}
	
	
	
}
