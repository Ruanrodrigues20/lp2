package filmnow;

import java.util.Objects;

/**
 * Classe que cria um objeto do tipo Filme, que tem por finalidade ser um filme com nome e varios outros
 * atributos de um filme
 * @author Ruan Rodriguer da Silva
 */
public class Filme {
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
	private String localLancamento;
	
	/**
	 * Atributo que indica o status do filme, se é hot ou não
	 */
	private String hot;
	
	/**
	 * Atributo que representa se o filme é hot ou não
	 */
	private boolean ehHot;
	
	
	/**
	 * Construtor do objeto da classe Filme, que recebe o nome, local de lançamento e ano de lançamento
	 * @param nome nome do filme
	 * @param local local de lançamento do filme
	 * @param ano ano de lançamento do filme
	 */
	public Filme(String nome, String local, String ano) {
		if (nome == null || local == null) {
			throw new NullPointerException("FILME NULO");
		}
		
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("FILME INVALIDO");
		}
		this.ano = ano;
		this.localLancamento = local;
		this.nome = nome;
		this.hot = "";
		this.ehHot = false;
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
	public String getLocalLancamento() {
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
		
		if (!(o instanceof Filme)) {
			return false;
		}
		
		Filme testeFilme = (Filme) o;
		
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
		
		out += "\n" + this.localLancamento;
		return out;
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
