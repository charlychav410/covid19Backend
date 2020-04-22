package com.softtek.academy.projectCOVID19.serviceMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.CollaboratorDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.CollaboratorsDTO;
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

	public CollaboratorsDTO selectReportByStatus(String status) {
		CollaboratorsDTO dtoLst = new CollaboratorsDTO();
		List<CollaboratorDTO> lst = new ArrayList<>();
		Stream<Answers> answers4Stream = answersRep.selectAnswers4();
		
		answers4Stream.filter(ans -> ans.getQuestionDesc().equals(status))
		              .forEach(ans -> {		
		            	  CollaboratorDTO  dtoElmnt = new CollaboratorDTO(); 
		            	  String fullNam = ans.getPeople().getName()+" "+ 
		            			           ans.getPeople().getLastName()+" "+ 
		            			           ans.getPeople().getLastNameM();
		            	  dtoElmnt.setIs(ans.getPeople().getIs());
		            	  dtoElmnt.setFullName(fullNam);
		            	  dtoElmnt.setRespuesta4(ans.getQuestionDesc());
		            	  lst.add(dtoElmnt);
		              });
		dtoLst.setCollaboratorsLst(lst);
		return dtoLst;
	}

}