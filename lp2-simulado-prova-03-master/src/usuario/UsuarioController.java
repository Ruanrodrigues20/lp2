package usuario;

import java.util.*;

public class UsuarioController {
	private Map<String, Usuario> usuarios;
	
	public UsuarioController() {
		this.usuarios = new HashMap<>();
	}
	
	public String adicionaUsuario(String cpf, String nome) {
		Usuario user = new Usuario(nome, cpf);
		return 	this.usuarios.put(cpf, user).toString();
	} 
	
	public String[] listarUsuarioPorNome() {
		String[] listaUser = new String[this.usuarios.size()];
		int i = 0;
		List<Usuario> usuariosLista = new ArrayList<>(this.usuarios.values());
		Collections.sort(usuariosLista, new CompareUserPorNome());
		for(Usuario user: usuariosLista) {
			listaUser[i++] = user.toString();
		}
		return listaUser;
	}
	
	
	public String[] listarUsuariosPorCuponsTotais() {
		String[] listaUser = new String[this.usuarios.size()];
		int i = 0;
		List<Usuario> usuariosLista = new ArrayList<>(this.usuarios.values());
		Collections.sort(usuariosLista);
		for(Usuario user: usuariosLista) {
			listaUser[i++] = user.toString();
		}
		return listaUser;
	}
	
	public Usuario getUser(String cpf) {
		return this.usuarios.get(cpf);
	}

	public String[] listarCuponsUsuario(String cpf) {
		return this.usuarios.get(cpf).listarCupons();
	}
}


