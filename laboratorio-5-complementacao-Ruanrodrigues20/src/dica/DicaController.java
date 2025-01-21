package dica;

import java.util.*;
import user.Usuario;

/**
 * Classe responsável pelo controle das dicas.
 * @author Ruan Rodrigues da Silva
 */
public class DicaController {
    private List<Dica> dicas;
    private int iPosicao;

    /**
     * Construtor que inicializa a lista de dicas.
     */
    public DicaController() {
        this.dicas = new ArrayList<Dica>();
        this.iPosicao = 0;
    }

    /**
     * Adiciona uma nova dica associada a um usuário.
     *
     * @param user O usuário que está adicionando a dica.
     * @param senha A senha do usuário.
     * @param tema O tema da dica.
     * @return A posição da dica adicionada, ou -1 se a dica já existir.
     */
    public int adicionarDica(Usuario user, String senha, String tema) {
        user.validaSenha(senha);
        Dica dica = new Dica(user, tema);
        if (this.dicas.contains(dica)) {
            return -1;
        }
        this.dicas.add(dica); 
        return this.iPosicao++;
    }

    /**
     * Adiciona um elemento de texto a uma dica existente.
     *
     * @param user O usuário que está adicionando o texto.
     * @param senha A senha do usuário.
     * @param posicao A posição da dica.
     * @param texto O texto a ser adicionado.
     * @return true se o texto foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarElementoTextoDica(Usuario user, String senha, int posicao, String texto) {
        Dica dica = getDica(posicao);
        return dica.adicionarElementoTexto(user, senha, texto);
    }

    /**
     * Adiciona um elemento multimídia a uma dica existente.
     *
     * @param user O usuário que está adicionando o elemento.
     * @param senha A senha do usuário.
     * @param posicao A posição da dica.
     * @param link O link do elemento multimídia.
     * @param cabecalho O cabeçalho do elemento multimídia.
     * @param tempo O tempo do vídeo ou áudio.
     * @return true se o elemento multimídia foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarElementoMultimidiaDica(Usuario user, String senha, int posicao, String link, String cabecalho, int tempo) {
        Dica dica = getDica(posicao);
        return dica.adicionarElementoMultimidia(user, senha, link, cabecalho, tempo);
    }

    /**
     * Adiciona uma referência a uma dica existente.
     *
     * @param user O usuário que está adicionando a referência.
     * @param senha A senha do usuário.
     * @param posicao A posição da dica.
     * @param título O título da referência.
     * @param fonte A fonte da referência.
     * @param ano O ano da referência.
     * @param conferida Indica se a referência foi conferida.
     * @param importancia A importância da referência.
     * @return true se a referência foi adicionada com sucesso, false caso contrário.
     */
    public boolean adicionarElementoReferenciaDica(Usuario user, String senha, int posicao, String título, String fonte, int ano, boolean conferida, int importancia) {
        Dica dica = getDica(posicao);
        return dica.adicionarElementoReferencia(user, senha, posicao, título, fonte, ano, conferida, importancia);
    }

    /**
     * Lista todas as dicas em formato de string.
     *
     * @return Um array de strings com as dicas.
     */
    public String[] listarDicas() {
        String[] saida = new String[this.dicas.size()];
        int i = 0;
        for (Dica d : this.dicas) {
            saida[i++] = d.toString();
        }
        return saida;
    }

    /**
     * Lista todas as dicas com detalhes.
     *
     * @return Um array de strings com as dicas detalhadas.
     */
    public String[] listarDicasDetalhes() {
        String[] saida = new String[this.dicas.size()];
        int i = 0;
        for (Dica d : this.dicas) {
            saida[i++] = d.dicaDetalhada();
        }
        return saida;
    }

    /**
     * Lista uma dica específica.
     *
     * @param posicao A posição da dica.
     * @return A string representando a dica.
     */
    public String listarDica(int posicao) {
        Dica dica = getDica(posicao);
        return dica.toString();
    }

    /**
     * Lista os detalhes de uma dica específica.
     *
     * @param posicao A posição da dica.
     * @return A string com os detalhes da dica.
     */
    public String listarDicaDetalhes(int posicao) {
        Dica dica = getDica(posicao);
        return dica.dicaDetalhada();
    }

    /**
     * Obtém uma dica a partir da sua posição na lista.
     *
     * @param posicao A posição da dica.
     * @return A dica correspondente à posição.
     * @throws NullPointerException se a posição for inválida.
     */
    private Dica getDica(int posicao) {
        if (posicao < 0 || posicao >= this.dicas.size()) {
            throw new NullPointerException("Posição invalida!");
        }
        Dica dica = this.dicas.get(posicao);
        return dica;
    }
}
