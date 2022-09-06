package com.prueba.calculadora.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraService {
	
	//TODO
	//@Autowired
	TracerImpl tracerImpl;

	BigDecimal resultado;
	
	private static final Logger logger = LoggerFactory.getLogger(CalculadoraService.class);
	
	/**
	 * Metodo que devuelve la suma de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return
	 */
	public double suma (double num1, double num2) {
			
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.add(BigDecimal.valueOf(num2));
		
		tracerImpl = new TracerImpl();
		tracerImpl.trace(resultado);
		
		logger.info("Traza: " + resultado);
		
		return resultado.doubleValue();
					
	}
	
	/**
	 * Metodo que devuelve la resta de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return
	 */
	public double resta (double num1, double num2) {
			
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.subtract(BigDecimal.valueOf(num2));
	
		tracerImpl = new TracerImpl();
		tracerImpl.trace(resultado);
		
		logger.info("Traza: " + resultado);
		
		return resultado.doubleValue();
			
	}
}
