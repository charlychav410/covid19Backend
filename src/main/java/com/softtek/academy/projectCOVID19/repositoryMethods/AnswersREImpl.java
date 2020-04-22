package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataBaseEntities.AnswersInsert;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;


public class AnswersREImpl {
	
	@Autowired
	private AnswersRE answersRe ;
	@Autowired
	private AnswersInsertRE answersInsertRE;
	
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
	
	public Stream<Answers> selectAnswers4(){
		return answersRe.findAllByAnswer4();
	}

	@Modifying
	@Transactional
	public String insertAns(AnswersInsert answer) {
		try {
			answersInsertRE.save(answer);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
	}
	

}
