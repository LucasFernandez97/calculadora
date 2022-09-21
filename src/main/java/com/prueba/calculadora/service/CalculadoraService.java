package com.prueba.calculadora.service;

import io.corp.calculator.TracerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraService {

	@Autowired
	private TracerImpl tracerImpl;

	private BigDecimal resultado;

	private static final Logger logger = LoggerFactory.getLogger(CalculadoraService.class);

	/**
	 * Metodo que devuelve la suma de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return resultado
	 */
	public double suma (double num1, double num2) {
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.add(BigDecimal.valueOf(num2));

		traceResult();

		return resultado.doubleValue();

	}

	/**
	 * Metodo que devuelve la resta de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return resultado
	 */
	public double resta (double num1, double num2) {

		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.subtract(BigDecimal.valueOf(num2));

		traceResult();

		return resultado.doubleValue();

	}

	/**
	 * Metodo que devuelve la multiplicacion de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return resultado
	 */
	public double multiplicacionSimple(double num1, double num2) {
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.multiply(BigDecimal.valueOf(num2));

		traceResult();

		return resultado.doubleValue();
	}

	/**
	 * Metodo que devuelve la division de dos parametros
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return resultado
	 */
	public double divisionSimple(double num1, double num2) {
		resultado = BigDecimal.valueOf(num1);
		resultado = resultado.divide(BigDecimal.valueOf(num2));

		traceResult();

		return resultado.doubleValue();
	}

	private void traceResult() {
		tracerImpl = new TracerImpl();
		tracerImpl.trace(this.resultado);

		logger.info("Traza: " + this.resultado);
	}
}
