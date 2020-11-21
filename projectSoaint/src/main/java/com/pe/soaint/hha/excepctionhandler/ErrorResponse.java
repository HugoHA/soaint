package com.pe.soaint.hha.excepctionhandler;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	
	private String codigo;
	private List<Error> errores;
	
	public ErrorResponse() {
		errores = new ArrayList<Error>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCode(String codigo) {
		this.codigo = codigo;
	}
	public List<Error> getErrores() {
		return errores;
	}
	public void setErrores(List<Error> errores) {
		this.errores = errores;
	}
	
	

}
