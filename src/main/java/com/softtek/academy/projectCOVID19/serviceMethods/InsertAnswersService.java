package com.softtek.academy.projectCOVID19.serviceMethods;

import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersSaveDTO;

public interface InsertAnswersService {
	boolean validateParameters(String params);
	boolean validateAnsw(String params);
	Object insertAns(AnswersSaveDTO ans);
}
