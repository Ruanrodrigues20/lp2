package relatorio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividades.complemetares.Atividade;
import atividades.complemetares.ControllerAtividadesComplementares;
import user.Usuario;

class RelatorioControllerTest {
	RelatorioController controller;
	Usuario user;
	ControllerAtividadesComplementares controllerAtv;
	
	@BeforeEach
	void init() {
		controller = new RelatorioController();
		user = new Usuario("Ruan", "123456", "123456789", "123");
		controllerAtv = new ControllerAtividadesComplementares();
	}
	
	
	///////////////////////////////////////////////////////////////
	
	@Test
	void testGerarRelatorioFinalSenhaIncorreta() {
		try {
			controller.gerarRelatorioFinal(user, "12356789");
		} catch (Exception e) {
			assertEquals("Senha incorreta!", e.getMessage());
		}
	}
	

	@Test
	void testGerarRelatorioFinalMetaNaoAlcancada() {
		assertEquals("Meta de créditos ainda não alcançada!", controller.gerarRelatorioFinal(user, "123456789"));
	}
	
	@Test
	void testGerarRelatorioFinalMetaAlcancada() {
		controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
		controllerAtv.criarAtividadeRepresentacaoEstudantil(user, "123456789", "Representacao Estudantil", 2, "COMISSAO");
		controllerAtv.criarAtividadeEstagioEmEstudante(user, "123456789", "ESTAGIO", 300, "a");
		String out = user.toString() + ".\n" + user.geraRegistroAtividades() + ".\n"+ user.mapaCredito();
		assertEquals(out, controller.gerarRelatorioFinal(user, "123456789"));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testGerarRelatorioFinalPorAtividadeSenhaIncorreta() {
	    try {
	        controller.gerarRelatorioFinalAtividades(user, "monitoria", "12356789");
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}

	@Test
	void testGerarRelatorioFinalPorAtividadeMetaNaoAlcancada() {
	    assertEquals("Meta de créditos ainda não alcançada!", controller.gerarRelatorioFinalAtividades(user, "123456789", "monitoria"));
	}

	@Test
	void testGerarRelatorioFinalPorAtividadeMetaAlcancada() {
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
	    controllerAtv.criarAtividadeRepresentacaoEstudantil(user, "123456789", "Representacao Estudantil", 2, "COMISSAO");
	    controllerAtv.criarAtividadeEstagioEmEstudante(user, "123456789", "ESTAGIO", 300, "a");
	    String out = user.toString() + ".\n" + user.geraRegistroAtividades("monitoria") + ".\n" + user.mapaCredito();
	    
	    assertEquals(out, controller.gerarRelatorioFinalAtividades(user, "123456789","monitoria"));
	}
	
	//////////////////////////////////////////////////////////////////////////////
	@Test
	void testGerarRelatorioParcialSenhaIncorreta() {
	    try {
	        controller.gerarRelatorioParcial(user, "12356789", true);
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}
	

	@Test
	void testGerarRelatorioParcialSalvaNoHistorico() {
		String outAntes  = user.listarHistorico("123456789");
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
        controller.gerarRelatorioParcial(user, "123456789", true);
	    String outDepois = user.listarHistorico("123456789");
	    assertNotEquals(outAntes, outDepois);
	}
	
	@Test
	void testGerarRelatorioParcialNaoSalvaNoHistorico() {
		String outAntes  = user.listarHistorico("123456789");
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
        controller.gerarRelatorioParcial(user, "123456789", false);
	    String outDepois = user.listarHistorico("123456789");
	    
	    assertEquals(outAntes, outDepois);
	}
	
	/////////////////////////////////////////////////////
	
	@Test
	void gerarRelatorioParcialPorAtividadeMonitoriaSenhaIncorreta() {
		try {
	        controller.gerarRelatorioFinalAtividades(user, "12378140", "MONITORIA");
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}
	
	@Test
	void gerarRelatorioParcialPorAtividadeEstagioSenhaIncorreta() {
		try {
	        controller.gerarRelatorioFinalAtividades(user, "12378140", "ESTAGIO");
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}
	
	@Test
	void gerarRelatorioParcialPorAtividadeProjetoExtensaoSenhaIncorreta() {
		try {
	        controller.gerarRelatorioFinalAtividades(user, "12378140", "PROJETO EXTENSAO");
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}
	
	@Test
	void gerarRelatorioParcialPorAtividadeRepresentacaoEstudantilSenhaIncorreta() {
		try {
	        controller.gerarRelatorioFinalAtividades(user, "12378140", "REPRESENTACAO ESTUDANTIL");
	    } catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
	    }
	}
	
	
	@Test
	void testGerarRelatorioParcialPorAtividadeSalvando() {
		String outAntes  = user.listarHistorico("123456789");
        controller.gerarRelatorioParcialPorAtividade(user, "123456789", true, "MONITORIA");
        String outDepois = user.listarHistorico("123456789");
        assertNotEquals(outAntes, outDepois);
	}
	
	@Test
	void testGerarRelatorioParcialPorAtividadeSemSalvando() {
		String outAntes  = user.listarHistorico("123456789");
        controller.gerarRelatorioParcialPorAtividade(user, "123456789", false, "MONITORIA");
        String outDepois = user.listarHistorico("123456789");
        assertEquals(outAntes, outDepois);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	
	@Test
	void testListarHistoricoSenhaIncorreta() {
		try {
			controller.listarHistorico(user, "1111111111");
		} catch (Exception e) {
	        assertEquals("Senha incorreta!", e.getMessage());
		}
		
	}
	
	@Test
	void testListarHistoricoPacialVazio() {
		assertEquals("", controller.listarHistorico(user, "123456789")); 
	}
	
	@Test
	void testListarHistoricoPacialPorAtividadeVazio() {	
		assertEquals("", controller.listarHistorico(user, "123456789")); 
	}
	
	@Test
	void testListarHistoricoParcial() {
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
		String out = "Usuario = Ruan, cpf = 123456, matricula = 123, "
				+ "bonus = 0.\nMonitoria [disciplina= P2, descricao= sem descrição, "
				+ "codigo= 123456_0, tipo= monitoria, unidadeContagem= 4, "
				+ "creditos= 16, linkComprovacao= sem link].\n"
				+ "Creditos Totais: 16/22. Creditos em MONITORIA: 16/16, "
				+ "creditos em ESTAGIO: 0/18, creditos em REPRESENTACAO ESTUDANTIL: 0/18, "
				+ "creditos em PESQUISA EXTENSAO: 0/2.";
		assertEquals(out, controller.gerarRelatorioParcial(user, "123456789", true)); 
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	
	void testExcluirItemHistoricoRelatorioParcial() {
		 controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
			String out = "Usuario = Ruan, cpf = 123456, matricula = 123, "
					+ "bonus = 0.\nMonitoria [disciplina= P2, descricao= sem descrição, "
					+ "codigo= 123456_0, tipo= monitoria, unidadeContagem= 4, "
					+ "creditos= 16, linkComprovacao= sem link].\n"
					+ "Creditos Totais: 16/22. Creditos em MONITORIA: 16/16, "
					+ "creditos em ESTAGIO: 0/18, creditos em REPRESENTACAO ESTUDANTIL: 0/18, "
					+ "creditos em PESQUISA EXTENSAO: 0/2.";
		 controller.gerarRelatorioParcial(user, "123456789", true);
		 String antes = controller.listarHistorico(user, "123456789");
		 controller.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		 assertNotEquals(antes, controller.listarHistorico(user, "123456789"));
	}
	
	
	@Test
	void testExcluirItemHistoricoRelatorioFinal() {
		controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
		controllerAtv.criarAtividadeRepresentacaoEstudantil(user, "123456789", "Representacao Estudantil", 2, "COMISSAO");
		controllerAtv.criarAtividadeEstagioEmEstudante(user, "123456789", "ESTAGIO", 300, "a");
		
		String	 out = "Usuario = Ruan, cpf = 123456, matricula = 123, "
					+ "bonus = 0.\nMonitoria [disciplina= P2, descricao= sem descrição, "
					+ "codigo= 123456_0, tipo= monitoria, unidadeContagem= 4, "
					+ "creditos= 16, linkComprovacao= sem link].\n"
					+ "Creditos Totais: 16/22. Creditos em MONITORIA: 16/16, "
					+ "creditos em ESTAGIO: 0/18, creditos em REPRESENTACAO ESTUDANTIL: 0/18, "
					+ "creditos em PESQUISA EXTENSAO: 0/2.";
		
		 controller.gerarRelatorioFinal(user, "123456789");
		 controller.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		 assertEquals("", controller.listarHistorico(user, "123456789"));
	}
	
	@Test
	void testExcluirItemHistorico() {
		controller.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		assertEquals("", controller.listarHistorico(user, "123456789"));
	}
	

	
	
	
}
