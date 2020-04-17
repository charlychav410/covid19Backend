package com.softtek.academy.projectCOVID19.repositoryMethods;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.projectCOVID19.dataBaseEntities.AnswersInsert;
@Repository
public interface AnswersInsertRE extends CrudRepository<AnswersInsert,String> {

}
