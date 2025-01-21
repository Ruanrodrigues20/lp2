package atividades.complemetares;

import java.util.Objects;

/**
 * Classe que representa uma atividade de estágio, estendendo a classe abstrata Atividade.
 * @author Ruan Rodrigues da Silva
 */
public class Estagio extends Atividade {
    private String nomeEmpresa;

    /**
     * Construtor da classe Estagio.
     * 
     * @param tipo O tipo da atividade de estágio.
     * @param unidadeContagem A quantidade de unidades acumuladas para essa atividade.
     * @param nomeEmpresa O nome da empresa onde o estágio é realizado.
     */
    public Estagio(String tipo, int unidadeContagem, String nomeEmpresa) {
        super(tipo, unidadeContagem);
        this.nomeEmpresa = nomeEmpresa;
        verificaAtt();
    }

    /**
     * Verifica a validade dos atributos da atividade.
     * 
     * @throws NullPointerException Se algum atributo obrigatório for nulo.
     * @throws IllegalArgumentException Se a unidade de contagem for inválida.
     */
    private void verificaAtt() {
        if (this.tipo == null || this.nomeEmpresa == null) {
            throw new NullPointerException("Atributo Nulo!");
        }
        
        if (super.tipo.isBlank() || super.tipo.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
        
        if (this.nomeEmpresa.isBlank() || this.nomeEmpresa.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
        
        if (super.unidadeContagem < 300) {
            throw new IllegalArgumentException("Unidade de Contagem inválida!");
        }
    }

    @Override
    public String toString() {
        return "Estagio [nomeEmpresa=" + nomeEmpresa + ", descricao=" + descricao + ", codigo=" + codigo + ", tipo="
                + tipo + ", unidadeContagem=" + unidadeContagem + ", creditos=" + creditos + ", linkComprovacao="
                + linkComprovacao + "]";
    }

    /**
     * Obtém o nome da empresa onde o estágio é realizado.
     * 
     * @return O nome da empresa.
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * Obtém o número de créditos acumulados para a atividade de estágio.
     * 
     * @return O número de créditos, limitado a um máximo de 18.
     */
    @Override
    public int getCredito() {
        return (super.unidadeContagem / 60 > 18) ? 18 : (super.unidadeContagem / 60);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomeEmpresa);
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
		Estagio other = (Estagio) obj;
		return Objects.equals(nomeEmpresa, other.nomeEmpresa);
	}
    
    
}
