package com.softtek.academy.projectCOVID19.dataTransferObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CollaboratorsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<CollaboratorDTO> colaboradores;

	public List<CollaboratorDTO> getCollaboratorsLst() {
		return colaboradores;
	}
	public void setCollaboratorsLst(List<CollaboratorDTO> collaboratorsLst) {
		this.colaboradores = collaboratorsLst;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(colaboradores);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollaboratorsDTO other = (CollaboratorsDTO) obj;
		return Objects.equals(colaboradores, other.colaboradores);
	}
	@Override
	public String toString() {
		return new StringBuilder()
		.append("Collaborators [collaboratorsLst=")
		.append(colaboradores)
		.append("]")
		.toString();
	}
}
