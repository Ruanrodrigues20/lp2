package atividades.complemetares;

import user.Usuario;

/**
 * Controlador responsável por gerenciar as atividades complementares dos estudantes.
 * @author Ruan Rodrigues da Silva
 */
public class ControllerAtividadesComplementares {
    
    /**
     * Construtor padrão do controlador.
     */
    public ControllerAtividadesComplementares() {}

    /**
     * Cria uma atividade de monitoria para um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param tipo O tipo da atividade de monitoria.
     * @param unidadeAcumulada As unidades acumuladas para essa atividade.
     * @param disciplina A disciplina relacionada à monitoria.
     * @return Uma string que confirma a criação da atividade.
     */
    public String criarAtividadeMonitoriaEmEstudante(Usuario estudante, String senha, String tipo, int unidadeAcumulada, String disciplina) {
    	estudante.validaSenha(senha);
        Atividade atv = new Monitoria(tipo, unidadeAcumulada, disciplina);
        return estudante.adicionaAtividade(atv, senha);
    }

    /**
     * Cria uma atividade de pesquisa ou extensão para um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param tipo O tipo da atividade de pesquisa ou extensão.
     * @param unidadeAcumulada As unidades acumuladas para essa atividade.
     * @param subtipo O subtipo da atividade (pesquisa ou extensão).
     * @return Uma string que confirma a criação da atividade.
     */
    public String criarAtividadePesquisaExtensaoEmEstudante(Usuario estudante, String senha, String tipo, int unidadeAcumulada, String subtipo) {
    	estudante.validaSenha(senha);
        PesquisaExtensao atv1 = new PesquisaExtensao(tipo, unidadeAcumulada, subtipo);
        if(!atv1.isSubtipoValido()) {
        	return "ATIVIDADE NÃO CADASTRADA";
        }
        Atividade atv = atv1;
        return estudante.adicionaAtividade(atv, senha);
    }

    /**
     * Cria uma atividade de estágio para um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param tipo O tipo da atividade de estágio.
     * @param unidadeAcumulada As unidades acumuladas para essa atividade.
     * @param nomeEmpresa O nome da empresa onde o estágio é realizado.
     * @return Uma string que confirma a criação da atividade.
     */
    public String criarAtividadeEstagioEmEstudante(Usuario estudante, String senha, String tipo, int unidadeAcumulada, String nomeEmpresa) {
    	estudante.validaSenha(senha);
    	  if(unidadeAcumulada < 300) {
          	return "ATIVIDADE NÃO CADASTRADA";
          }
    	Atividade atv = new Estagio(tipo, unidadeAcumulada, nomeEmpresa);
        return estudante.adicionaAtividade(atv, senha);
    }

    /**
     * Cria uma atividade de representação estudantil para um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param tipo O tipo da atividade de representação estudantil.
     * @param unidadeAcumulada As unidades acumuladas para essa atividade.
     * @param subtipo O subtipo da representação estudantil.
     * @return Uma string que confirma a criação da atividade.
     */
    public String criarAtividadeRepresentacaoEstudantil(Usuario estudante, String senha, String tipo, int unidadeAcumulada, String subtipo) {
    	estudante.validaSenha(senha);

        Atividade atv = new RepresentacaoEstudantil(tipo, unidadeAcumulada, subtipo);
        return estudante.adicionaAtividade(atv, senha);
    }

    /**
     * Altera o link de comprovação de uma atividade de um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param codAtividade O código da atividade.
     * @param linkComprovacao O novo link de comprovação.
     * @return Um booleano indicando se a alteração foi bem-sucedida.
     */
    public boolean alterarComprovacaoAtividade(Usuario estudante, String senha, String codAtividade, String linkComprovacao) {
    	estudante.validaSenha(senha);
        return estudante.alteraComprovacaoAtividade(codAtividade, linkComprovacao);
    }

    /**
     * Altera a descrição de uma atividade de um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param codigoAtividade O código da atividade.
     * @param descricao A nova descrição da atividade.
     * @return Um booleano indicando se a alteração foi bem-sucedida.
     */
    public boolean alteraDescricaoAtividade(Usuario estudante, String senha, String codigoAtividade, String descricao) {
    	estudante.validaSenha(senha);
        return estudante.alteraDescricaoAtividade(codigoAtividade, descricao);
    }

    /**
     * Retorna a quantidade de créditos de uma atividade específica de um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @param tipo O tipo da atividade.
     * @return O número de créditos acumulados para a atividade.
     */
    public int creditosAtividade(Usuario estudante, String senha, String tipo) {
    	estudante.validaSenha(senha);

        return estudante.creditosAtv(tipo);
    }

    /**
     * Gera um mapa de créditos para as atividades de um estudante.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @return Uma string que representa o mapa de créditos do estudante.
     */ 
    public String gerarMapaCreditos(Usuario estudante, String senha) {
    	estudante.validaSenha(senha);
        return estudante.mapaCredito();
    }

    /**
     * Verifica se o estudante alcançou a meta de atividades complementares.
     * 
     * @param estudante O objeto Usuario que representa o estudante.
     * @param senha A senha do estudante para autenticação.
     * @return Um booleano indicando se a meta foi alcançada.
     */
    public boolean metaAlcancada(Usuario estudante, String senha) {
    	estudante.validaSenha(senha);
        return estudante.isMetaAlcanda();
    }
}