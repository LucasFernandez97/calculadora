package com.prueba.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.calculadora.service.CalculadoraService;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {
	
    private CalculadoraService calculadoraService;
    
    @BeforeEach
    void initUseCase() {
    	calculadoraService = new CalculadoraService();
    }
    
    @Test
    public void testSumaExito() {
    	
    	Assertions.assertEquals(calculadoraService.suma(1.0, 1.0), 2);
    }
    
    @Test
    public void testSumaFallo() {
    	
    	Assertions.assertNotEquals(calculadoraService.suma(1.0, 1.0), 3);
    }

}
