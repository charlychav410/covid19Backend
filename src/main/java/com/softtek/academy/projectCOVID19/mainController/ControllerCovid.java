package com.softtek.academy.projectCOVID19.mainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.projectCOVID19.serviceMethods.SelectAnswersService;
import com.softtek.academy.projectCOVID19.serviceMethods.InsertAnswersService;
import com.softtek.academy.projectCOVID19.serviceMethods.UpdateAnswersService;
import com.softtek.academy.projectCOVID19.serviceMethods.UserLoginService;
import com.softtek.academy.projectCOVID19.serviceMethods.UserRegisterService;

@RestController
@EnableAutoConfiguration
public class ControllerCovid {
	
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private UserRegisterService userRegisterService;
	@Autowired
	private UpdateAnswersService updateAnswersService;
	@Autowired
	private InsertAnswersService insertAnswersService;
	@Autowired
	private SelectAnswersService selectAnswersService;
	
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	String index() {
		return "Bienvenido equipo Backend proyecto COVID19";
	}
	
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Object login(@RequestParam("is") String is, @RequestParam("password") String password ) {
		return userLoginService.userLogin(is, password);
	}
	
	
	@RequestMapping(value = {"/selectAnswers"}, method = RequestMethod.POST)
	String selectAnswers() {
		return "Servicio para obtener el número de ingresos por día del usuario";
	}
	
	
	@RequestMapping(value = {"/userRegister"}, method = RequestMethod.POST)
	String userRegister() {
		return "Servicio para registrar usuarios "+userRegisterService.validateAllParameters("params");
	}
	
	
	@RequestMapping(value = {"/insertAnswers"}, method = RequestMethod.POST)
	String insertAnswers() {
		return "Servicio para insertar respuestas";
	}
	
	
	@RequestMapping(value = {"/updateAnswers"}, method = RequestMethod.POST)
	String updateAnswers() {
		return "Servicio para actualizar respuestas";
	}
	

}
