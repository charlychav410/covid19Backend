package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import com.softtek.academy.projectCOVID19.common.Constants;
import com.softtek.academy.projectCOVID19.dataBaseEntities.People;

@Configuration
@EntityScan("com.softtek.academy.projectCOVID19.*")
public class PeopleREImpl {

	@Autowired
	private PeopleRE peopleRe;

	@Autowired
	private Constants constants;

	public String insertPeople(People person) {
		String response;
		try {
			if (!peopleRe.existsById(person.getIs())) {
				peopleRe.insertUserQ(person.getIs(), person.getName(), person.getLastName(), person.getLastNameM(),
						person.getEmail(), person.getPhone(), person.getUserPassword());
				response = "1";
			} else
				response = "0";
		} catch (Exception e) {
			response = "0";
		}
		return response;
	}

	public String updatePeople() {

		return null;
	}

	public People findByIdPeople(String is) {
		People response;
		Optional<People> opPeople = peopleRe.findById(is);
		if (opPeople.isPresent()) {
			response = opPeople.get();
		} else {
			response = null;
		}

		return response;
	}

	public String findPeoplePsw(String is) {
		String pasword = peopleRe.findByIs(is);
		String psw = new String();
		if(pasword==null) {
			return pasword;
		}else {
		String[] byteResult = pasword.split(constants.SEPARATOR);
		List<Integer> lista = new ArrayList<Integer>();
		for (String iteration : byteResult) {
			lista.add(Integer.parseInt(iteration.trim()));
		}
		try {
			for (Integer iteration : lista) {
				psw = psw + Character.toString((char) ((int) iteration));
			}
			return psw;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		}

	}

	public List<People> findAllPeople() {
		return (List<People>) peopleRe.findAll();
	}

	public String deletePeople() {
		return null;
	}

}
