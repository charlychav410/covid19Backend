package com.softtek.academy.projectCOVID19.serviceMethods;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.AnswersREImpl;

@Service
public class SelectAnswersServiceImpl implements SelectAnswersService{
	
	@Autowired
	AnswersREImpl answersRep;
	
	public AnwersSelectDTO selectA(String is) {
		AnwersSelectDTO dto = answersRep.selectAnswers(is);
		String optionalValue = Optional.ofNullable(dto.getAnswer1()).orElse("");
		
		if(!optionalValue.isEmpty()) {
			dto.setMessage("Respuestas encontradas");
		}
		else {
			dto.setMessage("No se encontraron respuestas");
		}
		return dto;
	}

}
