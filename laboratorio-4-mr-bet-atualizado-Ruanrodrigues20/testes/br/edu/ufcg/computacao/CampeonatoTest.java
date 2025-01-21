package br.edu.ufcg.computacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;

class CampeonatoTest {
	private Time time;
	private Campeonato camp;
	
	@BeforeEach
	void initCamp() {
		time = new Time("Flamengo", "002_RJ", "Urubu");
		camp = new Campeonato("Libertadores", 32);
	}
	
	@Test
	void testAdcionaTime() {
		assertTrue(camp.adicionaTime(time.getCodigo(), time));	
	}
	
	@Test
	void testAdcionaTimeRepetido() {
		assertTrue(camp.adicionaTime(time.getCodigo(), time));
		assertFalse(camp.adicionaTime(time.getCodigo(), time));	

	}
	
	@Test
	void testAdcionaTimeSemVaga() {
		camp = new Campeonato("Libertadores", 1);
		assertTrue(camp.adicionaTime(time.getCodigo(), time));
		assertFalse(camp.adicionaTime(time.getCodigo(), time));	
	}
	

	@Test
	void testTemTime() {
		camp.adicionaTime(time.getCodigo(), time);
		assertTrue(camp.temTime(time.getCodigo()));
	}
	
	@Test
	void testTemTimeSemTimeExistirNele() {
		assertFalse(camp.temTime(time.getCodigo()));
	}
	
	

}
