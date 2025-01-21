package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 * @author Ruan Rodrigues da Silva
 *
 */
public class FilmNow {
	/**
	 * Tamanho maximo de arrays de Filme que serão guardados.
	 */
	private static final int TAMANHO = 100;
	
	/**
	 * Array com objetos do tipo Filme
	 */
	private Filme[] filmes; 
	
	/**
	 * Represetação da hotList aonde tera referência aos filmes favoritos.
	 */
	private Filme[] hotList;
	
	/**
	 * Posições dos filmes no arrray filmes, que estão na hotList
	 */
	private int[] posicaoList;
	
	/**
	 * Tamanho do array hotList
	 */
	private int nFilmesHot;
	
	
	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.hotList = new Filme[10];
		this.posicaoList = new int[10];
		this.nFilmesHot = 10;
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return mostrarFilmes O array de nomes de filmes.
	 */
	public String[] getFilmes() {
		String[] mostrarFilmes = new String[100];
		for (int i = 0; i < this.filmes.length; i++) {
			if (!(this.filmes[i] == null)) {
				mostrarFilmes[i] = this.filmes[i].getNome(); 
			}
		}
		return mostrarFilmes;
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String getFilme(int posicao) {
		return filmes[posicao - 1].toString();
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 * @return out condicao se o Filme foi cadastrado ou se deu algum erro.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		String out;
		if (posicao >= 1 && posicao <= 100) {

			if(nome.isEmpty() ||local.isEmpty()) {
				out = "FILME INVALIDO"; 	
			} else if (podeAdicionar(nome, ano, local)) {
				if(this.filmes[posicao - 1] != null) {
					removeHotList(posicao);
				}
				out = "FILME ADICIONADO";
				this.filmes[posicao - 1] = new Filme(nome, local, ano);
			} else {
				out = "FILME JÁ ADICIONADO";
			}
			
		} else {
			out = "POSIÇÃO INVÁLIDA";
		}
		
		return out;
	}
	
	/**
	 * Verifico se o filme ja foi adicionado, caso já tenha retorna false.
	 * @param nome nome do filme
	 * @param ano ano de lançamento do fime
	 * @return podeCadastrar Condição se pode ou não cadastrar
	 */
	private boolean podeAdicionar(String nome, String ano, String local) {
		Filme verificaFilme = new Filme(nome, local, ano);
		boolean podeCadastrar = true;
		for (int i = 0; i < this.filmes.length; i ++) {
			if (this.filmes[i] != null && this.filmes[i].equals(verificaFilme)) {
				podeCadastrar = false;
			}
		}
		
		return podeCadastrar;
	}
	
	
	/**
	 * Faz a busca por posições no array de filmes, caso não ache um filme na posição
	 * recebida como parâmetro, ele retorna que a posição foi inválida.
	 * @param posicao posição do array de filme
	 * @return out Resultado da busca se achou ou não o filme buscado
	 */
	public String buscaFilme(int posicao) {
		String out;
		if (posicao > 0 && posicao <= 100) {
			if (this.filmes[posicao - 1] == null) {
				out = "";
			} else if (this.filmes[posicao - 1].isHot()) {
				out = this.filmes[posicao - 1].filmeHot();
			} else {
				out= this.filmes[posicao - 1].toString();
			}	
		} else {
			out = "POSIÇÃO INVÁLIDA";
		}
		return out;
	}
	
	/**
	 * Adiciona um objeto do tipo filme a hotList, fazendo as verificações se ja foi adicionado.
	 * @param indiceFilme indice do filme que quer adicionar na hotList
	 * @param indiceHot indice da posição que o filme ficara armazenado na hotList
	 * @return out String de relatorio dessa adição se foi adicionado ou não
	 */
	public String adicionaHotList(int indiceFilme, int indiceHot) {
		String out;
		
		if (indiceFilme > 0 && indiceFilme <= 100 && indiceHot > 0 && indiceHot <= this.hotList.length && this.filmes[indiceFilme - 1] != null) {
			if(!(filmeHotRpetido(indiceFilme))) {
				ehfilmeHotOcupado(indiceHot);			
				this.hotList[indiceHot - 1] = this.filmes[indiceFilme - 1];
				this.posicaoList[indiceHot - 1] = indiceFilme - 1;
				this.filmes[indiceFilme - 1].atribuiHot();
				out = "ADICIONADO À HOTLIST NA POSIÇÃO " + indiceHot;
			} else {
				out = "FILME JÁ ADICIONADO A HOTLIST";
			}
			
		} else {
			out = "POSIÇÃO INVÁLIDA!";
		}
		return out;
	}
	
	/**
	 * Remove um elemento da hotList, tirando assim o emoji dele.
	 * @param posicao posição a remover o filme da hotList
	 */
	public void removeHotList(int posicao) {
		if(posicao > 0 && posicao <= 10 &&hotList[posicao - 1] != null) {
			this.hotList[posicao - 1] = null;
			this.filmes[this.posicaoList[posicao - 1]].removeHotFilme();
			this.posicaoList[posicao - 1] =  - 1;
		}
	}
	
	/**
	 * Responsavel por retornar um array de Strings com os nomes e anos de cada filme da hotList
	 * @return hotList array de String
	 */
	public String[] exibirHotList() {
		int hotValidos = filmeHotValidos();
		String[] hotList = new String[hotValidos];
		int index = 0;
		
		for (int i = 0; i < this.nFilmesHot; i++) {
			if(this.hotList[i] != null) {
				hotList[index] = this.hotList[i].nomeAno();
				index++;
			}
		}
		return hotList;
	}
	
	/**
	 * Verifica quantos filmes estão presente no array hotList
	 * @return hotValidos
	 */
	private int filmeHotValidos() {
		int hotValidos = 0;
		for (int i = 0; i < this.nFilmesHot; i++) {
			if(this.hotList[i] != null) {
				hotValidos++;
			}
		}
		return hotValidos;
	}
		
	/**
	 * Verifica se é possivel adicionar um objeto Filme, no array de hotList
	 * @param filme filme a ser verificado se pode ser adicionado
	 * @return pode condição se pode adicionar ou não a hotList
	 */
	private boolean podeAdicionarHot(Filme filme) {
		boolean pode = true;
		for (int i = 0; i < this.hotList.length; i++) {
			if(this.hotList[i] != null && !(this.hotList[i].equals(filme))) {
				pode = false;
			}
		}
		return pode;
	}
	
	/**
	 * Verifica se essa posição na hotList ja está ocupada, caso esteja ele remove o filme antigo
	 * @param posicao posição na hotList
	 * @return condição se está ocupada ou não.
	 */
	private void ehfilmeHotOcupado(int posicao) {
		 if (this.hotList[posicao - 1] != null) {
			 removeHotList(posicao);
		 }
		
	}
	
	/**
	 * Verifica se o filme ja foi adicionado na hotList
	 * @param posicao
	 * @return boolean se o filme já está la ou não.
	 */
	private boolean filmeHotRpetido(int posicao) {
		for (int i = 0; i < this.hotList.length; i ++) {
			if (this.hotList[i] != null && hotList[i].equals(this.filmes[posicao - 1])) {
				return true;
			}
		}
		return false;
	}

}
