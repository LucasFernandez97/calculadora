package com.prueba.calculadora.excepcion;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleFormatException(HttpServletRequest req, Exception ex) {
		logger.error("Request: " + req.getRequestURL() + " ,Error: " + ex);
        return new ResponseEntity<>("Error de formato", HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity <Object> handleCustomAPIException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest req) {
    
		logger.error("Error: " + ex);
        return new ResponseEntity<>("La calculadora se ha freido", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity <Object> resourceNotFoundException(ResourceNotFoundException ex) {
    	logger.error(ex.getMessage());
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Bind error", HttpStatus.BAD_REQUEST);
    }

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage());
        return new ResponseEntity<>("Type mismatch", HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage());
		return new ResponseEntity<>("La pagina no existe", HttpStatus.NOT_FOUND);
	}
   
}
