package user;

import java.time.LocalDate;
import java.util.HashMap; 

import java.util.Map;
import java.util.Objects;


import atividades.complemetares.Atividade;

/**
* Representa um usuário do sistema, contendo informações sobre suas atividades e créditos.
* @author Ruan Rodrigue da Silva
* 
*/

public class Usuario implements Comparable<Usuario>{
	private String nome;
	private String cpf;
	private String senha;
	private String matricula;
	private int bonus;
	private Map<String, Atividade> atvComplemenates;
	private int qtdAtvComplementares;
	private int creditoMonitoria;
	private int creditoEstagio;
	private int creditoPesquisaExtensao;
	private int creditoRepEstudantil;
	private final int CREDITOFINAL = 22;
	private final int CREDITOMONITORIAFINAL = 16;
	private final int CREDITOESTAGIOFINAL = 18;
	private final int CREDITOPESQUISAEXTENSAOFINAL = 2;
	private final int CREDITOREPRESENTACAOESTUDANTIL = 18;
	private Map<String, String> historicoRelatorio;
	
	/**
     * Construtor para criar um novo usuário.
     *
     * @param nome      O nome do usuário.
     * @param cpf       O CPF do usuário.
     * @param senha     A senha do usuário.
     * @param matricula A matrícula do usuário.
     */
	public Usuario(String nome, String cpf, String senha, String matricula) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.matricula = matricula;
		this.bonus = 0;
		this.atvComplemenates = new HashMap<>();
		this.qtdAtvComplementares = 0;
		this.creditoEstagio = 0;
		this.creditoPesquisaExtensao = 0;
		this.creditoMonitoria = 0;
		this.creditoRepEstudantil = 0;
		this.historicoRelatorio = new HashMap<>();
		excessao();
	}
	
	/**
     * Verifica se as entradas do usuário são válidas.
     *
     * @throws NullPointerException     Se algum dos atributos obrigatórios for nulo.
     * @throws IllegalArgumentException  Se a senha tiver menos de 8 caracteres.
     */
	private void excessao() {
		if(this.nome == null || this.cpf == null || this.senha == null || this.matricula == null) {
			throw new NullPointerException("Entrada Nula");
		}
		
		if(this.nome.isEmpty() || this.cpf.isEmpty() || this.senha.isEmpty() || this.matricula.isEmpty()) {
			throw new NullPointerException("Entrada Vazia");
		}
		
		if(this.senha.length() < 8) {
			throw new IllegalArgumentException("Tamanho da senha invalido");
		}
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Usuario = " + nome + ", cpf = " + cpf + ", matricula = " + matricula + ", bonus = "+ this.bonus;
	}
	
	@Override
	public int compareTo(Usuario user) {
		if(getBonus() > user.getBonus()) {
			return 1;
		} else if( getBonus() < user.getBonus()) {
			return -1;
		}
		return 0;
	}
	
	  /**
     * Exibe informações básicas do usuário.
     *
     * @return String representando o usuário.
     */
	public String mostrarUser() {
		return "Usuario = " + this.nome + ", matricula = " + matricula;
	}
	
    /**
     * Exibe informações do usuário, incluindo bônus.
     *
     * @return String representando o usuário com bônus.
     */
	public String mostrarUserBonus() {
		return "Usuario = " + this.nome + ", matricula = " + matricula + ", bonus = "+ this.bonus;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public int getCreditorMonitoria() {
		return creditoMonitoria;
	}

	public int getCreditoEstagio() {
		return creditoEstagio;
	}

	public int getCreditoPesquisaExtensao() {
		return creditoPesquisaExtensao;
	}

	public int getCreditorRepEstudantil() {
		return creditoRepEstudantil;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	  /**
     * Verifica se a meta de créditos foi alcançada.
     *
     * @return booelan se a meta foi alcançada; {@code false} caso contrário.
     */
	public boolean isMetaAlcanda() {
		return getCretidoTotal() == this.CREDITOFINAL;
	}
	

    /**
     * Aumenta o bônus do usuário.
     *
     * @param qtd A quantidade a ser adicionada ao bônus.
     */
	public void aumentaBonus(int qtd) {
		this.bonus += qtd;
	}
	
	/**
     * Obtém o total de créditos acumulados.
     *
     * @return Total de créditos.
     */
	public int getCretidoTotal() {
		return this.creditoEstagio + this.creditoPesquisaExtensao + this.creditoMonitoria + this.creditoRepEstudantil;
	}


	 /**
     * Verifica se a senha fornecida é igual à senha do usuário.
     *
     * @param senha A senha a ser verificada.
     * @return {@code true} se as senhas forem iguais; {@code false} caso contrário.
     */
	public boolean ehSenha(String senha) {
		return this.senha.equals(senha);
	}
	
	/**
     * Valida a senha do usuário.
     *
     * @param senha A senha a ser validada.
     * @throws IllegalArgumentException Se a senha estiver incorreta.
     */
	public void validaSenha(String senha) {
		if(!this.senha.equals(senha)) {
			throw new IllegalArgumentException("Senha incorreta!");
		}
	}
	
    /**
     * Troca a senha do usuário, se a senha antiga estiver correta.
     *
     * @param senhaAntiga A senha antiga do usuário.
     * @param novaSenha   A nova senha a ser definida.
     * @return {@code true} se a senha foi alterada com sucesso; {@code false} caso contrário.
     */

	public boolean trocarSenha(String senhaAntiga, String novaSenha) {
		if(ehSenha(senhaAntiga)) {
			this.senha = novaSenha;
			return true;
		}
		return false;
	}

	 /**
     * Adiciona uma atividade ao usuário.
     *
     * @param atv   A atividade a ser adicionada.
     * @param senha A senha do usuário.
     * @return O código da atividade adicionada.
     */
	public String adicionaAtividade(Atividade atv, String senha) {
		validaSenha(senha);
		String codigo = criarCodigo();
		this.atvComplemenates.put(codigo, atv);
		atv.setCodigo(codigo);
		if(this.CREDITOFINAL > this.getCretidoTotal()){
			atribuiCredito(atv);

		} 
		
		return codigo;
	}
	
	
	  /**
     * Altera a descrição de uma atividade existente.
     *
     * @param codigoAtividade O código da atividade a ser alterada.
     * @param descricao       A nova descrição da atividade.
     * @return {@code true} se a descrição foi alterada; {@code false} se a atividade não existir.
     */
	public boolean alteraDescricaoAtividade(String codigoAtividade, String descricao){
		if(!this.atvComplemenates.containsKey(codigoAtividade)) {
			return false;
		}
		
		this.atvComplemenates.get(codigoAtividade).alterarDescricao(descricao);
		return true;
	}
	
	 /**
     * Altera a comprovação de uma atividade existente.
     *
     * @param codigoAtividade O código da atividade a ser alterada.
     * @param linkComprovacao O novo link de comprovação.
     * @return {@code true} se a comprovação foi alterada; {@code false} se a atividade não existir.
     */
	public boolean alteraComprovacaoAtividade(String codigoAtividade, String linkComprovacao) {
		if(!this.atvComplemenates.containsKey(codigoAtividade)) {
			return false;
		}
		
		this.atvComplemenates.get(codigoAtividade).alterarComprovacao(linkComprovacao);
		return true;
	}
	
	/**
     * Obtém os créditos acumulados para um tipo específico de atividade.
     *
     * @param tipo O tipo da atividade.
     * @return O número de créditos acumulados para o tipo especificado.
     * @throws IllegalArgumentException Se o tipo da atividade não for válido.
     */
	public int creditosAtv(String tipo) {
		if(tipo.toUpperCase().equals("MONITORIA")) {
			return this.creditoMonitoria;
		}
		
		if(tipo.toUpperCase().equals("ESTAGIO")) {
			return this.creditoEstagio;
		}
		
		if(tipo.toUpperCase().equals("REPRESENTACAO ESTUDANTIL")) {
			return this.creditoRepEstudantil;
		}
		
		if(tipo.toUpperCase().equals("PESQUISA EXTENSAO")) {
			return this.creditoPesquisaExtensao;
		}
		
		throw new IllegalArgumentException("Tipo de atividade inexistente!");
	}
	
	/**
     * Gera um mapa de créditos do usuário.
     *
     * @return String representando os créditos totais e detalhados por tipo.
     */
	public String mapaCredito() {
		String out = "Creditos Totais: " + getCretidoTotal() + "/" + this.CREDITOFINAL + ". Creditos em MONITORIA: " + this.creditoMonitoria + "/" + this.CREDITOMONITORIAFINAL;
		out += ", creditos em ESTAGIO: " + this.creditoEstagio + "/" + this.CREDITOESTAGIOFINAL + ", creditos em REPRESENTACAO ESTUDANTIL: " + this.creditoRepEstudantil + "/" + this.CREDITOREPRESENTACAOESTUDANTIL;
		out += ", creditos em PESQUISA EXTENSAO: " + this.creditoPesquisaExtensao + "/" + this.CREDITOPESQUISAEXTENSAOFINAL + ".";
		return out;
	}
	
	
	/**
     * Adiciona um relatório ao histórico do usuário.
     *
     * @param relatorio O conteúdo do relatório.
     * @return O relatório adicionado.
     */
	public String addHistorico(String relatorio) {
		LocalDate data = LocalDate.now();
		this.historicoRelatorio.put(data.toString(), relatorio);
		return relatorio; 
	}
	
	/**
     * Gera um registro das atividades do usuário.
     *
     * @return Uma string contendo todas as atividades registradas.
     */
	public String geraRegistroAtividades() {
		if(this.atvComplemenates.size() == 0) {
			return "";
		}
		String registro = "";
		for(Atividade atv: this.atvComplemenates.values()) {
			registro += atv.toString() + "\n";
		}
		return registro.substring(0, registro.length() - 1);
	}
	
	   /**
     * Gera um registro das atividades do usuário filtrando por tipo.
     *
     * @param tipo O tipo da atividade a ser filtrada.
     * @return Uma string contendo as atividades do tipo especificado.
     */
	public String geraRegistroAtividades(String tipo) {
		
		String registro = "";
		for(Atividade atv: this.atvComplemenates.values()) {
			if(atv.getTipo().toUpperCase().contains(tipo.toUpperCase())) {
				registro += atv.toString() + "\n";
			}
		}
		if(registro.length() == 0) {
			return "";
		}
		return registro.substring(0, registro.length() - 1);
	}
	
	  /**
     * Lista o histórico de relatórios do usuário.
     *
     * @param senha A senha do usuário.
     * @return Uma string com todos os relatórios no histórico.
     * @throws IllegalArgumentException Se a senha estiver incorreta.
     */
	public String listarHistorico(String senha) {
		if(!ehSenha(senha)){
			throw new IllegalArgumentException("Senha inválida");
		}
		
		if(this.historicoRelatorio.size() == 0) {
			return "";
		}
		String out = "";
		for(String historico: this.historicoRelatorio.values()) {
			out += historico + "\n";
		}
		return out.substring(0, out.length() - 1);
	}
	
	
    /**
     * Exclui um item do histórico.
     *
     * @param senha A senha do usuário.
     * @param data  A data do item a ser excluído.
     * @return {@code true} se o item foi excluído; {@code false} caso contrário.
     */
	public boolean excluirItemHistorico(String senha, String data) {
		if(!ehSenha(senha)) {
			return false;
		}
		
		if(this.historicoRelatorio.containsKey(data)) {
			this.historicoRelatorio.remove(data);
			return true;
		}
		
		return false;
	}
	
	 /**
     * Cria um código único para a atividade.
     *
     * @return O código da atividade.
     */
	private String criarCodigo() {
		String codigo = this.cpf + "_" + this.qtdAtvComplementares;
		this.qtdAtvComplementares++;
		return codigo;
	}
	
	/**
     * Atribui créditos a uma atividade com base no seu tipo.
     *
     * @param atv A atividade para a qual os créditos serão atribuídos.
     */
	private void atribuiCredito(Atividade atv) {
	    String tipo = atv.getTipo().toUpperCase();
	    int creditos = atv.getCredito();

	    int totalAtual = getCretidoTotal();
	    int espacoDisponivel = this.CREDITOFINAL - totalAtual;

	    if (espacoDisponivel > 0) {
	        switch (tipo) {
	            case "MONITORIA":
	                atribuiCreditoMonitoria(Math.min(creditos, espacoDisponivel));
	                break; 
	            case "ESTAGIO":
	                atribuiCreditoEstagio(Math.min(creditos, espacoDisponivel));
	                break;
	            case "REPRESENTACAO ESTUDANTIL":
	                atribuiCreditoRepEstudantil(Math.min(creditos, espacoDisponivel));
	                break;
	            case "PESQUISA EXTENSAO":
	                atribuiCreditoPesquisaExtensao(Math.min(creditos, espacoDisponivel));
	                break;
	        }
	    }
	}
	
	/**
	 * Metodo que tem a logica para atribuir creditos relacionado a Monitoria
	 * @param creditos
	 */
	private void atribuiCreditoMonitoria(int creditos) {
	    if (this.creditoMonitoria + creditos <= this.CREDITOMONITORIAFINAL) {
	        this.creditoMonitoria += creditos;
	    }
	}
	
	/**
	 * Metodo que tem a logica para atribuir creditos relacionado a Estagio
	 * @param creditos
	 */
	private void atribuiCreditoEstagio(int creditos) {
	    if (this.creditoEstagio + creditos <= this.CREDITOESTAGIOFINAL) {
	        this.creditoEstagio += creditos;
	    }
	}
	
	/**
	 * Metodo que tem a logica para atribuir creditos relacionado a Representacao Estudantil
	 * @param creditos
	 */
	private void atribuiCreditoRepEstudantil(int creditos) {
	    if (this.creditoRepEstudantil + creditos <= this.CREDITOREPRESENTACAOESTUDANTIL) {
	        this.creditoRepEstudantil += creditos;
	    }
	}

	/**
	 * Metodo que tem a logica para atribuir creditos relacionado a Pesquisa e Extensão
	 * @param creditos
	 */
	private void atribuiCreditoPesquisaExtensao(int creditos) {
	    if (this.creditoPesquisaExtensao + creditos <= this.CREDITOPESQUISAEXTENSAOFINAL) {
	        this.creditoPesquisaExtensao += creditos;
	    }
	}
	
}