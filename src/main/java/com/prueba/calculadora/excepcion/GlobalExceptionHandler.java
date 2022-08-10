package com.prueba.calculadora.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleFormatException() {
        return new ResponseEntity<>("Error de formato", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll() {
        
        return new ResponseEntity<>("La calculadora se ha freido", HttpStatus.BAD_REQUEST);
    }
}
