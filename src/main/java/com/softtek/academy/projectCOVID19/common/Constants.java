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
	 * Coder-decoder constants
	 */
	public final String CODE_FORMAT = "UTF-8";
	public final String SHA = "SHA-1";
	public final String AES = "AES";
	public final int KEY_LENGTH= 16;
	public final String PADDING = "AES/ECB/PKCS5PADDING";
	public final String SECURE_KEY = "KEY";
	
	/*
	 * Login constants
	 */
	public final String NON_VALID = "ERROR";
	public final String VALID = "OK";
}
