package com.prueba.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	BigDecimal resultado;
	
	public double suma (double num1, double num2) {
		
		try {
			
			resultado = BigDecimal.valueOf(num1);
			resultado = resultado.add(BigDecimal.valueOf(num2));
			
		} catch (NumberFormatException nfe) {
			
			nfe.printStackTrace();
			return 0;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
			
		}
		
		return resultado.doubleValue();
		
	}
	
	public double resta (double num1, double num2) {
		try {
			
			resultado = BigDecimal.valueOf(num1);
			resultado = resultado.subtract(BigDecimal.valueOf(num2));
			
		} catch (NumberFormatException nfe) {
			
			nfe.printStackTrace();
			return 0;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
			
		}
		
		return resultado.doubleValue();
	}
}
