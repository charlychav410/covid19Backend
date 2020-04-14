package com.softtek.academy.projectCOVID19.serviceMethods;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.AnswersRE;

@Service
public class SelectAnswersServiceImpl implements SelectAnswersService{
	
	@Autowired
	AnswersRE answersRep;
	
	public AnwersSelectDTO selectA(String is) {
		AnwersSelectDTO dto = new AnwersSelectDTO();
		Stream<Answers> answersStream = answersRep.findAllByIs(is);
		
//		answersStream.forEach((c)-> {
//		      
//		      System.out.printf(" %s", c.getQuestionDesc());
//		    });
		
		if(answersStream.count()>0) {

			dto.setMessage("Respuestas encontradas");
			
			
			
			
			
		}
		else {
			dto.setMessage("No se encontraron respuestas");
		}
		
		return dto;
	}

}
