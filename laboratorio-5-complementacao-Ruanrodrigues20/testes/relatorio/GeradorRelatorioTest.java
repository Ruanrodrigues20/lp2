package relatorio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividades.complemetares.ControllerAtividadesComplementares;
import user.Usuario;

class GeradorRelatorioTest {
	GeradorRelatorio gerador;
	Usuario user;
	ControllerAtividadesComplementares controllerAtv;
	
	@BeforeEach
	void init() {
		gerador = new GeradorRelatorio();
		user = new Usuario("Ruan", "123456", "123456789", "123");
		controllerAtv = new ControllerAtividadesComplementares();
	}
	
	
	///////////////////////////////////////////////////////////////
	
	

	@Test
	void testGerarRelatorioFinalMetaNaoAlcancada() {
		assertEquals("Meta de créditos ainda não alcançada!", gerador.gerarRelatorioFinal(user));
	}
	
	@Test
	void testGerarRelatorioFinalMetaAlcancada() {
		controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
		controllerAtv.criarAtividadeRepresentacaoEstudantil(user, "123456789", "Representacao Estudantil", 2, "COMISSAO");
		controllerAtv.criarAtividadeEstagioEmEstudante(user, "123456789", "ESTAGIO", 300, "a");
		String out = user.toString() + ".\n" + user.geraRegistroAtividades() + ".\n"+ user.mapaCredito();
		assertEquals(out, gerador.gerarRelatorioFinal(user));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testGerarRelatorioFinalPorAtividadeMetaNaoAlcancada() {
	    assertEquals("Meta de créditos ainda não alcançada!", gerador.gerarRelatorioFinalPorAtividade(user, "monitoria"));
	}

	@Test
	void testGerarRelatorioFinalPorAtividadeMetaAlcancada() {
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
	    controllerAtv.criarAtividadeRepresentacaoEstudantil(user, "123456789", "Representacao Estudantil", 2, "COMISSAO");
	    controllerAtv.criarAtividadeEstagioEmEstudante(user, "123456789", "ESTAGIO", 300, "a");
	    String out = user.toString() + ".\n" + user.geraRegistroAtividades("monitoria") + ".\n" + user.mapaCredito();
	    
	    assertEquals(out, gerador.gerarRelatorioFinalPorAtividade(user, "monitoria"));
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testGerarRelatorioParcialSalvaNoHistorico() {
		String outAntes  = user.listarHistorico("123456789");
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
        gerador.gerarRelatorioParcial(user, true);
	    String outDepois = user.listarHistorico("123456789");
	    assertNotEquals(outAntes, outDepois);
	}
	
	@Test
	void testGerarRelatorioParcialNaoSalvaNoHistorico() {
		String outAntes  = user.listarHistorico("123456789");
	    controllerAtv.criarAtividadeMonitoriaEmEstudante(user, "123456789", "monitoria", 4, "P2");
        gerador.gerarRelatorioParcial(user, false);
	    String outDepois = user.listarHistorico("123456789");
	    
	    assertEquals(outAntes, outDepois);
	}
	
	////////////////////////////////////////////////////
	
	
	@Test
	void testGerarRelatorioParcialPorAtividadeSalvando() {
		String outAntes  = user.listarHistorico("123456789");
        gerador.gerarRelatorioParcialPorAtividade(user, true, "MONITORIA");
        String outDepois = user.listarHistorico("123456789");
        assertNotEquals(outAntes, outDepois);
	}
	
	@Test
	void testGerarRelatorioParcialPorAtividadeSemSalvando() {
		String outAntes  = user.listarHistorico("123456789");
        gerador.gerarRelatorioParcialPorAtividade(user, false, "MONITORIA");
        String outDepois = user.listarHistorico("123456789");
        assertEquals(outAntes, outDepois);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	

	@Test
	void testListarHistoricoPacialVazio() {
		assertEquals("", gerador.listarHistorico(user, "123456789")); 
	}
	
	@Test
	void testListarHistoricoPacialPorAtividadeVazio() {	
		assertEquals("", gerador.listarHistorico(user, "123456789")); 
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
		assertEquals(out, gerador.gerarRelatorioParcial(user, true)); 
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
		 gerador.gerarRelatorioParcial(user,  true);
		 String antes = gerador.listarHistorico(user, "123456789");
		 gerador.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		 assertNotEquals(antes, gerador.listarHistorico(user, "123456789"));
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
		
		 gerador.gerarRelatorioFinal(user);
		 gerador.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		 assertEquals("", gerador.listarHistorico(user, "123456789"));
	}
	
	@Test
	void testExcluirItemHistorico() {
		gerador.excluirItemHistorico(user, "123456789", LocalDate.now().toString());
		assertEquals("", gerador.listarHistorico(user, "123456789"));
	}
	

	
}
