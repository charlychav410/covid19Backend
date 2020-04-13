package com.softtek.academy.projectCOVID19.mainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.projectCOVID19.serviceMethods.SelectAnswersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
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
	@Autowired
	private Validations validations;
	
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	String index() {
		return "Bienvenido equipo Backend proyecto COVID19";
	}
	
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Object login(@RequestParam("is") String is, @RequestParam("password") String password ) {
		return userLoginService.userLogin(is, password);
	}
	
	
	@PostMapping(value = {"/selectAnswers"},
			     consumes = MediaType.APPLICATION_JSON_VALUE,
			     produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> selectAnswers(@RequestBody String is) {
		AnwersSelectDTO dto = new AnwersSelectDTO();
		JsonObject jObj = new Gson().fromJson(is, JsonObject.class);
		
		if(validations.validateIS(jObj.get("is").getAsString())) {
			dto = selectAnswersService.selectA(is);
		}else {
			dto.setMessage("IS incorrecto");
			return new ResponseEntity<>(dto,HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
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
