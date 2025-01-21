package user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerUserTest {
	public UsersController controller;
	
	@BeforeEach
	void initController() {
		this.controller = new UsersController();
	}
	
	@Test
	void criarEstudanteTest() {
		assertTrue(controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708"));
	}
	
	@Test
	void testcriarEstudanteExistente() {
		assertTrue(controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708"));
		assertFalse(controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708"));
	}
	
	@Test
	void testCriarEstudanteCpfDuplicado() {
		assertTrue(controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708"));
		assertFalse(controller.criarEstudante("André", "12345678911", "12345678", "123210708"));
	}
	
	@Test
	void testCriarEstudanteNomeNull(){
		try {
			controller.criarEstudante(null, "12345678911", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteCpfNull(){
		try {
			controller.criarEstudante("Ruan", null, "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteMatriculaNull(){
		try {
			controller.criarEstudante("Ruan", "12345678911", "javaeLindo", null);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteSenhaNull(){
		try {
			controller.criarEstudante("Ruan", "12345678911", null, "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	

	@Test
	void testCriarEstudanteTodosParametrosNull(){
		try {
			controller.criarEstudante(null, null, null, null);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteNomeVazio() {
		try {
			controller.criarEstudante("", "12345678911", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	

	@Test
	void testCriarEstudanteCpfVazio(){
		try {
			controller.criarEstudante("Ruan", "", "javaeLindo", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteMatriculaVazia(){
		try {
			controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testCriarEstudanteSenhaVazia(){
		try {
			controller.criarEstudante("Ruan", "12345678911", "", "123210708");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	

	@Test
	void testCriarEstudanteTodosParametrosVazios(){
		try {
			controller.criarEstudante("", "", "", "");
		} catch (Exception e) {
			assertEquals("Entrada Vazia", e.getMessage());
		}
	}
	
	@Test
	void testExibirEstudantesVazio() {
		String[] out = new String[0];
		assertArrayEquals(out, controller.exibirEstudantes());
	}
	

	@Test
	void testExibirEstudantes() {
		controller.criarEstudante("Ruan", "2", "javaeLindo", "2");
		controller.criarEstudante("Andre", "1", "12345678", "1");
		String[] out = { "Usuario = Andre, matricula = 1", "Usuario = Ruan, matricula = 2"};
		assertArrayEquals(out, controller.exibirEstudantes());
 	}
	
	@Test
	void testExibirEstudantesNomeParecido() {
		controller.criarEstudante("Andreia", "123456789", "12345678", "222111333");
		controller.criarEstudante("Andre", "1234567000", "12345678", "123456789");
		String[] out = { "Usuario = Andre, matricula = 123456789", "Usuario = Andreia, matricula = 222111333"};
		assertArrayEquals(out, controller.exibirEstudantes());
	}
	
	@Test
	void testAlterarSenhaEstudante() {
		controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708");
		assertTrue(controller.alterarSenhaEstudante("12345678911", "javaeLindo", "12345678"));
	}
	
	@Test
	void testAlterarSenhaEstudanteSenhaIncorreta() {
		controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708");
		assertFalse(controller.alterarSenhaEstudante("12345678911", "aa", "12345678"));
	}
	
	@Test
	void testAlterarSenhaEstudanteInexistente() {
		try {
			controller.alterarSenhaEstudante("12345678911", "javaeLindo", "12345678");			
		} catch (Exception e) {
			assertEquals("Usuario inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testGetUsuario() {
		controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708");
		Usuario user = new Usuario("Ruan", "12345678911", "javaeLindo", "123210708");
		assertEquals(user, controller.getUsuario("12345678911",  "javaeLindo"));
	}
	
	@Test
	void testGetUsuarioNull() {
		try {
			 controller.getUsuario("12345678911",  "javaeLindo");
		} catch (Exception e) {
			assertEquals("Usuario inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testGetUsuarioSenhaIncorreta() {
		controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708");
		try {
			 controller.getUsuario("12345678911",  "java");
		} catch (Exception e) {
			assertEquals("Senha errada", e.getMessage());
		}
	}
	
	@Test
	void testListarUsuariosRankingDicas() {
		controller.criarEstudante("Ruan", "12345678911", "javaeLindo", "123210708");
		controller.criarEstudante("Andre", "1", "12345678", "1");
		Usuario user1 = controller.getUsuario("12345678911", "javaeLindo") ;
		user1.aumentaBonus(10);
		Usuario user2 = controller.getUsuario("1", "12345678") ;
		user2.aumentaBonus(5);
		String u1 = user1.mostrarUserBonus();
		String u2 = user2.mostrarUserBonus();

		String[] out = {u2, u1};
		assertArrayEquals(out, controller.listarUsuariosRankingDicas());
	}
	
	
}
