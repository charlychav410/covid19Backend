package com.softtek.academy.projectCOVID19.common;

import org.springframework.stereotype.Component;

@Component("constants")
public class Constants {

	/*
	 * Regex constants
	 */
	public final String IS_REGEX = "[a-zA-Z]{3,5}";
	public final String NAME_REGEX = "[a-zA-Z]";
	public final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	public final String PSW_REGEX = "[a-zA-Z0-9]";
	
	/*
	 * People constants
	 */

	public final String SEPARATOR = ",";
	
	/*
	 * Login constants
	 */
	public final String NON_VALID = "ERROR";
	public final String VALID = "OK";
	
	/*
	 * answer constants
	 * */
	public final String RESP_EMPTY="";
}
