package com.softtek.academy.projectCOVID19.serviceMethods;

import com.softtek.academy.projectCOVID19.dataTransferObjects.AnwersSelectDTO;
import com.softtek.academy.projectCOVID19.dataTransferObjects.CollaboratorsDTO;

/**
 * @author Bruno RGG
 *
 *Servicio para consultar las respuestas registradas anteriormente, dichas respuestas solo serán
 *del día en curso
 */
public interface SelectAnswersService {
	
	/**
	 * Método que se utiliza para realizar la búsqueda de las 4 respuestas del cuestionario, solo se podrán consultar
	 * las respuestas del día en curso 
	 * 
	 * @param: is - parametro que sirve para conformar el identificador y realizar la búsqueda de respuestas 
	 * @return: AnwersSelectDTO - Retorna dto con la información de las respuestas recuperadas de BD
	 */
	abstract AnwersSelectDTO selectA(String is);
	
	abstract CollaboratorsDTO selectReportByStatus(String status);
}
