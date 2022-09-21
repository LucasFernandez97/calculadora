package com.prueba.calculadora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void noHandlerFoundExceptionTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/asd",
				String.class)).contains("La pagina no existe");
	}
	
	@Test
	public void typeMismatchTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/suma?num1=asd&num2=2",
				String.class)).contains("Type mismatch");
	}
	
	@Test
	public void errorFormatoTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/suma?num1=1&num2=23423423454"
				+ "980895675675678678978908234234234546457568768678978980895675675678678978908234234234546457568768"
				+ "678978980895675675678678978908234234234546457568768678978980895675675678678978908234234234546457"
				+ "568768678978980895675675678678978908234234234546457568768678978980895675675678678978908234234234"
				+ "546457568768678978980895675675678678978908234234234546457568768678978980895675675678678978908234"
				+ "342345464575687686789789808956756756786789789082342342345464575687686789789808956756756786789789"
				+ "082342342345464575687686789789808956756756786789789082342342345464575687686789789808956756756786"
				+ "789789082342342345464575687686789789808956756756786789789082342342345464575687686789789808956756"
				+ "756786789789082342342345464575687686789789808956756756786789789082342342345464575687686789789808",
				String.class)).contains("Error de formato");
	}
	
	@Test
	public void faltaParametroSumaTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/suma?num2=123",
				String.class)).contains("123");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/suma?num1=123",
				String.class)).contains("123");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/suma",
				String.class)).contains("0");
	}
	
	@Test
	public void faltaParametroRestaTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/resta?num2=123",
				String.class)).contains("-123");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/resta?num1=123",
				String.class)).contains("123");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/resta",
				String.class)).contains("0");
	}
}
