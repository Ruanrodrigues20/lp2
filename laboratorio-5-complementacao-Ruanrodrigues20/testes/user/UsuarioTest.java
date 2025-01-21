package user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Usuario user;
	
	@BeforeEach
	void initUser() {
		user = new Usuario("Ruan", "12345678911", "javaeLindo", "123210708");
	}
	
	@Test
	void testCriarEstudanteNomeNull(){
		try {
			Usuario user2 = new Usuario(null, "12345678911", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteCpfNull(){ 
		try {
			Usuario user2 = new Usuario("Ruan", null, "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteMatriculaNull(){
		try {
			Usuario user2 = new Usuario("Ruan", "12345678911", "javaeLindo", null);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteSenhaNull(){
		try {
			Usuario user2 = new Usuario("Ruan", "12345678911", null, "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	} 
	

	@Test
	void testCriarEstudanteTodosParametrosNull(){
		try {
			Usuario user2 = new Usuario(null, null, null, null);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteNomeVazio() {
		try {
			Usuario user2 = new Usuario("", "12345678911", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	

	@Test
	void testCriarEstudanteCpfVazio(){
		try {
			Usuario user2 = new Usuario("Ruan", "", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteMatriculaVazia(){
		try {
			Usuario user2 = new Usuario("Ruan", "12345678911", "javaeLindo", "");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteSenhaVazia(){
		try {
			Usuario user2 = new Usuario("Ruan", "12345678911", "", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	

	@Test
	void testCriarEstudanteTodosParametrosVazios(){
		try {
			Usuario user2 = new Usuario("", "", "", "");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testMostrarUser() {
		String out = "Usuario = Ruan, matricula = 123210708";
		assertEquals(out, user.mostrarUser());
	}
	
	@Test
	void testMostrarUserBonus() {
		String out = "Usuario = Ruan, matricula = 123210708, bonus = 0";
		assertEquals(out, user.mostrarUserBonus());
	}
	
	@Test
	void testValidaSenha() {
		assertTrue(user.ehSenha("javaeLindo"));
	}
	
	@Test
	void testValidaSenhaIncorreta() {
		assertFalse(user.ehSenha("java"));
	}
	
	@Test
	void testTrocarSenha() {
		assertTrue(user.trocarSenha("javaeLindo", "aa"));
	}
	
	@Test
	void testTrocarSenhaIncorreta() {
		assertFalse(user.trocarSenha("aa", "aa"));
	}
	
	
	

}
