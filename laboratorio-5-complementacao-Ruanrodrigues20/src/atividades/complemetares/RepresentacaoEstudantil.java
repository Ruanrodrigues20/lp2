package atividades.complemetares;

import java.util.Objects;

/**
 * Classe que representa uma atividade de representação estudantil, estendendo a classe abstrata Atividade.
 * @author Ruan Rodrigues da Silva
 */
public class RepresentacaoEstudantil extends Atividade {

    private String subtipo;
    private final String[] SUBTIPOS = {"DIRETORIA", "COMISSAO"};

    /**
     * Construtor da classe RepresentacaoEstudantil.
     * 
     * @param tipo O tipo da atividade de representação estudantil.
     * @param unidadeContagem A quantidade de unidades acumuladas para essa atividade.
     * @param subtipo O subtipo da atividade de representação estudantil.
     */
    public RepresentacaoEstudantil(String tipo, int unidadeContagem, String subtipo) {
        super(tipo, unidadeContagem);
        this.subtipo = subtipo;
        verificaAtt();
    }

    /**
     * Verifica a validade dos atributos da atividade.
     * 
     * @throws NullPointerException Se algum atributo obrigatório for nulo ou vazio.
     * @throws IllegalArgumentException Se a unidade de contagem for inválida ou o subtipo não for válido.
     */
    private void verificaAtt() {
        if (this.subtipo == null || super.tipo == null) {
            throw new NullPointerException("Atributo Nulo!");
        }

        if (super.unidadeContagem < 1) {
            throw new IllegalArgumentException("Unidade de Contagem inválida!");
        } 
        
        if (super.tipo.isBlank() || super.tipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
        
        if (this.subtipo.isBlank() || this.subtipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
        
        boolean ehSubTipoInvalido = true;
        for (String tipo2 : this.SUBTIPOS) {
            if (this.subtipo.toUpperCase().equals(tipo2)) {
                ehSubTipoInvalido = false;
            }
        }
        
        if (ehSubTipoInvalido) {
            throw new IllegalArgumentException("Subtipo inválido!");
        }
    }

    /**
     * Obtém o número de créditos acumulados para a atividade de representação estudantil.
     * 
     * @return O número de créditos, limitado a um máximo de 2.
     */
    @Override
    public int getCredito() {
        return (super.unidadeContagem * 2) >= 2 ? 2 : super.unidadeContagem * 2;
    }

    @Override
    public String toString() {
        return "RepresentacaoEstudantil, subtipo=" + subtipo + ", descricao=" + descricao + ", codigo=" + codigo
                + ", tipo=" + tipo + ", unidadeContagem=" + unidadeContagem + ", creditos=" + creditos
                + ", linkComprovacao=" + linkComprovacao;
    }

    /**
     * Obtém o subtipo da atividade de representação estudantil.
     * 
     * @return O subtipo da atividade.
     */
    public String getSubtipo() {
        return subtipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(subtipo);
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
        RepresentacaoEstudantil other = (RepresentacaoEstudantil) obj;
        return Objects.equals(subtipo, other.subtipo);
    }
}
