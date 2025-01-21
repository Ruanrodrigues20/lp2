package atividades.complemetares;

import java.util.Objects;

/**
 * Classe que representa uma atividade de monitoria, estendendo a classe abstrata Atividade.
 * @author Ruan Rodrigues da Silva
 */
public class Monitoria extends Atividade {
    private String disciplina;

    /**
     * Construtor da classe Monitoria.
     * 
     * @param tipo O tipo da atividade de monitoria.
     * @param unidadeAcumulada A quantidade de unidades acumuladas para essa atividade.
     * @param disciplina A disciplina relacionada à monitoria.
     */
    public Monitoria(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo, unidadeAcumulada);
        this.disciplina = disciplina;
        verificaAtt();
    }

    /**
     * Verifica a validade dos atributos da atividade.
     * 
     * @throws IllegalArgumentException Se a unidade de contagem for inválida.
     * @throws NullPointerException Se algum atributo obrigatório for nulo ou vazio.
     */
    private void verificaAtt() {
        if (super.unidadeContagem < 1) {
            throw new IllegalArgumentException("Unidade de Contagem inválida!");
        }

        if (this.disciplina == null || this.tipo == null) {
            throw new NullPointerException("Atributo Null!");
        }

        if (super.tipo.isBlank() || super.tipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }

        if (this.disciplina.isBlank() || this.disciplina.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
    }

    @Override
    public String toString() {
        return "Monitoria [disciplina= " + disciplina + ", descricao= " + descricao + ", codigo= " + codigo + ", tipo= "
                + tipo + ", unidadeContagem= " + unidadeContagem + ", creditos= " + getCredito() + ", linkComprovacao= "
                + linkComprovacao + "]";
    }

    /**
     * Obtém o número de créditos acumulados para a atividade de monitoria.
     * 
     * @return O número de créditos, limitado a um máximo de 16.
     */
    @Override
    public int getCredito() {
        return (super.unidadeContagem * 4 > 16) ? 16 : (super.unidadeContagem * 4);
    }

    /**
     * Obtém a disciplina relacionada à monitoria.
     * 
     * @return O nome da disciplina.
     */
    public String getDisciplina() {
        return this.disciplina;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(disciplina);
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
        Monitoria other = (Monitoria) obj;
        return Objects.equals(disciplina, other.disciplina);
    }
}
