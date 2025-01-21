package br.edu.ufcg.computacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Time;

class TimeTest {
	private Time time;
	
	@BeforeEach
	void initTime() {
		time = new Time("Flamengo", "002_RJ", "Urubu");
	}
	
	@Test
	void testEqualsMesmoTime() {
		Time time2 = new Time("Flamengo", "002_RJ", "Urubu");
		assertTrue(time.equals(time2));
	}
	
	@Test
	void testEqualsNomeDiferente() {
		Time time2 = new Time("Flamengo-PI", "002_RJ", "Urubu");
		assertTrue(time.equals(time2));
	}
	
	@Test
	void testEqualsCodigoDiferente() {
		Time time2 = new Time("Flamengo", "003_RJ", "Urubu");
		assertFalse(time.equals(time2));
	}



}
