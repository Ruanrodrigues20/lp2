package user;

import java.util.Comparator;

/**
 * Classe responsável por comparar objetos do tipo Usuario com base no nome.
 * @author Ruan Rodrigue da Silva
 */
public class UsersComparator implements Comparator<Usuario> {

    /**
     * Compara dois usuários pelo seu nome.
     *
     * @param user1 O primeiro usuário a ser comparado.
     * @param user2 O segundo usuário a ser comparado.
     * @return Um valor negativo se user1 for lexicograficamente menor que user2,
     *         zero se forem iguais, ou um valor positivo se user1 for maior que user2.
     */
    @Override
    public int compare(Usuario user1, Usuario user2) {
        return user1.getNome().compareTo(user2.getNome());
    }
}
