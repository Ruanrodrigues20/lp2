package relatorio;

import user.Usuario;

/**
 * Classe responsável por gerar relatórios de atividades dos usuários.
 * @author Ruan Rodrigues da Silva
 */
public class GeradorRelatorio {
    
    /**
     * Construtor da classe GeradorRelatorio.
     */
    public GeradorRelatorio() {
    }

    /**
     * Gera um relatório final para o usuário.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @return Uma string contendo o relatório final ou uma mensagem de erro se a meta não foi alcançada.
     */
    public String gerarRelatorioFinal(Usuario user) {
        if (!user.isMetaAlcanda()) {
            return "Meta de créditos ainda não alcançada!";
        }
        String out  = user.toString() + ".\n" + user.geraRegistroAtividades() + ".\n" + user.mapaCredito();
        return user.addHistorico(out);
    }

    /**
     * Gera um relatório final filtrado por tipo de atividade.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param tipoAtividade O tipo de atividade a ser filtrado no relatório.
     * @return Uma string contendo o relatório final filtrado ou uma mensagem de erro se a meta não foi alcançada.
     */
    public String gerarRelatorioFinalPorAtividade(Usuario user, String tipoAtividade) {
        if (!user.isMetaAlcanda()) {
            return "Meta de créditos ainda não alcançada!";
        }
        
        String out  = user.toString() +  ".\n" + user.geraRegistroAtividades(tipoAtividade) + ".\n" + user.mapaCredito(); 
        return user.addHistorico(out); 
    }

    /**
     * Gera um relatório parcial das atividades do usuário.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param salvar Indica se o relatório deve ser salvo no histórico.
     * @return Uma string contendo o relatório parcial.
     */
    public String gerarRelatorioParcial(Usuario user, boolean salvar) {
        String out  = user.toString() + ".\n" + user.geraRegistroAtividades() + ".\n" + user.mapaCredito();
        if (salvar) {
            return user.addHistorico(out);
        }
        return out;
    }

    /**
     * Gera um relatório parcial filtrado por tipo de atividade.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param salvar Indica se o relatório deve ser salvo no histórico.
     * @param tipoAtividade O tipo de atividade a ser filtrado no relatório.
     * @return Uma string contendo o relatório parcial filtrado.
     */
    public String gerarRelatorioParcialPorAtividade(Usuario user, boolean salvar, String tipoAtividade) {
        String out  = user.toString() +  ".\n" + user.geraRegistroAtividades(tipoAtividade) + ".\n" + user.mapaCredito(); 
        if (salvar) {
            return user.addHistorico(out);
        }
        return out;
    }

    /**
     * Lista o histórico de relatórios do usuário.
     *
     * @param user O usuário cujo histórico será listado.
     * @param senha A senha do usuário para validação.
     * @return Uma string contendo o histórico de relatórios.
     */
    public String listarHistorico(Usuario user, String senha) {
        return user.listarHistorico(senha);
    }

    /**
     * Exclui um item do histórico do usuário.
     *
     * @param user O usuário cujo histórico será alterado.
     * @param senha A senha do usuário para validação.
     * @param data A data do item a ser excluído.
     * @return true se o item foi excluído com sucesso, false caso contrário.
     */
    public boolean excluirItemHistorico(Usuario user, String senha, String data) {
        return user.excluirItemHistorico(senha, data);
    }
}
