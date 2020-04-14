package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable{

	private static final long serialVersionUID = 6369401213825991421L;
	
	private String is;
	private String password;
	
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((is == null) ? 0 : is.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		LoginRequestDTO other = (LoginRequestDTO) obj;
		if (is == null) {
			if (other.is != null)
				return false;
		} else if (!is.equals(other.is))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [is=" + is + ", password=" + password + "]";
	}
	
	
}
