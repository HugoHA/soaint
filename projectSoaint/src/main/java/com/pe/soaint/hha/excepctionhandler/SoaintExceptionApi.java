package com.pe.soaint.hha.excepctionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.pe.soaint.hha.constants.Constants;


@ControllerAdvice
public class SoaintExceptionApi extends ResponseEntityExceptionHandler {

	private ErrorResponse errores = new ErrorResponse();
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensaje=Constants.MENSAJE_INVALIDO;
		String trazaMensaje=ex.getCause().toString();
		Error error =new Error(mensaje,trazaMensaje);
		errores.getErrores().add(error);		
		return handleExceptionInternal(ex, errores.getErrores(), headers, HttpStatus.BAD_REQUEST, request);  
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			String mensaje=messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String trazaMensaje=fieldError.toString();
			errores.getErrores().add(new Error(mensaje,trazaMensaje));
		}
		
		return handleExceptionInternal(ex, errores.getErrores(), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		
		String mensaje=Constants.RECURSO_NO_ENCONTRADO;
		String trazaMensaje=ex.getCause().toString();
		errores.getErrores().add(new Error(mensaje,trazaMensaje));
		
		return handleExceptionInternal(ex, errores.getErrores(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
