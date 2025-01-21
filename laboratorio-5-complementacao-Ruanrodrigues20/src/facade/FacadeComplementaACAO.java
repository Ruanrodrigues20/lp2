package facade;


import atividades.complemetares.ControllerAtividadesComplementares;
import dica.DicaController;
import relatorio.RelatorioController;
import user.UsersController;

public class FacadeComplementaACAO {
	private UsersController controllerUsers;
	private DicaController controllerDicas;
	private ControllerAtividadesComplementares controllerAtividades;
	private RelatorioController relatorioController;
	
	public FacadeComplementaACAO() {
		this.controllerUsers = new UsersController();
		this.controllerDicas = new DicaController();
		this.controllerAtividades = new ControllerAtividadesComplementares();
		this.relatorioController = new RelatorioController();
	}
	
	public boolean criarEstudante(String nome, String cpf, String senh, String matricula) {
		return this.controllerUsers.criarEstudante(nome, cpf, senh, matricula);
	}
		
	public String[] exibirEstudantes() {
		return this.controllerUsers.exibirEstudantes();
	}
	
	public boolean alterarSenhaEstudante(String cpf, String senhaAntiga, String novaSenha) {
		return this.controllerUsers.alterarSenhaEstudante(cpf, senhaAntiga, novaSenha);
	}
	
	public int adicionarDica(String cpf, String senha, String tema) {
		return this.controllerDicas.adicionarDica(this.controllerUsers.getUsuario(cpf, senha), senha, tema);
	}
	
	public boolean adicionarElementoTextoDica(String cpf, String senha, int posicao, String texto) {
		return this.controllerDicas.adicionarElementoTextoDica(this.controllerUsers.getUsuario(cpf, senha), senha, posicao, texto);
	}
	
	public boolean adicionarElementoMultimidiaDica(String cpf, String senha, int posicao, String link, String cabecalho, int tempo) {
		return this.controllerDicas.adicionarElementoMultimidiaDica(this.controllerUsers.getUsuario(cpf, senha), senha, posicao, link, cabecalho, tempo);
	}
	
	public boolean adicionarElementoReferenciaDica(String cpf, String senha, int posicao,  String título, String fonte, int ano, boolean conferida, int importancia) {
		return this.controllerDicas.adicionarElementoReferenciaDica(this.controllerUsers.getUsuario(cpf, senha), senha, posicao, título, fonte, ano, conferida, importancia);
	}
	
	public String[] listarDicas() {
		return this.controllerDicas.listarDicas();
	}
	
	public String [] listarDicasDetalhes() {
		return this.controllerDicas.listarDicasDetalhes();
	}
	
	public String listarDica(int posicao) {
		return this.controllerDicas.listarDica(posicao);
	}
	
	public String listarDicaDetalhes(int posicao) {
		return this.controllerDicas.listarDicaDetalhes(posicao);
	}
	
	//Creio que está certo
	public String[] listarUsuariosRankingDicas() {
		return this.controllerUsers.listarUsuariosRankingDicas();
	}

	public String criarAtividadeMonitoriaEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
		return this.controllerAtividades.criarAtividadeMonitoriaEmEstudante(this.controllerUsers.getUsuario(cpf, senha), senha, tipo, unidadeAcumulada, disciplina);
	}
	
	public boolean alterarDescricaoAtividade(String cpf, String senha, String codigoAtividade, String descricao) {
		return this.controllerAtividades.alteraDescricaoAtividade(this.controllerUsers.getUsuario(cpf, senha), senha, codigoAtividade, descricao);
	}
	
	public boolean alterarComprovacaoAtividade(String cpf, String senha, String codigoAtividade, String linkComprovacao) {
		return this.controllerAtividades.alterarComprovacaoAtividade(this.controllerUsers.getUsuario(cpf, senha),senha, codigoAtividade, linkComprovacao);
	}
	
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String subtipo) {
		return this.controllerAtividades.criarAtividadePesquisaExtensaoEmEstudante(this.controllerUsers.getUsuario(cpf, senha), senha,tipo, unidadeAcumulada, subtipo);
	}
	
	public String criarAtividadeEstagioEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String nomeEmpresa) {
		return this.controllerAtividades.criarAtividadeEstagioEmEstudante(this.controllerUsers.getUsuario(cpf, senha), senha, tipo, unidadeAcumulada, nomeEmpresa);
	}
	
	public String criarAtividadeRepresentacaoEstudantil(String cpf, String senha, int unidadeAcumulada, String subtipo) {
		return this.controllerAtividades.criarAtividadeRepresentacaoEstudantil(this.controllerUsers.getUsuario(cpf, senha),senha, subtipo, unidadeAcumulada, subtipo);
	}
	
	public int creditosAtividade(String cpf, String senha, String tipo) {
		return this.controllerAtividades.creditosAtividade(this.controllerUsers.getUsuario(cpf, senha), senha, tipo);
	}
	
	public String gerarMapaCreditosAtividades(String cpf, String senha) {
		return this.controllerAtividades.gerarMapaCreditos(this.controllerUsers.getUsuario(cpf, senha), senha);
	}
	
	public boolean verificarMetaAlcancada(String cpf, String senha) {
		return this.controllerAtividades.metaAlcancada(this.controllerUsers.getUsuario(cpf, senha), senha);
	}

	public String gerarRelatorioFinal(String cpf, String senha) {
		return this.relatorioController.gerarRelatorioFinal(this.controllerUsers.getUsuario(cpf, senha), senha);
	}
	
	public String gerarRelatorioFinalPorAtividade(String cpf, String senha, String tipoAtividade) {
		return this.relatorioController.gerarRelatorioFinalAtividades(this.controllerUsers.getUsuario(cpf, senha), senha, tipoAtividade);
	}
	
	public String gerarRelatorioParcial(String cpf, String senha, boolean salvar) {
		return this.relatorioController.gerarRelatorioParcial(this.controllerUsers.getUsuario(cpf, senha), senha, salvar);
	}
	
	public String gerarRelatorioParcialPorAtividade(String cpf, String senha, boolean salvar, String tipoAtividade) {
		return this.relatorioController.gerarRelatorioParcialPorAtividade(this.controllerUsers.getUsuario(cpf, senha), senha, salvar, tipoAtividade);
	}
	
	public String listarHistorico(String cpf, String senha) {
		return this.relatorioController.listarHistorico(this.controllerUsers.getUsuario(cpf, senha), senha);
	}
	
	public boolean excluirItemHistorico(String cpf, String senha, String data) {
		return this.relatorioController.excluirItemHistorico(this.controllerUsers.getUsuario(cpf, senha), senha, data);
	}


}
