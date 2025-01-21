package atividades.complemetares;

import java.util.Objects;

/***
 * Classe que representa uma abstração de uma Atividade, onde ela será superclasse (tendo em vista que é abstrata), para que
 * outras atividades a estendam.
 * 
 * @author Ruan Rodrigues da Silva
 */
public abstract class Atividade {
    protected String descricao;
    protected String codigo;
    protected String tipo;
    protected int unidadeContagem;
    protected int creditos;
    protected String linkComprovacao;
    
    /**
     * Construtor da classe Atividade.
     * 
     * @param tipo O tipo da atividade.
     * @param unidadeContagem A quantidade de unidades acumuladas para essa atividade.
     */
    public Atividade(String tipo, int unidadeContagem) {
        this.unidadeContagem = unidadeContagem;
        this.tipo = tipo;
        this.descricao = "sem descrição";
        this.creditos = 0;
        this.linkComprovacao = "sem link";
        this.codigo = "";
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Atividade other = (Atividade) obj;
        return Objects.equals(codigo, other.codigo);
    }

    /**
     * Obtém a descrição da atividade.
     * 
     * @return A descrição da atividade.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição da atividade.
     * 
     * @param descricao A nova descrição da atividade.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a quantidade de unidades acumuladas para a atividade.
     * 
     * @return A quantidade de unidades acumuladas.
     */
    public int getUnidadeContagem() {
        return unidadeContagem;
    }

    /**
     * Altera a quantidade de unidades acumuladas para a atividade.
     * 
     * @param unidadeContagem A nova quantidade de unidades acumuladas.
     */
    public void setUnidadeContagem(int unidadeContagem) {
        this.unidadeContagem = unidadeContagem;
    }

    /**
     * Obtém o código da atividade.
     * 
     * @return O código da atividade.
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Altera a descrição da atividade.
     * 
     * @param descriacao A nova descrição da atividade.
     */
    public void alterarDescricao(String descriacao) {
        this.descricao = descriacao;
    }

    /**
     * Altera o link de comprovação da atividade.
     * 
     * @param linkComprovacao O novo link de comprovação.
     */
    public void alterarComprovacao(String linkComprovacao) {
        this.linkComprovacao = linkComprovacao;
    }

    /**
     * Define o código da atividade.
     * 
     * @param cod O novo código da atividade.
     */
    public void setCodigo(String cod) {
        this.codigo = cod;
    }

    /**
     * Obtém o link de comprovação da atividade.
     * 
     * @return O link de comprovação da atividade.
     */
    public String getLinkComprovacao() {
        return linkComprovacao;
    }

    /**
     * Altera o link de comprovação da atividade.
     * 
     * @param linkComprovacao O novo link de comprovação da atividade.
     */
    public void setLinkComprovacao(String linkComprovacao) {
        this.linkComprovacao = linkComprovacao;
    }

    /**
     * Obtém o tipo da atividade.
     * 
     * @return O tipo da atividade.
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Método abstrato que deve ser implementado por subclasses para obter o número de créditos da atividade.
     * 
     * @return O número de créditos da atividade.
     */
    public abstract int getCredito();
}
