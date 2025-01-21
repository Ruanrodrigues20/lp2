package dica;

import java.util.*;
import user.Usuario;

/**
 * Classe que representa uma Dica, contendo um tema, autor e elementos que a compõem.
 * @author Ruan Rodrigues da Silva
 */
public class Dica {
    private String tema;
    private Usuario autor;
    private List<Elementavel> elementos;

    /**
     * Construtor da classe Dica. Recebe o autor e o tema da Dica
     *
     * @param autor O usuário que cria a dica.
     * @param tema O tema da dica.
     * @throws IllegalArgumentException Se o tema for inválido.
     */
    public Dica(Usuario autor, String tema) {
        this.tema = tema;
        verificaTema(tema);
        this.autor = autor;
        verificaAtt();
        this.elementos = new ArrayList<Elementavel>();
    }

    
    private void verificaAtt() {
    	if (this.autor == null || this.tema == null) {
    		throw new NullPointerException("Atributo Nulo");
    	}
    	
     }
    
    /**
     * Verifica se o tema fornecido é válido.
     *
     * @param possivelTema O tema a ser verificado.
     * @throws IllegalArgumentException Se o tema for inválido.
     */
    private void verificaTema(String possivelTema) {
        String tema = possivelTema.toUpperCase();
        if (!tema.equals("PESQUISA EXTENSAO") && !tema.equals("MONITORIA") && !tema.equals("ESTAGIO") && !tema.equals("REPRESENTACAO ESTUDANTIL")) {
            throw new IllegalArgumentException("Tema inválido!");
        }
    }

    /**
     * Obtém o tema da dica.
     *
     * @return O tema da dica.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Obtém o autor da dica.
     *
     * @return O autor da dica.
     */
    public Usuario getAutor() {
        return this.autor;
    }

    /**
     * Verifica se o usuário é o autor da dica e se a senha está correta.
     *
     * @param user O usuário a ser verificado.
     * @param senha A senha do usuário.
     * @throws NullPointerException Se o usuário ou a senha forem nulos.
     * @throws IllegalArgumentException Se o usuário ou a senha estiverem incorretos.
     */
    private void verificarAutor(Usuario user, String senha) {
        if (user == null || senha == null) {
            throw new NullPointerException("Entrada Nula");
        }

        if (!this.autor.equals(user) || !this.autor.ehSenha(senha)) {
            throw new IllegalArgumentException("Usuario ou senha incorreta!");
        }
    }

    /**
     * Adiciona um elemento de texto à dica.
     *
     * @param user O usuário que está adicionando o elemento.
     * @param senha A senha do usuário.
     * @param texto O texto a ser adicionado.
     * @return true se o elemento foi adicionado, false se já existe.
     */
    public boolean adicionarElementoTexto(Usuario user, String senha, String texto) {
        verificarAutor(user, senha);
        Elementavel texto1 = new Texto(autor.getNome(), texto);
        if (this.elementos.contains(texto1)) {
            return false;
        }   
        this.elementos.add(texto1);
        this.autor.aumentaBonus(texto1.getPontos());
        return true;
    }

    /**
     * Adiciona um elemento multimídia à dica.
     *
     * @param user O usuário que está adicionando o elemento.
     * @param senha A senha do usuário.
     * @param link O link do elemento multimídia.
     * @param cabecalho O cabeçalho do elemento multimídia.
     * @param tempo O tempo associado ao elemento multimídia.
     * @return true se o elemento foi adicionado, false se já existe.
     */
    public boolean adicionarElementoMultimidia(Usuario user, String senha, String link, String cabecalho, int tempo) {
        verificarAutor(user, senha);
        Elementavel multi = new Multimidia(link, autor.getNome(), cabecalho, tempo);
        if (this.elementos.contains(multi)) {
            return false;
        }
        this.elementos.add(multi);
        this.autor.aumentaBonus(multi.getPontos());
        return true;
    }

    /**
     * Adiciona um elemento de referência à dica.
     *
     * @param user O usuário que está adicionando o elemento.
     * @param senha A senha do usuário.
     * @param posicao A posição da referência.
     * @param título O título da referência.
     * @param fonte A fonte da referência.
     * @param ano O ano da referência.
     * @param conferida Se a referência foi conferida.
     * @param importancia A importância da referência.
     * @return true se o elemento foi adicionado, false se já existe.
     */
    public boolean adicionarElementoReferencia(Usuario user, String senha, int posicao, String título, String fonte, int ano, boolean conferida, int importancia) {
        verificarAutor(user, senha);
        Elementavel ref = new Referencia(user.getNome(), título, fonte, ano, importancia, conferida);
        if (this.elementos.contains(ref)) {
            return false;
        }
        this.elementos.add(ref);
        this.autor.aumentaBonus(ref.getPontos());
        return true;
    }

    @Override
    public String toString() {
        String out = "Autor: " + this.autor.getNome() + ", tema: " + this.tema + ".\n" + listaElementos();
        return out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, tema);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dica other = (Dica) obj;
        return Objects.equals(autor, other.autor) && Objects.equals(tema, other.tema);
    }

    /**
     * Obtém uma descrição detalhada da dica, incluindo seus elementos.
     *
     * @return Uma string com detalhes da dica.
     */
    public String dicaDetalhada() {
        return "Autor: " + this.autor.getNome() + ", tema: " + this.tema + ".\n" + pegaElementosDetalhado();
    } 

    private String listaElementos() {
        if (this.elementos.size() == 0) {
            return "";
        } 
        String out = "";
        for (Elementavel e : this.elementos) {
            out += e.getVisualizacao() + "\n";
        }
        return out.substring(0, out.length() - 1);
    }

    private String pegaElementosDetalhado() {
        if (this.elementos.size() == 0) {
            return "";
        }
        String out = "";
        for (Elementavel e : this.elementos) {
            out += e.getVisualizacaoDetalhada() + "\n";
        }
        return out.substring(0, out.length() - 1);
    }    
}
