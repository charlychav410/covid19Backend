package com.softtek.academy.projectCOVID19.serviceMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;
import com.softtek.academy.projectCOVID19.dataBaseEntities.AnswersInsert;
import com.softtek.academy.projectCOVID19.dataBaseEntities.People;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersInsertDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersSaveDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.MessageDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.AnswersREImpl;

@Service
public class InsertAnswersServiceImpl implements InsertAnswersService{
	@Autowired
	private Validations validations;
	@Autowired
	private AnswersREImpl answerREImpl;
	
	
	private MessageDTO msg = new MessageDTO();
	private Gson gson = new Gson();
	
	
	
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
	public Object insertAns(AnswersSaveDTO ans) {
	
		AnswersInsert answersInsert=new AnswersInsert();
		 LocalDate localDate = LocalDate.now();
		    Date date = java.sql.Date.valueOf(localDate);
		//mapeo de la base de datos 
		try {
			if(validateAnsw(ans.getRespuesta1()) && validateAnsw(ans.getRespuesta2())
					&& validateAnsw(ans.getRespuesta3()) && validateAnsw(ans.getRespuesta4()) == true	) {
				
			
			answersInsert.setIs(ans.getIs());
			answersInsert.setAnswerDate(date);
			answersInsert.setQuestionDesc(ans.getRespuesta1());
			answersInsert.setQuestions(1);
			answerREImpl.insertAns(answersInsert);
			
			
			answersInsert.setIs(ans.getIs());
			answersInsert.setAnswerDate(date);
			answersInsert.setQuestionDesc(ans.getRespuesta2());
			answersInsert.setQuestions(2);
			answerREImpl.insertAns(answersInsert);
			
			answersInsert.setIs(ans.getIs());
			answersInsert.setAnswerDate(date);
			answersInsert.setQuestionDesc(ans.getRespuesta3());
			answersInsert.setQuestions(3);
			answerREImpl.insertAns(answersInsert);
			
			answersInsert.setIs(ans.getIs());
			answersInsert.setAnswerDate(date);
			answersInsert.setQuestionDesc(ans.getRespuesta4());
			answersInsert.setQuestions(4);
			answerREImpl.insertAns(answersInsert);
			
			
			msg.setMsg("1");
			return new Gson().toJson(msg);
			}else {
				msg.setMsg("0");
				return new Gson().toJson(msg);
			}
			
		} catch (Exception e) {
			msg.setMsg("0");
			return new Gson().toJson(msg);
		}
		
		
		
	}
	
}
