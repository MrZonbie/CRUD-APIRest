package com.teste.primeiroexemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.teste.primeiroexemplo.model.error.ErrorMensage;
import com.teste.primeiroexemplo.model.exception.ResourcerNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourcerNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourcerNotFoundException ex){

		ErrorMensage error = new ErrorMensage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new  ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
  
}
