package com.prueba.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.service.CalculadoraService;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;
	
	@GetMapping("/suma")
	public double sumaSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
			) {
		return calculadoraService.suma(num1, num2);
	}
	
	@GetMapping("/resta")
	public double restaSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num2", defaultValue = "0") double num2
			) {
		return calculadoraService.resta(num1, num2);
	}
	
	/**
	 * TODO implementacion de multiplicacion
	 * @param num1
	 * @param num2
	 * @return
	 */
	@GetMapping("/multiplicacion")
	public double multiplicacionSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num1", defaultValue = "0") double num2
			) {
		return 0;
	}
	
	/**
	 * TODO implementacion de division
	 * @param num1
	 * @param num2
	 * @return
	 */
	@GetMapping("/division")
	public double divisionSimple(
			@RequestParam(value = "num1", defaultValue = "0") double num1,
			@RequestParam(value = "num1", defaultValue = "0") double num2
			) {
		return 0;
	}
}
