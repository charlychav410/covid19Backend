package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataBaseEntities.AnswersInsert;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.MessageDTO;


public class AnswersREImpl {
	
	@Autowired
	private AnswersRE answersRe ;
	@Autowired
	private AnswersInsertRE answersInsertRE;
	
	private MessageDTO msg = new MessageDTO();
	private Gson gson = new Gson();
	
	
	public AnwersSelectDTO selectAnswers(String paramIs) {
		LocalDate       localDate = LocalDate.now();
		AnwersSelectDTO dto = new AnwersSelectDTO();
		Stream<Answers> answerSelectedStream = answersRe.findAllByIs(paramIs);
		answerSelectedStream
		.filter(answer -> answer.getAnswerDate().toString().equals(localDate.toString()))
		.forEach(answ -> {
			switch (answ.getQuestions().getIdQuestion()) {
			case 1:
				dto.setAnswer1(answ.getQuestionDesc());break;
			case 2:
				dto.setAnswer2(answ.getQuestionDesc());break;
			case 3:
				dto.setAnswer3(answ.getQuestionDesc());break;
			case 4:
				dto.setAnswer4(answ.getQuestionDesc());break;
			default:
				break;
			}
		    });

		return dto;
	}
	@Modifying
	@Transactional
	public Object insertAns(AnswersInsert answer) {
		
		try {
			answersInsertRE.save(answer);
			msg.setMsg("1");
			return new Gson().toJson(msg);
			
		} catch (Exception e) {
			msg.setMsg("0");
			return new Gson().toJson(msg);
			
		}
		
	}
	

}
