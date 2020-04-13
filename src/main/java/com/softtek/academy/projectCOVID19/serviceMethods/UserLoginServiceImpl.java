package com.softtek.academy.projectCOVID19.serviceMethods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.softtek.academy.projectCOVID19.common.Constants;
import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataTransferObjects.LoginResponseDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.PeopleREImpl;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired 
	private PeopleREImpl peopleReImpl;
	
	@Autowired
	private Validations validations;
	
	@Autowired 
	private Constants constants;
	
	
	@Override
	public Object userLogin(String usr, String psw) {
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		if(validateParams(usr,psw)) {
			loginResponseDTO.setMsg(validatePsw(usr,psw));
		}else {
			loginResponseDTO.setMsg(constants.NON_VALID);
		}
			
		return new Gson().toJson(loginResponseDTO);
	}
	
	public boolean validateParams(String user, String pasword) {
		boolean result = false;
		if(validations.validateIS(user)&&validations.validatePsw(pasword)) {
			result = true;
		}
		
		return result;
	}
	
	public String validatePsw(String is, String psw) {
		String message;
		String separatePass = peopleReImpl.findPeoplePsw(is);
		
		
		if(separatePass!=null&&!separatePass.isEmpty()) {
			if(separatePass.equals(psw)) {
				message = constants.VALID;
			}
			else {
				message = constants.NON_VALID;
			}
		}
		else {
			message = constants.NON_VALID;
		}
		return message;
	}


	
}
