package relatorio;

import user.Usuario;

/**
 * Classe responsável por gerenciar a geração de relatórios de atividades de usuários.
 *  @author Ruan Rodrigues da Silva
 */
public class RelatorioController {
    private GeradorRelatorio geradorRelatorio;
    
    /**
     * Construtor da classe RelatorioController.
     * Inicializa o gerador de relatórios.
     */
    public RelatorioController() {
        this.geradorRelatorio = new GeradorRelatorio();
    }
    
    /**
     * Gera um relatório final para o usuário, validando a senha.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param senha A senha do usuário para validação.
     * @return Uma string contendo o relatório final.
     */
    public String gerarRelatorioFinal(Usuario user, String senha) {
        user.validaSenha(senha);
        return this.geradorRelatorio.gerarRelatorioFinal(user);
    }
    
    /**
     * Gera um relatório final filtrado por tipo de atividade, validando a senha.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param senha A senha do usuário para validação.
     * @param tipoAtividade O tipo de atividade a ser filtrado no relatório.
     * @return Uma string contendo o relatório final filtrado.
     */
    public String gerarRelatorioFinalAtividades(Usuario user, String senha, String tipoAtividade) {
        user.validaSenha(senha);
        return this.geradorRelatorio.gerarRelatorioFinalPorAtividade(user, tipoAtividade);
    }
    
    /**
     * Gera um relatório parcial das atividades do usuário, validando a senha.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param senha A senha do usuário para validação.
     * @param salvar Indica se o relatório deve ser salvo no histórico.
     * @return Uma string contendo o relatório parcial.
     */
    public String gerarRelatorioParcial(Usuario user, String senha, boolean salvar) {
        user.validaSenha(senha);
        return this.geradorRelatorio.gerarRelatorioParcial(user, salvar);
    }
    
    /**
     * Gera um relatório parcial filtrado por tipo de atividade, validando a senha.
     *
     * @param user O usuário para o qual o relatório será gerado.
     * @param senha A senha do usuário para validação.
     * @param salvar Indica se o relatório deve ser salvo no histórico.
     * @param tipoAtividade O tipo de atividade a ser filtrado no relatório.
     * @return Uma string contendo o relatório parcial filtrado.
     */
    public String gerarRelatorioParcialPorAtividade(Usuario user, String senha, boolean salvar, String tipoAtividade) {
        user.validaSenha(senha);
        return this.geradorRelatorio.gerarRelatorioParcialPorAtividade(user, salvar, tipoAtividade);
    }
    
    /**
     * Lista o histórico de relatórios do usuário, validando a senha.
     *
     * @param user O usuário cujo histórico será listado.
     * @param senha A senha do usuário para validação.
     * @return Uma string contendo o histórico de relatórios.
     */
    public String listarHistorico(Usuario user, String senha) {
        user.validaSenha(senha);
        return this.geradorRelatorio.listarHistorico(user, senha);
    }
    
    /**
     * Exclui um item do histórico do usuário, validando a senha.
     *
     * @param user O usuário cujo histórico será alterado.
     * @param senha A senha do usuário para validação.
     * @param data A data do item a ser excluído.
     * @return true se o item foi excluído com sucesso, false caso contrário.
     */
    public boolean excluirItemHistorico(Usuario user, String senha, String data) {
        user.validaSenha(senha);
        return this.geradorRelatorio.excluirItemHistorico(user, senha, data);
    }
}
