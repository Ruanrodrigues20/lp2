package dica;

import java.util.Objects;

/**
 * Classe que representa um elemento multimídia que pode ser adicionado a uma dica.
 * @author Ruan Rodrigues da Silva
 */
public class Multimidia implements Elementavel {
    private String link;
    private String autor;
    private String cabecalho;
    private int tempo;

    /**
     * Construtor para criar um elemento multimídia.
     *
     * @param link      O link do elemento multimídia.
     * @param autor     O autor do elemento multimídia.
     * @param cabecalho O cabeçalho do elemento multimídia.
     * @param tempo     O tempo de duração do elemento multimídia em segundos.
     */
    public Multimidia(String link, String autor, String cabecalho, int tempo) {
        this.link = link;
        this.autor = autor;
        this.cabecalho = cabecalho;
        this.tempo = tempo;
        verificaAtt();
    }

    /**
     * Verifica se os atributos do elemento multimídia são válidos.
     *
     * @throws NullPointerException se algum atributo é nulo ou vazio.
     */
    private void verificaAtt() {
        if (this.link == null || this.autor == null || this.cabecalho == null) {
            throw new NullPointerException("Atributo Nulo!");
        }
        if (this.tempo == 0) {
            throw new NullPointerException("Tempo nulo");
        }
        if (this.link.isEmpty() || this.autor.isEmpty() || this.cabecalho.isEmpty()) {
            throw new NullPointerException("Atributo Vazio!");
        }
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cabecalho, link);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Multimidia other = (Multimidia) obj;
        return Objects.equals(cabecalho, other.cabecalho) && Objects.equals(link, other.link);
    }

    /**
     * Obtém a visualização resumida do elemento multimídia.
     *
     * @return Uma string com a visualização do elemento.
     */
    @Override
    public String getVisualizacao() {
        return this.cabecalho + ", " + this.link + ".";
    }

    /**
     * Obtém a visualização detalhada do elemento multimídia.
     *
     * @return Uma string com a visualização detalhada do elemento.
     */
    @Override
    public String getVisualizacaoDetalhada() {
        String out = this.cabecalho + ", " + this.link;
        out += ". (" + this.tempo + "s ).";
        return out;
    }

    /**
     * Obtém a quantidade de pontos atribuídos ao elemento multimídia.
     *
     * @return Um inteiro representando os pontos do elemento.
     */
    @Override
    public int getPontos() {
        return this.tempo >= 60 ? (tempo / 60) * 5 : 0;
    }
}
