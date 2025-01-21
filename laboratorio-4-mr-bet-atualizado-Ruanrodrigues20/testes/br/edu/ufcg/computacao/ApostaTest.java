package br.edu.ufcg.computacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Aposta;
import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;

class ApostaTest {
	private Time time;
	private Campeonato camp;
	private Aposta aposta;
	
	@BeforeEach
	void intitTest() {
		time = new Time("Flamengo", "002_RJ", "Urubu");
		camp = new Campeonato("Libertadores", 32);
		camp.adicionaTime("002_RJ", time);
		aposta = new Aposta(time, camp, 1, 100);
		
	}
	
	@Test
	void testToString() {
		 String out = "[002_RJ] Flamengo / Urubu\n"
		            + "Libertadores\n"
		            + "1/32\n"
		            + "R$ 100,00";
		 assertEquals(out, aposta.toString());
		
	}

}
