package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;


public class AnswersREImpl {
	
	@Autowired
	private AnswersRE answersRe ;

	public AnwersSelectDTO selectAnswers(String paramIs) {
		LocalDate       localDate = LocalDate.now().minusDays(1);
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

}
