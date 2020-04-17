package com.softtek.academy.projectCOVID19.serviceMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
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
		// TODO Auto-generated method stub
		if(validations.validateAns(params)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean validateAnsw(String paramIs) {
		answerREImpl.selectAnswers(paramIs);
		if(validateParameters(paramIs)) {
			return true;
		}
		return false;
	}

	@Override
	public String insertAns(AnswersInsertDTO ans) {
		People pe=new People();
		pe.setIs(ans.getIs());
		Answers re=new Answers();
		re.setAnswerDate(ans.getDate());
		re.setQuestionDesc(ans.getQuestion());
		re.setQuestionDesc(ans.getAnswer());
		re.setPeople(pe);
		
		try {
			if(validateAnsw(ans.getAnswer())) {
				return "1";
			}
			else
			return "0";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "0";
		}
		
		 
		
	}
	
}
