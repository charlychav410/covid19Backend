package com.softtek.academy.projectCOVID19.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.academy.projectCOVID19.functionalInterfaces.ParameterValidation;

@Component("validations")
public class Validations {

	@Autowired
	private Constants constantes;
	
	//Ejemplos de implementación de interfaces funcionales.
	public boolean validateIS(String isParam) {
		Pattern regexPattern = Pattern.compile(constantes.IS_REGEX);
		
		ParameterValidation parameterValidation = (parameter)->{
			boolean result = false;
			if(parameter !=null && !parameter.isEmpty()) {
				Matcher matcher = regexPattern.matcher(parameter);
				result = matcher.find();
			}
			
			return result;
		};
		return parameterValidation.validation(isParam);
	}
	
	public boolean validateName(String nameParam) {
		Pattern regexPattern = Pattern.compile(constantes.NAME_REGEX);
		ParameterValidation parameterValidation = (parameter)->{
			boolean result = false;
			if(parameter !=null && !parameter.isEmpty()) {
				Matcher matcher = regexPattern.matcher(parameter);
				result = matcher.find();
			}
			
			return result;
		};
		return parameterValidation.validation(nameParam);
	}
	
}
