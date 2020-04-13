package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2049148246931461002L;

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
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
		LoginResponseDTO other = (LoginResponseDTO) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginResponseDTO [msg=" + msg + "]";
	}
	
	
}
