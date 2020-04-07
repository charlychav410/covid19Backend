package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;

public class UserRegisterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9175375315619314774L;

	private String is;
	private String password;
	private String name;
	private String firstLastName;
	private String secondLastName;
	private String email;
	private String phone;
	
	public String getIs() {
		return is;
	}
	
	public void setIs(String is) {
		this.is = is;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstLastName() {
		return firstLastName;
	}
	
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((is == null) ? 0 : is.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UserRegisterDTO other = (UserRegisterDTO) obj;
		if (is == null) {
			if (other.is != null)
				return false;
		} else if (!is.equals(other.is))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRegisterDTO [is=" + is + ", password=" + password + ", name=" + name + ", firstLastName="
				+ firstLastName + ", secondLastName=" + secondLastName + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
