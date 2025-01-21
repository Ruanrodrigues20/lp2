package dica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Usuario;

class DicaTest {
	Dica dica;
	Usuario user;
	
	@BeforeEach
	void initDica() {
		user = new Usuario("Ruan", "123", "12345678", "123210");
		dica = new Dica(user, "Monitoria");
	}
	
	/////////////////////////////////////////////////////////////
	 
	@Test
	void testAdicionaElementoTexto() {
		assertTrue(dica.adicionarElementoTexto(user, "12345678", "texte"));
	}
	
	@Test
	void testAdicionaElementoTextoUserNull() {		
		try {
			dica.adicionarElementoTexto(null, "12345678", "texte");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoSenhaNull() {		
		try {
			dica.adicionarElementoTexto(user, null, "texte");
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	

	@Test
	void testAdicionaElementoTextoDicaSenhaInvalida() {
		
		try {
			dica.adicionarElementoTexto(user, "12333", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	

	@Test
	void testAdicionaElementoTextoDicaSenhaVazia() {
		
		try {
			dica.adicionarElementoTexto(user, " ", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTextoUserIncorreto() {
		Usuario user2 = new Usuario("Ruan", "12345678911", "12345678", "123210708");
		
		try {
			dica.adicionarElementoTexto(user2, "12345678", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar");
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoTexto1() {
		assertTrue(dica.adicionarElementoTexto(user, "12345678", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
		assertTrue(dica.adicionarElementoTexto(user, "12345678", "Java é muito bom"));
	}
	
	@Test
	void testAdicionaElementoTextoTextoRepetido() {
		assertTrue(dica.adicionarElementoTexto(user, "12345678", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
		assertFalse(dica.adicionarElementoTexto(user, "12345678", "Java é muito bom, só precisa estudar e ter foco que consegue desenrolar"));
	}
	
	////////////////////////////////////////////////////////////////////////
	
	
	@Test
	void testAdicionaElementoMultimida() {
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
	}
	
	
	@Test
	void testAdicionaElementoMultimidiaUserNull() {
		
		try {
			dica.adicionarElementoMultimidia(null, "12345678", "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaSenhaNull() {
		
		try {
			dica.adicionarElementoMultimidia(user, null, "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	

	@Test
	void testAdicionaElementoMultimidiaSenhaInvalida() {
		
		try {
			dica.adicionarElementoMultimidia(user, "125678", "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoMultimidiaSenhaVazia() {
		
		try {
			dica.adicionarElementoMultimidia(user, "", "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	
	@Test
	void testAdicionaElementoMultimidiaUserIncorreto() {
		Usuario user2 = new Usuario("Ruan", "12345678911", "12345678", "123210708");

		try {
			dica.adicionarElementoMultimidia(user2, "", "link", "cabecalho", 200);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	
	@Test
	void testAdicionaElementoMultimidia2() {
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho1", 200));
	}
	
	@Test
	void testAdicionaElementoMultimidiaRepetido() {
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho1", 200));
		assertFalse(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
		assertFalse(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho1", 200));
	}
	
	///////////////////////////////////////////////
	

	@Test
	void testAdicionaElementoReferenciaDica() {
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
	}
	
	@Test
	void testAdicionaElementoReferenciaUserNull() {
		try {
			dica.adicionarElementoReferencia(null, "12345678", 0, "estudo", "wikipedia", 2024, true, 5);		
		} catch (Exception e) {
			
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoReferenciaSenhaNull() {
		try {
			dica.adicionarElementoReferencia(user, null, 0, "estudo", "wikipedia", 2024, true, 5);
		} catch (Exception e) {
			assertEquals("Entrada Nula", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoReferenciaSenhaInvalida() {

		try {
			dica.adicionarElementoReferencia(user, "1321", 0, "estudo", "wikipedia", 2024, true, 5);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

 
	@Test
	void testAdicionaElementoReferenciaSenhaVazia() {
		try {
			dica.adicionarElementoReferencia(user, " ", 0, "estudo", "wikipedia", 2024, true, 5);
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaElementoReferenciaUserIncorreto() {
		Usuario user2 = new Usuario("Ruan", "12345678911", "12345678", "123210708");
		try {
			dica.adicionarElementoReferencia(user2, " ", 0, "estudo", "wikipedia", 2024, true, 5);	
		} catch (Exception e) {
			assertEquals("Usuario ou senha incorreta!", e.getMessage());
		}
	}

	@Test
	void testAdicionaElementoReferencia() {
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho", 200));
		assertTrue(dica.adicionarElementoMultimidia(user, "12345678", "link", "cabecalho1", 200));
	}
	
	@Test
	void testAdicionaElementoReferenciaoReferenciaRepetido() {
		assertTrue(dica.adicionarElementoReferencia(user, "12345678", 0, "estudo", "wikipedia", 2024, true, 5));
		assertFalse(dica.adicionarElementoReferencia(user, "12345678", 0, "estudo", "wikipedia", 2024, true, 5));
	}
	
}
