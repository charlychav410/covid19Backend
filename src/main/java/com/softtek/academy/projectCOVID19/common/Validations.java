package com.softtek.academy.projectCOVID19.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.academy.projectCOVID19.functionalInterfaces.ParameterValidation;

@Component("validations")
public class Validations {

	@Autowired
	private Constants constants;
	
	//Validaciones que hacen uso de la interface funcional parameter validation.
	public boolean validateIS(String isParam) {
		Pattern regexPattern = Pattern.compile(constants.IS_REGEX);
		
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
		Pattern regexPattern = Pattern.compile(constants.NAME_REGEX);
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
	
	public boolean validateEmail(String nameParam) {
		Pattern regexPattern = Pattern.compile(constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
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
	
	public boolean validatePsw(String nameParam) {
		Pattern regexPattern = Pattern.compile(constants.PSW_REGEX);
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
	
	public boolean validatePhone(String nameParam) {
        Pattern regexPattern = Pattern.compile(constants.PHONE_REGEX);
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
