package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author Ruan Rodrigues da Silva
 *
 */
public class FilmNowBonus {
	/**
	 * Tamanho maximo de arrays de Filme que serão guardados.
	 */
	private static final int TAMANHO = 100;
	
	/**
	 * Array com objetos do tipo Filme
	 */
	private FilmeBonus[] filmes; 
	
	/**
	 * Represetação da hotList aonde tera referência aos filmes favoritos.
	 */
	private FilmeBonus[] hotList;
	
	/**
	 * Posições dos filmes no arrray filmes, que estão na hotList
	 */
	private int[] posicaoList;
	
	/**
	 * Tamanho do array hotList
	 */
	private int nFilmesHot;
	
	
	/**
	 * Cria o FilmNowBonus.
	 */
	public FilmNowBonus() {
		this.filmes = new FilmeBonus[TAMANHO];
		this.hotList = new FilmeBonus[10];
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
				this.filmes[posicao - 1] = new FilmeBonus(nome, local, ano);
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
		FilmeBonus verificaFilme = new FilmeBonus(nome, local, ano);
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
	 * @param posicao posição do array de filmes
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
	
	/**
	 * Remove filme da lista de filmes e também chama o metodo que remove da hotList esse filme caso ele
	 * esteja lá
	 * @param posicao posicao do array de filmes
	 * @return boolean
	 */
	public boolean removeFilme(int posicao) {
		if(posicao > 0 && posicao <= this.filmes.length) {
			removeFilmeHotList(posicao);
			this.filmes[posicao - 1] = null;
			return true;
		}
		return false;
		
	}
	
	/**
	 * Recebe uma posição e remove esse filme da hotList, ele recebe a posição que se encontra no array de Filmes
	 * @param posicao
	 */
	private void removeFilmeHotList(int posicao) {
		for (int i = 0; i < this.hotList.length; i ++) {
			if (this.hotList[i] != null &&  this.hotList[i].equals(this.filmes[posicao - 1])) {
				this.hotList[i] = null;
			}
		}
	}	
		
	/**
	 * Faz uma busca no array de filmes e retorna a representação textual em forma de array de todos que tem o mesmo nome que 
	 * especificado com a variavel nomeBusca
	 * @param nomeBusca nome para buscar no array de filmes
	 * @return busca array de String
	 */
	public String[] buscaFilmeNome(String nomeBusca) {
		int resultado = nNomeIgual(nomeBusca);
		String[] busca = new String[resultado];
		int j = 0;
		for(int i = 0; i < this.filmes.length; i++) {
			if(this.filmes[i] != null && nomeBusca.equals(this.filmes[i].getNome())) {
				busca[j] = this.filmes[i].toString();
				j++;
			}
		}
		return busca;
	}
	
	/**
	 * Verifica quantos filmes tem o nome igual a chave
	 * @param chave
	 * @return resultado inteiro com a quantidade
	 */
	private int nNomeIgual(String chave) {
		int resultado = 0;
		for(int i = 0; i < this.filmes.length; i++) {
			if(this.filmes[i] != null && chave.equals(this.filmes[i].getNome())) {
				resultado++;
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo que faz a busca de filmes que tem o mesmo local de lançamento da chave especificada
	 * @param local
	 * @return busca
	 */
	public String[] buscaFilmeLocalLancamento(String local) {
		int resultado = nLocaisIguais(local);
		String[] busca = new String[resultado];
		int j = 0;
		for(int i = 0; i < this.filmes.length; i++) {
			if(resultado > 0 && this.filmes[i] != null && localIgual(local, this.filmes[i]) ) {
				busca[j] = this.filmes[i].toString();
				j++;
			}
		}
		return busca;
	}
		
	/**
	 * Metodo que vefica quantos filmes tem o mesmo local e retorna o valor inteiro correpondente
	 * @param local
	 * @return resultado
	 */
	private int nLocaisIguais(String local) {
		int resultado = 0;
		for (int i = 0; i < this.filmes.length; i ++) {
			if(this.filmes[i] != null && localIgual(local, this.filmes[i])) {
				resultado++;
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo que verifica se o filme tem o local em comum ao passado como chave
	 * @param local
	 * @param filme
	 * @return boolean
	 */
	private boolean localIgual(String local, FilmeBonus filme) {
		String[] locais = filme.getLocaisLancamento();
		for (int i = 0; i < locais.length; i++) {
			if(locais[i] != null && locais[i].equals(local)) {
				return true;
			}
		}
		return false;
	}
		
	/**
	 * Metodo que recebe um nome de um Local, a posição aonde adicionar no array de Local e a posição do filme que queremos fazer
	 * a adição
	 * @param local
	 * @param pLocal
	 * @param pFilme
	 * @return boolean
	 */
	public boolean adicionaLocalFilme(String local, int pLocal, int pFilme) {
		if (pFilme > 0 && pFilme <= this.filmes.length && this.filmes[pFilme - 1] != null) {
			boolean condicao = this.filmes[pFilme - 1].adicionaLocal(local, pLocal);
			return condicao;
		}
		return false;
	}	
		
	
}
