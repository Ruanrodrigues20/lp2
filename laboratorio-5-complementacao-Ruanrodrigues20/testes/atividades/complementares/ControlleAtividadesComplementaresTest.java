package atividades.complementares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividades.complemetares.ControllerAtividadesComplementares;
import user.Usuario;

class ControlleAtividadesComplementaresTest {
	ControllerAtividadesComplementares controller;
	Usuario user;
	
	@BeforeEach
	void init() {
		controller = new ControllerAtividadesComplementares();
		user = new Usuario("Ruan", "12345678911", "javaeLindo", "123210708");

	}
	
	
	@Test
	void testcriarAtividadeMonitoriaEmEstudante() {
		assertEquals("12345678911_0", controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2"));
		assertEquals("12345678911_1", controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2"));
		assertEquals("12345678911_2", controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2"));
	}
	
	@Test
	void testcriarAtividadeMonitoriaEmEstudanteSenhaIncorreta() {
		try {
			controller.criarAtividadeMonitoriaEmEstudante(user, "jaaLindo", "monitoria", 1, "P2");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadeMonitoriaEmEstudanteUniContagemInvalida() {
		try {
			controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 0, "P2");
		} catch (Exception e) {
			assertEquals("Unidade de Contagem inválida!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadeMonitoriaEmEstudanteAttVazio() {
		try {
			controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "", 1, "P2");
		} catch (Exception e) {
			assertEquals("Atributo Vazio!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadeMonitoriaEmEstudanteNull() {
		try {
			controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", null, 1, "P2");
		} catch (Exception e) {
			assertEquals("Atributo Null!", e.getMessage());
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void testcriarAtividadePesquisaExtensaoEmEstudante() {
		assertEquals("12345678911_0", controller.criarAtividadePesquisaExtensaoEmEstudante(user, "javaeLindo", "PESQUISA EXTENSAO", 2, "PIBIC") );
	}
	
	@Test
	void testcriarAtividadePesquisaExtensaoEmEstudanteSenhaIncorreta() {
		try {
			controller.criarAtividadePesquisaExtensaoEmEstudante(user, "javaLindo", "PESQUISA EXTENSAO", 2, "PIBIC");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadePesquisaExtensaoEmEstudanteUniContagemInvalida() {
		try {
			controller.criarAtividadePesquisaExtensaoEmEstudante(user, "javaeLindo", "PESQUISA EXTENSAO", 0, "PIBIC");
		} catch (Exception e) {
			assertEquals("Unidade de Contagem inválida!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadePesquisaExtensaoEmEstudanteAttVazio() {
		try {
			controller.criarAtividadePesquisaExtensaoEmEstudante(user, "javaeLindo", "", 2, "PIBIC");
		} catch (Exception e) {
			assertEquals("Atributo Vazio!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadePesquisaExtensaoEmEstudanteNull() {
		try {
			controller.criarAtividadePesquisaExtensaoEmEstudante(user, "javaeLindo", null, 2, "PIBIC");
		} catch (Exception e) {
			assertEquals("Atributo Nulo!", e.getMessage());
		}
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoEmEstudanteSubtipoInvalida() {
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testcriarAtividadeEstagioEmEstudante() {
		assertEquals("12345678911_0", controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 300, "SPlab"));
	}

	@Test
	void testcriarAtividadeEstagioEmEstudanteSenhaIncorreta() {
		try {
			controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 300, "SPlab");
		} catch (Exception e) {
			assertEquals("Senha incorreta", e.getMessage());
		}
	}	

	@Test
	void testcriarAtividadeEstagioEmEstudanteUniContagemInvalida() {
		try {
			controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 30, "SPlab");
		} catch (Exception e) {
			assertEquals("Unidade de Contagem inválida!", e.getMessage());
		}
	}

	@Test
	void testcriarAtividadeEstagioEmEstudanteAttVazio() {
		try {
			controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 300, "");
		} catch (Exception e) {
			assertEquals("Atributo Vazio!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadeEstagioEmEstudanteNull() {
		try {
			controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 300, null);
		} catch (Exception e) {
			assertEquals("Atributo Nulo!", e.getMessage());
		}
	}	

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testcriarAtividadeRepresentacaoEstudantil() {
		assertEquals("12345678911_0",controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", "Representacao Estudantil", 2, "DIRETORIA"));
		assertEquals("12345678911_1",controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", "Representacao Estudantil", 2, "COMISSAO"));
	}

	@Test
	void testcriarAtividadeRepresentacaoEstudantilSenhaIncorreta() {
		try {
			controller.criarAtividadeRepresentacaoEstudantil(user, "javaLindo", "Representacao Estudantil", 2, "DIRETORIA");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}	

	@Test
	void testcriarAtividadeRepresentacaoEstudantilUniContagemInvalida() {
		try {
			controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", "Representacao Estudantil", 0, "DIRETORIA");
		} catch (Exception e) {
			assertEquals("Unidade de Contagem inválida!", e.getMessage());
		}
	}

	@Test
	void testcriarAtividadeRepresentacaoEstudantilAttVazio() {
		try {
			controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", "Representacao Estudantil", 2, "");
		} catch (Exception e) {
			assertEquals("Atributo Vazio!", e.getMessage());
		}
	}
	
	@Test
	void testcriarAtividadeRepresentacaoEstudantilNull() {
		try {
			controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", null, 2, "DIRETORIA");
		} catch (Exception e) {
			assertEquals("Atributo Nulo!", e.getMessage());
		}
	}	

	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testAlterarComprovacao() {
		controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2");
		assertTrue(controller.alterarComprovacaoAtividade(user, "javaeLindo", "12345678911_0", "link test"));
	}
	

	@Test
	void testAlterarComprovacaoAtividadeNaoExiste() {
		assertFalse(controller.alterarComprovacaoAtividade(user, "javaeLindo", "12345678911_0", "link test"));
	}
	
	@Test
	void testAlterarDescricao() {
		controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2");
		assertTrue(controller.alteraDescricaoAtividade(user, "javaeLindo", "12345678911_0", "link test"));
	}
	

	@Test
	void testAlterarDescricaoAtividadeNaoExiste() {
		assertFalse(controller.alteraDescricaoAtividade(user, "javaeLindo", "12345678911_0", "link test"));
	}
	
	@Test
	void testAlaerarDescricaoSenhaIncorreta() {
		try {
			controller.alteraDescricaoAtividade(user, "d", "1", "1");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	@Test
	void testAlaerarComprovacaoSenhaIncorreta() {
		try {
			controller.alterarComprovacaoAtividade(user, "d", "1", "1");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testCreditoAtividade() {
		controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 1, "P2");
		assertEquals(4, controller.creditosAtividade(user, "javaeLindo", "MONITORIA"));
	}
	
	
	@Test
	void testCreditoAtividadeSemAtividades(){
		assertEquals(0, controller.creditosAtividade(user, "javaeLindo", "MONITORIA"));
	}
	
	
	@Test
	void testCreditoAtividadeSenhaIncorreta() {
		try {
			controller.creditosAtividade(user, "s", "Monitoria");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	void testMetaAlcancada() {
		controller.criarAtividadeMonitoriaEmEstudante(user, "javaeLindo", "monitoria", 4, "P2");
		controller.criarAtividadeRepresentacaoEstudantil(user, "javaeLindo", "Representacao Estudantil", 2, "COMISSAO");
		controller.criarAtividadeEstagioEmEstudante(user, "javaeLindo", "ESTAGIO", 300, "a");
		assertTrue(controller.metaAlcancada(user, "javaeLindo"));
	}
	
	@Test
	void testMetaAlcancadaNao() {
		assertFalse(controller.metaAlcancada(user, "javaeLindo"));
	}
	
	@Test
	void testMetaAlcancadaSenhaErrada() {
		try {
			controller.metaAlcancada(user, "aaaaaaaaaaaaaa");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	
	
	
	
}	
