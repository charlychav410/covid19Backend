package com.softtek.academy.projectCOVID19.serviceMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataTransferObjects.UserRegisterDTO;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{

	@Autowired
	private Validations validations;
	
	
	//Método de ejemplo, es necesario adecuar la lógica a los parámetros reales
	@Override
	public boolean validateAllParameters(String params) {
		boolean result = false;
		String is = "SBCD";
		String name = "Juanito";
		if(validations.validateIS(is)&&validations.validateName(name)) {
			result = true;
		}

		return result;
	}


	@Override
	public String userInsert(UserRegisterDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

}
