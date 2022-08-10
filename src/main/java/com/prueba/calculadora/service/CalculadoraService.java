package com.prueba.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraService {
	
	//TODO
	//@Autowired
	TracerImpl tracerImpl;

	BigDecimal resultado;
	
	public double suma (double num1, double num2) {
			
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.add(BigDecimal.valueOf(num2));
		
		tracerImpl = new TracerImpl();
		tracerImpl.trace(resultado);
		
		return resultado.doubleValue();
					
	}
	
	public double resta (double num1, double num2) {
			
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.subtract(BigDecimal.valueOf(num2));
	
		tracerImpl = new TracerImpl();
		tracerImpl.trace(resultado);
		
		return resultado.doubleValue();
			
	}
}
