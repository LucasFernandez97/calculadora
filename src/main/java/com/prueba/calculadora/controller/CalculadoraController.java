package com.prueba.calculadora.controller;

import com.prueba.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;

	/**
	 * Endpoint para la suma
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return
	 */
	@GetMapping("/suma")
	public double sumaSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
	) {
		return calculadoraService.suma(num1, num2);
	}

	/**
	 * Endpoint para la resta
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return
	 */
	@GetMapping("/resta")
	public double restaSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
	) {
		return calculadoraService.resta(num1, num2);
	}

	/**
	 * Endpoint de multiplicacion
	 * @param num1 parametro numero 1
	 * @param num2 parametro numero 2
	 * @return
	 */
	@GetMapping("/multiplicacion")
	public double multiplicacionSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
	) {
		return calculadoraService.multiplicacionSimple(num1, num2);
	}

	/**
	 * Endpoint de division
	 * @param num1
	 * @param num2
	 * @return
	 */
	@GetMapping("/division")
	public double divisionSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
	) {
		return calculadoraService.divisionSimple(num1, num2);
	}
}
