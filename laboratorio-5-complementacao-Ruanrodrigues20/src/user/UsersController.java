package user;

import java.util.*;

/**
 * Controlador para gerenciar usuários do sistema.
 * @author Ruan Rodrigue da Silva
 */
public class UsersController {
    private Map<String, Usuario> usuarios;

    /**
     * Construtor para inicializar o controlador de usuários.
     */
    public UsersController() {
        this.usuarios = new HashMap<String, Usuario>();
    }

    /**
     * Cria um novo estudante se não existir um usuário com o mesmo CPF.
     *
     * @param nome      O nome do estudante.
     * @param cpf       O CPF do estudante.
     * @param senha     A senha do estudante.
     * @param matricula A matrícula do estudante.
     * @return booelan se o estudante foi criado com sucesso; {@code false} se o CPF já estiver em uso.
     */
    public boolean criarEstudante(String nome, String cpf, String senha, String matricula) {
        if (!this.usuarios.containsKey(cpf)) {
            Usuario user = new Usuario(nome, cpf, senha, matricula);
            this.usuarios.put(cpf, user);
            return true;
        }
        return false;
    }

    /**
     * Exibe todos os estudantes cadastrados, ordenados pelo nome.
     *
     * @return Um array de strings representando os estudantes.
     */
    public String[] exibirEstudantes() {
        List<Usuario> usersList = new ArrayList<>(this.usuarios.values());
        Collections.sort(usersList, new UsersComparator());
        return converteListArrayUsers(usersList);
    }

    /**
     * Altera a senha de um estudante, verificando a senha antiga.
     *
     * @param cpf         O CPF do estudante.
     * @param senhaAntiga A senha antiga do estudante.
     * @param novaSenha   A nova senha a ser definida.
     * @return {@code true} se a senha foi alterada com sucesso; {@code false} caso contrário.
     */
    public boolean alterarSenhaEstudante(String cpf, String senhaAntiga, String novaSenha) {
        temUser(cpf);
        Usuario user = this.usuarios.get(cpf);
        return user.trocarSenha(senhaAntiga, novaSenha);
    }

    /**
     * Obtém um usuário com base no CPF e senha.
     *
     * @param cpf   O CPF do usuário.
     * @param senha A senha do usuário.
     * @return O objeto Usuario correspondente.
     * @throws IllegalArgumentException Se o usuário não existir ou a senha estiver incorreta.
     */
    public Usuario getUsuario(String cpf, String senha) {
        return pegaUsuario(cpf, senha);
    }

    /**
     * Lista os usuários classificados por suas pontuações em dicas.
     *
     * @return Um array de strings representando os usuários e suas pontuações.
     */
    public String[] listarUsuariosRankingDicas() {
        List<Usuario> users = new ArrayList<Usuario>(this.usuarios.values());
        Collections.sort(users);
        String[] estudantes = new String[users.size()];
        int i = 0;
        for (Usuario user : users) {
            estudantes[i] = user.mostrarUserBonus();
            i++;
        }
        return estudantes;
    }

    /**
     * Converte uma lista de usuários em um array de strings.
     *
     * @param lista A lista de usuários a ser convertida.
     * @return Um array de strings representando os usuários.
     */
    private String[] converteListArrayUsers(List<Usuario> lista) {
        String[] estudantes = new String[lista.size()];
        int i = 0;
        for (Usuario user : lista) {
            estudantes[i] = user.mostrarUser();
            i++;
        }
        return estudantes;
    }

    /**
     * Obtém um usuário com base no CPF e senha, verificando a existência do usuário.
     *
     * @param cpf   O CPF do usuário.
     * @param senha A senha do usuário.
     * @return O objeto Usuario correspondente.
     * @throws IllegalArgumentException Se o usuário não existir ou a senha estiver incorreta.
     */
    private Usuario pegaUsuario(String cpf, String senha) {
        if (!this.usuarios.containsKey(cpf)) {
            throw new IllegalArgumentException("Usuario inexistente!");
        }

        Usuario user = this.usuarios.get(cpf);
        if (user.ehSenha(senha)) {
            return user;
        }

        throw new IllegalArgumentException("Senha errada");
    }

    /**
     * Verifica se um usuário existe pelo CPF.
     *
     * @param cpf O CPF do usuário.
     * @throws IllegalArgumentException Se o usuário não existir.
     */
    private void temUser(String cpf) {
        if (!this.usuarios.containsKey(cpf)) {
            throw new IllegalArgumentException("Usuario inexistente!");
        }
    }
}
