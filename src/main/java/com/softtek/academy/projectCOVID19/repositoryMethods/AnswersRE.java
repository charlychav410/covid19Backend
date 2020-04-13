package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.List;
import java.util.Map;

public interface AnswersRE {
	
	List<Map<String, Object>> selectAnswers(String paramIs);
	
	String insertAnswers(String answers);
	
	String updateAnswers(String answers);
	
}
