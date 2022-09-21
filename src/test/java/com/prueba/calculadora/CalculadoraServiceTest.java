package com.prueba.calculadora;

import com.prueba.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
    	Assertions.assertEquals(calculadoraService.suma(-1.0, 1.0), 0);
    	Assertions.assertEquals(calculadoraService.suma(1.0, -1.0), 0);
    	Assertions.assertEquals(calculadoraService.suma(-1.0, -1.0), -2.0);

    }
    
    @Test
    public void testSumaFallo() {
    	
    	Assertions.assertNotEquals(calculadoraService.suma(1.0, 1.0), 3);
    	Assertions.assertNotEquals(calculadoraService.suma(-1.0, 1.0), 3);
    	Assertions.assertNotEquals(calculadoraService.suma(1.0, -1.0), 5);
    	Assertions.assertNotEquals(calculadoraService.suma(-1.0, -1.0), -3.0);
    	
    }
    
    @Test
    public void testSumaErrorParametros() {
    	
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.suma(Double.parseDouble("a"), 1.0);});
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.suma(1.0, Double.parseDouble("a"));});
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.suma(Double.parseDouble("a"), Double.parseDouble("a"));});

    }
    
    @SuppressWarnings("null")
	@Test
    public void testSumaNull() {
    	
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.suma((Double) null, 1.0);});
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.suma(1.0, (Double) null);});
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.suma((Double) null, (Double) null);});

    }
    
    @Test
    public void testRestaExito() {
    	
    	Assertions.assertEquals(calculadoraService.resta(1.0, 1.0), 0);
    	Assertions.assertEquals(calculadoraService.resta(-1.0, 1.0), -2.0);
    	Assertions.assertEquals(calculadoraService.resta(1.0, -1.0), 2.0);
    	Assertions.assertEquals(calculadoraService.resta(-1.0, -1.0), 0);

    }
    
    @Test
    public void testRestaFallo() {
    	
    	Assertions.assertNotEquals(calculadoraService.resta(1.0, 1.0), 3);
    	Assertions.assertNotEquals(calculadoraService.resta(-1.0, 1.0), 3);
    	Assertions.assertNotEquals(calculadoraService.resta(1.0, -1.0), 5);
    	Assertions.assertNotEquals(calculadoraService.resta(-1.0, -1.0), -3.0);
    	
    }
    
    @Test
    public void testRestaErrorParametros() {
    	
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.resta(Double.parseDouble("a"), 1.0);});
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.resta(1.0, Double.parseDouble("a"));});
    	Assertions.assertThrows(NumberFormatException.class, () -> {calculadoraService.resta(Double.parseDouble("a"), Double.parseDouble("a"));});
    
    }

    @SuppressWarnings("null")
	@Test
    public void testRestaNull() {
    	
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.resta((Double) null, 1.0);});
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.resta(1.0, (Double) null);});
    	Assertions.assertThrows(NullPointerException.class, () -> {calculadoraService.resta((Double) null, (Double) null);});

    }
}
