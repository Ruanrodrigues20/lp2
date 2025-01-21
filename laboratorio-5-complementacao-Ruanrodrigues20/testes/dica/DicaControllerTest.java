package dica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import user.Usuario;

class DicaControllerTest {
	DicaController controller;

	@BeforeEach
	void initController() {
		controller = new DicaController();
	}

	@Test
	void testAdicionaDica() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		assertEquals(0, controller.adicionarDica(user, "12345678", "MONITORIA"));
	}
	
	@Test
	void testAdicionaDicaSenhaIncorreta() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarDica(user, "aaa", "MONITORIA");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaDicaTemaInvalido() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarDica(user, "12345678", "java");
		} catch (Exception e) {
			assertEquals("Tema inválido!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaDicaTemaValido() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		assertEquals(0, controller.adicionarDica(user, "12345678", "MONITORIA"));
	}
	
	@Test
	void testAdicionaDicaVariasDicas() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		assertEquals(0, controller.adicionarDica(user, "12345678", "MONITORIA"));
		assertEquals(1, controller.adicionarDica(user, "12345678", "PESQUISA EXTENSAO"));
		assertEquals(2, controller.adicionarDica(user, "12345678", "ESTAGIO"));
		assertEquals(3, controller.adicionarDica(user, "12345678", "REPRESENTACAO ESTUDANTIL"));
	}
	
	@Test
	void testAdicionaDicaExistente() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		assertEquals(0, controller.adicionarDica(user, "12345678", "MONITORIA"));
		assertEquals(-1, controller.adicionarDica(user, "12345678", "MONITORIA"));
		assertEquals(1, controller.adicionarDica(user, "12345678", "ESTAGIO"));
	}
	
	////////////////////////////////////////////////////////////////////////
	
	@Test
	void testAdiconaElementoTextoDicaInexistente() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdiconaElementoTextoDicaInexistente2() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoTextoDica(user, "12345678", -100, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdiconaElementoTextoDicaInexistente3() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoTextoDica(user, "12345678", 100, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoDica() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
	}
	
	@Test
	void testAdicionaElementoTextoDicaUserNull() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoTextoDica(null, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoDicaSenhaNull() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoTextoDica(user, null , 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoDicaSenhaInvalida() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoTextoDica(user, "12333", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

	@Test
	void testAdicionaElementoTextoDicaSenhaVazia() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoTextoDica(user, " ", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoUserIncorreto() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		Usuario user2 = new Usuario("Ruan", "12345678911", "12345678", "123210708");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoTextoDica(user2, "123", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

	@Test
	void testAdicionaElementoTextoUser() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
		assertTrue(controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom"));
	}
	
	@Test
	void testAdicionaElementoTextoUserTextoRepetido() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
		assertFalse(controller.adicionarElementoTextoDica(user, "12345678", 0, "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
	}
	
	//////////////////////////////////////////////
	@Test
	void testAdiconaElementoMultimidiaDicaInexistente() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdiconaElementoMultimidiaDicaInexistente2() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoMultimidiaDica(user, "12345678", -100, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdiconaElementoMultimidiaDicaInexistente3() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		try {
			controller.adicionarElementoMultimidiaDica(user, "12345678", 100, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Posição invalida!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaDica() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200));
	}
	
	@Test
	void testAdicionaElementoMultimidiaDicaUserNull() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoMultimidiaDica(null, "12345678", 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaDicaSenhaNull() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoMultimidiaDica(user, null, 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaDicaSenhaInvalida() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoMultimidiaDica(user, "12333", 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

	@Test
	void testAdicionaElementoMultimidiaDicaSenhaVazia() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoMultimidiaDica(user, " ", 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaUserIncorreto() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		Usuario user2 = new Usuario("Ruan", "12345678911", "12345678", "123210708");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		
		try {
			controller.adicionarElementoMultimidiaDica(user2, "12345678", 0, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

	@Test
	void testAdicionaElementoMultimidiaUser() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200));
		assertFalse(controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200));
	}
	
	@Test
	void testAdicionaElementoMultimidiaUserTextoRepetido() {
		Usuario user = new Usuario("Ruan", "123", "12345678", "123210");
		controller.adicionarDica(user, "12345678", "MONITORIA");
		assertTrue(controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200));
		assertFalse(controller.adicionarElementoMultimidiaDica(user, "12345678", 0, "link", "cabecalho", 200));
	}
}
