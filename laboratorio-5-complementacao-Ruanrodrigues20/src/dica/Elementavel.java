package dica;

/**
 * Interface que representa um elemento que pode ser adicionado a uma dica.
 * @author Ruan Rodrigues da Silva
 */
public interface Elementavel {
    
    /**
     * Obtém a visualização resumida do elemento.
     *
     * @return Uma string com a visualização do elemento.
     */
    public String getVisualizacao();

    /**
     * Obtém a visualização detalhada do elemento.
     *
     * @return Uma string com a visualização detalhada do elemento.
     */
    public String getVisualizacaoDetalhada();

    /**
     * Obtém a quantidade de pontos atribuídos ao elemento.
     *
     * @return Um inteiro representando os pontos do elemento.
     */
    public int getPontos();
}
