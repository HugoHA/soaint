package com.pe.soaint.hha.excepctionhandler;

public class Error {
	private String mensaje;
	private String trazaMensaje;
	
	public Error() {
		
	}
	
	public Error(String mensaje, String trazaMensaje) {
		this.mensaje = mensaje;
		this.trazaMensaje = trazaMensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTrazaMensaje() {
		return trazaMensaje;
	}
	public void setTrazaMensaje(String trazaMensaje) {
		this.trazaMensaje = trazaMensaje;
	}
	
}
