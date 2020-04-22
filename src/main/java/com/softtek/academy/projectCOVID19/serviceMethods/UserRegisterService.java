package com.softtek.academy.projectCOVID19.serviceMethods;

import com.softtek.academy.projectCOVID19.dataTransferObjects.UserRegisterDTO;

public interface UserRegisterService {

	boolean validateAllParameters(String params);
	
	Object userInsert(UserRegisterDTO userRegisterDTO);
	
}
