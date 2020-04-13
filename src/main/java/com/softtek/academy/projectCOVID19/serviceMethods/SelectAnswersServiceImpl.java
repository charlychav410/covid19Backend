package com.softtek.academy.projectCOVID19.serviceMethods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.AnswersRE;

@Service
public class SelectAnswersServiceImpl implements SelectAnswersService{
	
	@Autowired
	AnswersRE answersRep;
	
	public AnwersSelectDTO selectA(String is) {
		AnwersSelectDTO dto = new AnwersSelectDTO();
		List<Map<String, Object>> mapLst = answersRep.selectAnswers(is);
		
		if(!mapLst.isEmpty()) {
			System.out.println(mapLst.toString());
			dto.setMessage("Respuestas encontradas");
		}
		else {
			dto.setMessage("No se encontraron respuestas");
		}
		
		return dto;
	}

}
