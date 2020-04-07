package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.List;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;


public interface PeopleRE {
	
	List<Answers> selectAnswers(String parameter);
	
	String insertAnswers(String answers);
	
	String updateAnswers(String answers);

}
