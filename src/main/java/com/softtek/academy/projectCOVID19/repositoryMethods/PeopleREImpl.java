package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.softtek.academy.projectCOVID19.common.Constants;
import com.softtek.academy.projectCOVID19.dataBaseEntities.People;
import com.softtek.academy.projectCOVID19.dataTransferObjects.MessageDTO;

@Configuration
@EntityScan("com.softtek.academy.projectCOVID19.*")
public class PeopleREImpl {

	@Autowired
	private PeopleRE peopleRe;

	@Autowired
	private Constants constants;
	
	private MessageDTO msg = new MessageDTO();
	private Gson gson = new Gson();
	
	public Object insertPeople(People person) {
		String response;
		try {
			if (!peopleRe.existsById(person.getIs())) {
				peopleRe.insertUserQ(person.getIs(), person.getName(), person.getLastName(), person.getLastNameM(),
						person.getEmail(), person.getPhone(), person.getUserPassword());
				msg.setMsg("1");
			//	response =gson.toJson(msg);
				return new Gson().toJson(msg);
				
			} else {
				msg.setMsg("0");
				//response =gson.toJson(msg);
				return new Gson().toJson(msg);  
			}
				
		} catch (Exception e) {
			msg.setMsg("0");
			//response =gson.toJson(msg);
			return new Gson().toJson(msg);  
		}
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

	public List<People> findAllPeople() {
		return (List<People>) peopleRe.findAll();
	}

	public String deletePeople() {
		return null;
	}

}
