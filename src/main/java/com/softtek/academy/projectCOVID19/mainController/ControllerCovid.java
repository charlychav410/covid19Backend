package com.softtek.academy.projectCOVID19.mainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.projectCOVID19.serviceMethods.SelectAnswersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.softtek.academy.projectCOVID19.common.Validations;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersInsertDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnswersSaveDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.LoginRequestDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.UserRegisterDTO;
import com.softtek.academy.projectCOVID19.serviceMethods.InsertAnswersService;
import com.softtek.academy.projectCOVID19.serviceMethods.UpdateAnswersService;
import com.softtek.academy.projectCOVID19.serviceMethods.UserLoginService;
import com.softtek.academy.projectCOVID19.serviceMethods.UserRegisterService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	String index() {
		return "Bienvenido equipo Backend proyecto COVID19";
	}

	@PostMapping(value = {
			"/login" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Object login(@RequestBody LoginRequestDTO loginRequestDTO) {
		return userLoginService.userLogin(loginRequestDTO.getIs(), loginRequestDTO.getPassword());
	}

	@PostMapping(value = {
			"/selectAnswers" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	public ResponseEntity<?> selectAnswers(@RequestBody String is) {
		AnwersSelectDTO dto = new AnwersSelectDTO();
		JsonObject jObj = new Gson().fromJson(is, JsonObject.class);

		if (validations.validateIS(jObj.get("is").getAsString())) {
			dto = selectAnswersService.selectA(jObj.get("is").getAsString());
		} else {
			dto.setMessage("IS incorrecto");
			return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = { "/userRegister" }, method = RequestMethod.POST)
	Object userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userRegisterService.userInsert(userRegisterDTO);
	}
	
	
	@RequestMapping(value = {"/insertAnswers"}, method = RequestMethod.POST)
	Object insertAnswers(@RequestBody AnswersSaveDTO answersInsertDTO) {
		
		return insertAnswersService.insertAns(answersInsertDTO);

	}
	@RequestMapping(value = { "/updateAnswers" }, method = RequestMethod.POST)
	String updateAnswers() {
		return "Servicio para actualizar respuestas";
	}
}
