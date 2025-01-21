package dica;

import java.util.Objects;

/**
 * Classe que representa um texto que pode ser adicionado a uma dica.
 * @author Ruan Rodrigues da Silva
 */
public class Texto implements Elementavel {
    private String texto;
    private String autor;

    /**
     * Construtor para criar um texto.
     *
     * @param autor O autor do texto.
     * @param texto O conteúdo do texto.
     */
    public Texto(String autor, String texto) {
        this.texto = texto;
        this.autor = autor;
        verificaAtt();
    }

    /**
     * Verifica se os atributos do texto são válidos.
     *
     * @throws NullPointerException se algum atributo é nulo ou vazio.
     */
    private void verificaAtt() {
        if (this.texto == null || this.autor == null) {
            throw new NullPointerException("Atributo Nulo!");
        }
        if (this.texto.isBlank() || this.autor.isBlank()) {
            throw new NullPointerException("Atributo Vazio!");
        }
    }

    /**
     * Obtém o conteúdo do texto.
     *
     * @return O conteúdo do texto.
     */
    public String getTexto() {
        return this.texto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, texto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Texto other = (Texto) obj;
        return Objects.equals(autor, other.autor) && Objects.equals(texto, other.texto);
    }

    /**
     * Obtém a visualização resumida do texto.
     *
     * @return Uma string com a visualização do texto.
     */
    @Override
    public String getVisualizacao() {
        return this.texto;
    }

    /**
     * Obtém a visualização detalhada do texto, incluindo o número de caracteres.
     *
     * @return Uma string com a visualização detalhada do texto.
     */
    @Override
    public String getVisualizacaoDetalhada() {
        return this.texto + ". (" + this.texto.length() + " caracteres).";
    }

    /**
     * Obtém a quantidade de pontos atribuídos ao texto com base no seu tamanho.
     *
     * @return Um inteiro representando os pontos do texto.
     */
    @Override
    public int getPontos() {
        int tamanhoTexto = this.texto.length();
        return tamanhoTexto >= 100 ? tamanhoTexto / 10 : 0;
    }
}
