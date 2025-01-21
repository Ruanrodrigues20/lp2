package dica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TextoTest {
	Texto texto;
	
	
	@BeforeEach
	void init() {
		texto = new Texto("Ruan", "Java é legal");
	}
	
	@Test
	void testGetVisulizacao() {
		assertEquals("Java é legal", texto.getVisualizacao());
	}
	
	@Test
	void testGetVisulizacaoDetalhada() {
		assertEquals("Java é legal. (12 caracteres).", texto.getVisualizacaoDetalhada());
	}
	
	@Test
	void testGetPontos() {
		assertEquals(0, texto.getPontos());
	}
	
	@Test
	void testGetPontos2() {
		Texto t =new Texto("Ruan", "Leia a página de estágio antes de consultar a coordenação de estágio "
				+ "da UASC. Leia a página de estágio antes de consultar a coordenação de estágio \"\n"
				+ "da UASC.");
		assertEquals(15, t.getPontos());
	}
	
	
	
	 
}
