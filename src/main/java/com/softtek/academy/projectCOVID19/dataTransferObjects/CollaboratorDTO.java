package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;
import java.util.Objects;

public class CollaboratorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String is;
	private String fullName;
	private String respuesta4;
	
	public String getIs() {
		return is;
	}
	public void setIs(String is) {
		this.is = is;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRespuesta4() {
		return respuesta4;
	}
	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fullName, is, respuesta4);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollaboratorDTO other = (CollaboratorDTO) obj;
		return Objects.equals(fullName, other.fullName) && Objects.equals(is, other.is)
				&& Objects.equals(respuesta4, other.respuesta4);
	}
	@Override
	public String toString() {
		return new StringBuilder()
		.append("Collaborator [is=")
		.append(is)
		.append(", fullName=")
		.append(fullName)
		.append(", respuesta4=")
		.append(respuesta4)
		.append("]")
		.toString();
	}
}
