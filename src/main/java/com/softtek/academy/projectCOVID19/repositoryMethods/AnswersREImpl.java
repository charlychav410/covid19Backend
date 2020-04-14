package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;


public class AnswersREImpl {
	
	@Autowired
	private AnswersRE answersRe ;

	public Stream<Answers> selectAnswers(String paramIs) {
		return answersRe.findAllByIs(paramIs);
	}

}
