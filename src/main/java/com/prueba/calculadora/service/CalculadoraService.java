package com.prueba.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	BigDecimal resultado;
	
	public double suma (double num1, double num2) {
					
		resultado = BigDecimal.valueOf(num1);
		return resultado.add(BigDecimal.valueOf(num2)).doubleValue();
					
	}
	
	public double resta (double num1, double num2) {
			
		resultado = BigDecimal.valueOf(num1);
		return resultado.subtract(BigDecimal.valueOf(num2)).doubleValue();
			
	}
}
