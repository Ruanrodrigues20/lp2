package filmnow;

import java.util.Objects;

/**
 * Classe que cria um objeto do tipo FilmeBonus, que tem por finalidade ser um filme com nome e varios outros
 * atributos de um filme para testamos adiciornamos as novas funcionalidades do Bonus
 * @author Ruan Rodriguer da Silva
 */

public class FilmeBonus {
	/**
	 * Atributo do tipo String que representa o nome do filme
	 */
	private String nome;
	
	/**
	 * Atributo do tipo int que representa o ano que o filme foi lançado
	 */
	private String ano;
	
	/**
	 * Atributo do tipo String que representa o local de lançamento do filme
	 */
	private String[] localLancamento;
	
	/**
	 * Atributo que indica o status do filme, se é hot ou não
	 */
	private String hot;
	
	/**
	 * Atributo que representa se o filme é hot ou não
	 */
	private boolean ehHot;
	
	/**
	 * Contados de locais de lançamento que um filme tem
	 */
	private int iLocal;
	
	/**
	 * Construtor do objeto FilmeBonus aonde incializamos todos os atributos
	 * Recebemos o nome, um local e o ano de lançamento
	 * @param nome nome do Filme
	 * @param local local de lançamento do filme
	 * @param ano ano de lançamento do filme
	 */
	public FilmeBonus(String nome, String local, String ano) {
		this.localLancamento = new String[5];
		this.localLancamento[0] = local;
		this.iLocal = 1;
		this.ano = ano;
		this.nome = nome;
		this.hot = "";
		this.ehHot = false;
	}
	
	/**
	 * Construtor do objeto FilmeBonus aonde incializamos todos os atributos
	 * Recebemos o nome e o ano de lançamento
	 * @param nome nome do Filme
	 * @param ano ano de lançamento do filme
	 */
	public FilmeBonus(String nome, String ano) {
		if (nome == null) {
			throw new NullPointerException("FILME NULO");
		}
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("FILME INVALIDO");
		}
		
		this.localLancamento = new String[5];
		this.iLocal = 0;
		this.ano = ano;
		this.nome = nome;
		this.hot = "";
		this.ehHot = false;
	}
	
	/**
	 * Metodo que adiciona um local no array de localLancamento que é um array de String aonde
	 * guardamos no maximo 5 nome de local de lançamento do filme
	 * @param local local de lançamento do filme
	 * @param posicao posiçãoao aonde vamos adicionar o local
	 * @return boolean
	 */
	public boolean adicionaLocal(String local, int posicao) {
		if (posicao >= 0 && posicao < 5) {
			if(this.localLancamento[posicao] == null || this.localLancamento[posicao].isEmpty()) {
				this.iLocal++;
			}
			this.localLancamento[posicao] = local;
			return true;
		} 
		return false;
	}
	
	/**
	 * Metodo aonde recebemos a posicao de um local de lançamento que queremos remover do Filme
	 * @param posicao posição aonde removemos o local de lançamento
	 * @return boolean especificação se foi removido ou não -
	 */
	public boolean removeLocal(int posicao) {
		if (!(this.localLancamento[posicao].isEmpty()) && iLocal > 1 && posicao >= 0 && posicao < this.localLancamento.length) {
			this.localLancamento[posicao] = "";
			return true;
		} 
		return false;
	}
	
	/**
	 * Metodo que retorna se o objeto possui o status de hot ou não
	 * @return ehHot atributo do filme se é hot
	 */
	public boolean isHot() {
		return this.ehHot;
	}

	/**
	 * Metodo que retorna o nome do filme
	 * @return nome nome do filme
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que retorna o ano de lançamento do filme
	 * @return ano
	 */
	public String getAno() {
		return this.ano;
	}

	/**
	 * Metodo que retorna o local de lançamento do filme
	 * @return localLancamento
	 */
	public String[] getLocaisLancamento() {
		return this.localLancamento;
	}
	
	/**
	 * Equals que compara se um objeto é um filme
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof FilmeBonus)) {
			return false;
		}
		
		FilmeBonus testeFilme = (FilmeBonus) o;
		
		return (testeFilme.ano.equals(this.ano) && testeFilme.nome.equals(this.nome));
				
	}
	
	/**
	 * hashCode do filme levando em conta nome e ano do filme
	 */
	@Override
	public int hashCode() {
		  return Objects.hash(nome, ano);
	}
	
	/**
	 * Representação textual de um filme
	 */
	@Override
	public String toString() {
		String out;
		
		if (!(this.ano.isEmpty())) {
			out = this.nome + ", " + this.ano; 
		} else {
			out = this.nome;
		}
		
		if (this.iLocal > 0) {
		out += "\n" + locaisLancamento();
		}
		return out;
	}
	
	/**
	 * Metodo que usamos no toString que retorna uma String de tod
	 * @return
	 */
	private String locaisLancamento() {
		String out = "";
		for(int i = 0; i < this.localLancamento.length; i ++) {
			if (!(this.localLancamento[i] == null || this.localLancamento[i].isEmpty())) {
				out += this.localLancamento[i] + ", ";
			}
		}
		return out.substring(0, out.length() - 2);
	}
	
	/**
	 * Metodo que Retorna a representação em forma de String de um filme com o selo que é hot
	 * @return out representação textual
	 */
	public String filmeHot() {
		String out = this.hot + toString();
		return out;
	}
	
	/**
	 * Metodo que vai tornar o filme a ser um filme hot
	 */
	public void atribuiHot() {	
		this.hot = "\ud83d\udd25";
		this.ehHot = true;
	}
	
	/**
	 * Metodo que vai remover do filme o atributo hot
	 */
	public void removeHotFilme() {
		this.hot = "";
		this.ehHot = false;
	}
	
	/**
	 * Metodo que retorna uma representação de um filme apenas do nome e ano dele
	 * @return String
	 */
	public String nomeAno() {
		return this.nome + ", " + this.ano;
	}
}
