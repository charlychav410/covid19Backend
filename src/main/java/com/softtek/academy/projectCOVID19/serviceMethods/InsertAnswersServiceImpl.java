package com.softtek.academy.projectCOVID19.serviceMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataBaseEntities.AnswersInsert;
import com.softtek.academy.projectCOVID19.dataBaseEntities.People;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersInsertDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.AnswersREImpl;

@Service
public class InsertAnswersServiceImpl implements InsertAnswersService{
	@Autowired
	private Validations validations;
	@Autowired
	private AnswersREImpl answerREImpl;
	@Override
	public boolean validateParameters(String params) {
		if(validations.validateAns(params)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean validateAnsw(String paramIs) {
		if(validateParameters(paramIs)) {
			return true;
		}
		return false;
	}

	@Override
	public String insertAns(AnswersInsertDTO ans) {
		AnswersInsert answersInsert=new AnswersInsert();
		answersInsert.setAnswerDate(ans.getDate());
		answersInsert.setQuestionDesc(ans.getAnswer());
		answersInsert.setIs(ans.getIs());
		answersInsert.setQuestions(Integer.parseInt(ans.getQuestion()));
		 return answerREImpl.insertAns(answersInsert);
		
	}
	
}
