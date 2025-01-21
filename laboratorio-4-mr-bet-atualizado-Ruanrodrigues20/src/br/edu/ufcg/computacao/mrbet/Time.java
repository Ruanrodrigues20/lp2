package br.edu.ufcg.computacao.mrbet;

import java.util.Objects;

/**
 * Classe que sera a nossa reprensentação de um time
 * @author ruan.rodrigues.silva
 */
public class Time {
	/**
	 * Nome do time
	 */
	private String nome;
	
	/**
	 * Código do time que sera a sua identificação unica
	 */
	private String codigo;
	
	/**
	 * String do nome do mascote do time
	 */
	private String mascote;
	
	/**
	 * Quantidades de vezes que esse time participou de campeonatos
	 */
	private int participacaoCampeonato;
	
	/**
	 * Quantidade de vezes que esse time participou de apostas ocupando a primeira colocação
	 */
	private int participacaoApostaPrimeiroLugar ;
	
	/**
	 * Construtor da classe Time, que recebe seu nome, seu codigo e o nome do seu mascote
	 * @param nome
	 * @param codigo
	 * @param mascote
	 */
	public Time(String nome, String codigo, String mascote) {
		this.nome = nome;
		this.codigo = codigo;
		this.mascote = mascote;
		this.participacaoCampeonato = 0;
		this.participacaoApostaPrimeiroLugar = 0;
	}

	/**
	 * Override do hashCode levando em conta seu codigo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Override do equals levando em conta o seu codigo que é o indentificador pessoal de cada filme
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	/**
	 * Representação textual de um time
	 */
	@Override
	public String toString() {
		String out = "[" + this.codigo + "]" + " ";
		out += this.nome + " / " + this.mascote;
		return out;
	}
	
	/**
	 * Representação textual de um filme com a quantidade de participação de campeonato 
	 * @return
	 */
	public String toStringParticipacaoCamp() {
		return toString() + " " + this.participacaoCampeonato;
	}

	/**
	 * Retorna a String do nome mascote
	 * @return mascote
	 */
	public String getMascote() {
		return mascote;
	}

	/**
	 * Método que eu retorno o nome do time
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que retorno a String do codigo do time
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Método que retorn a quantidade de participação do time em campeonatos
	 */
	public int getParticipacaoCampeonato() {
		return participacaoCampeonato;
	}
	
	/**
	 * Método que aumento a quantidade de participação em campeonatos do time
	 */
	public void aumentaParticipacaoCampeonato() {
		this.participacaoCampeonato++;
	}
	
	/**
	 * Método que retorno a quantidade de vezes que o time ficou em primeiro lugar em apostas
	 * @return int
	 */
	public int getparticipacaoApostaPrimeiroLugar() {
		return participacaoApostaPrimeiroLugar ;
	}
	
	/**
	 * Método que aumento a quantidade de vezes que o time ficou em primeiro lugar em apostas
	 */
	public void aumentaparticipacaoApostaPrimeiroLugar() {
		this.participacaoApostaPrimeiroLugar++;
	}
	
}
