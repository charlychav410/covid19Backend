package com.softtek.academy.projectCOVID19.serviceMethods;

import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersInsertDTO;

public interface InsertAnswersService {
	boolean validateParameters(String params);
	boolean validateAnsw(String params);
	String insertAns(AnswersInsertDTO ans);
}
