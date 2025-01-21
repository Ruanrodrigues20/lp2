package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Adiciona novos resumos, verifica se excedeu o número máximo de resumos, retorna uma string com os temas de resumos cadastrados,
 * verifica se existi algum resumo cadastrado com um certo nome.
 * 
 * @author Ruan Rodrigues da Silva
 */
public class RegistroResumos {
	private int proximaPosicaoResumo;
	private String[] resumos;
	private String[] temaResumo;
	private int espacosPreenchido;
	
	/**
	 * Construtor que recebe como parâmetro int numero máximo de Resumos, e instancias os dois Arrays temasResumos e resumos.
	 * @param numeroDeResumos numeros de resumos cadastrados.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new String[numeroDeResumos];
		this.temaResumo = new String[numeroDeResumos];
		this.proximaPosicaoResumo = 0;
		this.espacosPreenchido = 0;
	}
	
	/**
	 * Recebe o resumo e o tema dele, e armazenar ambos em seus respectivos Arrays.
	 * Aciona o método aumentaArray, caso necessário.
	 * @param tema tema do resumo a ser adicionado
	 * @param resumo resumo a ser adicionado
	 */
	public void adiciona(String tema, String resumo) {
		if (proximaPosicaoResumo == resumos.length) {
			proximaPosicaoResumo = 0;
		}
		this.temaResumo[this.proximaPosicaoResumo] = tema;
		this.resumos[this.proximaPosicaoResumo] = tema + ": " + resumo;
		this.proximaPosicaoResumo++;
		
		if (this.espacosPreenchido < resumos.length - 1) {
			this.espacosPreenchido ++;
		}
	}
	
	/**
	 * Retorna o Array de String, compostos pelos temas dos resumos e os resumos.
	 * @return resumos
	 */
	public String[] pegaResumos() {
		return this.resumos;
	}
	
	/**
	 * Retorna a relação com os nomes dos resumos que foram armazenados.
	 * @return relacao de temas de Resumos
	 */
	public String imprimeResumos() {
		String relacao = "- " + this.proximaPosicaoResumo + " resumo(s) cadastrado(s)\n- ";
		
		for (int i = 0; i < this.proximaPosicaoResumo; i ++) {
			relacao += this.temaResumo[i];	
			if (i < this.proximaPosicaoResumo - 1) {
				relacao += " | ";
			}	
		}
		return relacao;
	}
	
	/**
	 * Retorna o numero de resumos que foram cadastrados.
	 * @return numeroResumosCadastrados
	 */
	public int conta() {
		return this.proximaPosicaoResumo;
	}

	/**
	 * Verifica se existi algum resumo com o mesmo tema que é recibido como parâmetro
	 * @param tema chave a ser buscada
	 * @return achouTema
	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i < this.proximaPosicaoResumo; i ++) {
			if (this.temaResumo[i].equals(tema)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que recebe uma String chave de busca e que a usa pra fazer uma busca em todos os resumos registrados
	 * e retorna um array com todas as aparições dessa chave de busca.
	 * @param chaveBusca chave de busca nos resumos.
	 * @return busca
	 */
	public String[] busca(String chaveBusca) {
		String[] busca = new String[this.espacosPreenchido];
		for (int i = 0; i < this.espacosPreenchido && i < this.proximaPosicaoResumo; i ++) {
			if ( !this.resumos[i].equals(null) && this.resumos[i].contains(chaveBusca)) {
				busca[i] = resumos[i];
			}
		}
		Arrays.sort(busca);
		return busca;
	}
	
}
