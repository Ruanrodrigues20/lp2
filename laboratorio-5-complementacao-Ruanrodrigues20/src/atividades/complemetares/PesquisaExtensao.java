package atividades.complemetares;

import java.util.Arrays;
import java.util.Objects;

/**
 * Classe que representa uma atividade de pesquisa ou extensão, estendendo a classe abstrata Atividade.
 *  @author Ruan Rodrigues da Silva
 */
public class PesquisaExtensao extends Atividade {

    private String subTipo;
    private final String[] SUBTIPOS = {"PET", "PIBIC", "PIVIC", "PIBITI", "PIVITI", "PROBEX", "PDI"};

    /**
     * Construtor da classe PesquisaExtensao.
     * 
     * @param tipo O tipo da atividade de pesquisa ou extensão.
     * @param unidadeContagem A quantidade de unidades acumuladas para essa atividade.
     * @param subTipo O subtipo da atividade de pesquisa ou extensão.
     */
    public PesquisaExtensao(String tipo, int unidadeContagem, String subTipo) {
        super(tipo, unidadeContagem);
        this.subTipo = subTipo;
        verificaATT();
    }

    @Override
    public String toString() {
        return "PesquisaExtensao [subTipo=" + subTipo + ", descricao=" + descricao + ", codigo=" + codigo + ", tipo="
                + tipo + ", unidadeContagem=" + unidadeContagem + ", creditos=" + creditos + ", linkComprovacao="
                + linkComprovacao + "]";
    }

    /**
     * Obtém o número de créditos acumulados para a atividade de pesquisa ou extensão.
     * 
     * @return O número de créditos, limitado a um máximo de 18.
     */
    @Override
    public int getCredito() {
        return ((super.unidadeContagem / 12) * 10 > 18) ? 18 : (super.unidadeContagem * 10 / 12);
    }

    /**
     * Verifica a validade dos atributos da atividade.
     * 
     * @throws NullPointerException Se algum atributo obrigatório for nulo ou vazio.
     * @throws IllegalArgumentException Se a unidade de contagem for inválida ou o subtipo não for válido.
     */
    private void verificaATT() {
        if (tipo == null || subTipo == null) {
            throw new NullPointerException("Atributo Nulo!");
        }

        if (super.unidadeContagem < 1 || super.unidadeContagem > 19) {
            throw new IllegalArgumentException("Unidade de Contagem inválida!");
        }

        if (super.tipo.isBlank() || super.tipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }

        if (this.subTipo.isBlank() || this.subTipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }

        if (!isSubtipoValido()) {
            throw new IllegalArgumentException("Sub tipo inválido!");
        }
    }

    /**
     * Obtém o subtipo da atividade de pesquisa ou extensão.
     * 
     * @return O subtipo da atividade.
     */
    public String getSubTipo() {
        return subTipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(SUBTIPOS);
        result = prime * result + Objects.hash(subTipo);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PesquisaExtensao other = (PesquisaExtensao) obj;
        return Arrays.equals(SUBTIPOS, other.SUBTIPOS) && Objects.equals(subTipo, other.subTipo);
    }

    /**
     * Verifica se o subtipo da atividade é válido.
     * 
     * @return true se o subtipo for válido, false caso contrário.
     */
    public boolean isSubtipoValido() {
        boolean ehSubTipoValido = false;
        for (String tipo2 : this.SUBTIPOS) {
            if (this.subTipo.toUpperCase().equals(tipo2)) {
                ehSubTipoValido = true;
            }
        }
        return ehSubTipoValido;
    }
}
