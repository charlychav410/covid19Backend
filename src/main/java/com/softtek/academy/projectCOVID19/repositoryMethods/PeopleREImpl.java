package com.softtek.academy.projectCOVID19.repositoryMethods;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.softtek.academy.projectCOVID19.dataBaseEntities.People;


@Configuration
@EnableJpaRepositories
@EntityScan("com.softtek.academy.projectCOVID19.*") 
@Component("peopleREImpl")
public class PeopleREImpl {

	@Autowired
	private PeopleRE peopleRe;

	
	public String insertPeople() {
		
		return null;
	}
	
	public String updatePeople() {
		
		return null;
	}
	
	
	public People findByIdPeople(String is){
		People response;
		Optional<People> opPeople = peopleRe.findById(is);
		if(opPeople.isPresent()) {
			response = opPeople.get();
		}else {
			response = null;
		}
		
		return response;
	}
	
	public String findPeoplePsw(String is) {
		String pasword = peopleRe.findByIs(is);
		String psw = "";
		String[] byteResult = pasword.split(",");
		List<Integer> lista = new ArrayList<Integer>();
		for(String iteration:byteResult) {
			lista.add(Integer.parseInt(iteration.trim()));
		}
		try {
			for(Integer iteration:lista) {
				psw = psw + String.valueOf(iteration);
			}
			return psw;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public List<People> findAllPeople(){
		return (List<People>) peopleRe.findAll();
	}
	
	public String deletePeople() {
		return null;
	}
	
}
