package com.softtek.academy.projectCOVID19.serviceMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataBaseEntities.People;
import com.softtek.academy.projectCOVID19.dataTransferObjects.UserRegisterDTO;
import com.softtek.academy.projectCOVID19.repositoryMethods.PeopleREImpl;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{

	@Autowired
	private Validations validations;
	
	@Autowired
	private PeopleREImpl peopleREImpl;
	
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
	public String userInsert(UserRegisterDTO userRegisterDTO) {
		String response;
		String is = userRegisterDTO.getIs();
		String name = userRegisterDTO.getName();
		String firstLastName = userRegisterDTO.getFirstLastName();
		String secondLastName = userRegisterDTO.getSecondLastName();
		String email = userRegisterDTO.getEmail();
		String phone = userRegisterDTO.getPhone();
		String password = userRegisterDTO.getPassword();
		
		System.out.println(userRegisterDTO);
		if(validations.validateIS(is) && validations.validateName(name) 
				&& validations.validateName(name) && validations.validateName(firstLastName) 
				&& validations.validateName(secondLastName) && validations.validateEmail(email) 
				&& validations.validatePsw(password) && validations.validatePhone(phone)) {
			People person = new People();
			person.setIs(is);
			person.setName(name);
			person.setLastName(firstLastName);
			person.setLastNameM(secondLastName);
			person.setEmail(email);
			person.setPhone(phone);
			person.setUserPassword(password);

			response = peopleREImpl.insertPeople(person);			
		}else 
			response = "0";
		
		return response;
	}

}
