package dica;

import java.util.Objects;

/**
 * Classe que representa uma referência bibliográfica que pode ser adicionada a uma dica.
 * @author Ruan Rodrigues da Silva
 */
public class Referencia implements Elementavel {
    private String autor;
    private String titulo;
    private String fonte;
    private int ano;
    private int importanica;
    private boolean conferida;

    /**
     * Construtor para criar uma referência.
     *
     * @param autor      O autor da referência.
     * @param titulo     O título da referência.
     * @param fonte      A fonte da referência.
     * @param ano        O ano de publicação da referência.
     * @param importanica O nível de importância da referência.
     * @param conferida  Indica se a referência foi conferida.
     */
    public Referencia(String autor, String titulo, String fonte, int ano, int importanica, boolean conferida) {
        this.autor = autor;
        this.titulo = titulo;
        this.fonte = fonte;
        this.ano = ano;
        this.importanica = importanica;
        this.conferida = conferida;
        verificaAtt();
    }

    /**
     * Verifica se os atributos da referência são válidos.
     *
     * @throws NullPointerException se algum atributo é nulo ou vazio.
     */
    private void verificaAtt() {
        if (this.titulo == null || this.autor == null || this.fonte == null) {
            throw new NullPointerException("Atributo Nulo!");
        }
        if (this.titulo.isBlank() || this.autor.isBlank() || this.fonte.isBlank()) {
            throw new NullPointerException("Atributo Vazio!");
        }
    }

    public String getAutor() {
        return autor;
    }

    public boolean isConferida() {
        return conferida;
    }

    public void setConferida(boolean conferiu) {
        this.conferida = conferiu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, autor, fonte, importanica, titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Referencia other = (Referencia) obj;
        return ano == other.ano && Objects.equals(autor, other.autor) && Objects.equals(fonte, other.fonte)
                && importanica == other.importanica && Objects.equals(titulo, other.titulo);
    }

    /**
     * Obtém a visualização resumida da referência.
     *
     * @return Uma string com a visualização da referência.
     */
    @Override
    public String getVisualizacao() {
        String out = "Referência: " + this.titulo + ", " + this.fonte + ", ano " + this.ano + ".";
        return out;
    }

    /**
     * Obtém a visualização detalhada da referência.
     *
     * @return Uma string com a visualização detalhada da referência.
     */
    @Override
    public String getVisualizacaoDetalhada() {
        String out = "Referência: " + this.titulo + ", " + this.fonte + ", ano " + this.ano + ". Importância: " + this.importanica + ".";
        return out;
    }

    /**
     * Obtém a quantidade de pontos atribuídos à referência.
     *
     * @return Um inteiro representando os pontos da referência.
     */
    @Override
    public int getPontos() {
        return this.conferida ? 15 : 0;
    }
}
