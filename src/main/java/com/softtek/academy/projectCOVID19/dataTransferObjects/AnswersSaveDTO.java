package com.softtek.academy.projectCOVID19.dataTransferObjects;

public class AnswersSaveDTO {
	private String is;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private String respuesta4;
	public String getIs() {
		return is;
	}
	public void setIs(String is) {
		this.is = is;
	}
	public String getRespuesta1() {
		return respuesta1;
	}
	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}
	public String getRespuesta2() {
		return respuesta2;
	}
	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}
	public String getRespuesta3() {
		return respuesta3;
	}
	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}
	public String getRespuesta4() {
		return respuesta4;
	}
	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}
	@Override
	public String toString() {
		return "AnswersSaveDTO [is=" + is + ", respuesta1=" + respuesta1 + ", respuesta2=" + respuesta2
				+ ", respuesta3=" + respuesta3 + ", respuesta4=" + respuesta4 + "]";
	}
	


}
