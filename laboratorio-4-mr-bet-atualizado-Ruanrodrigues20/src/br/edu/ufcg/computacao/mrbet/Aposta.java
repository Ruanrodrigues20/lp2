package br.edu.ufcg.computacao.mrbet;

import java.util.*;

/**
 * Classe para representar uma aposta, onde recebe como atributo o time, o campeonato
 * a posicao do time no final do campeonato e o valor da aposta
 * @author Ruan Rodrigues da Silva
 */
public class Aposta {
	private Time time;
	private Campeonato campeonato;
	private int colocao;
	private double valorAposta;
	
	/**
	 * Construtor que instancia um objeto do tipo aposta que recebe os atributos ja mencionado
	 * @param time
	 * @param campeonato
	 * @param colocao
	 * @param valorAposta
	 */
	public Aposta(Time time, Campeonato campeonato, int colocao, double valorAposta) {
		this.time = time;
		this.campeonato = campeonato;
		this.colocao = colocao;
		this.valorAposta = valorAposta;
	}
	
	/**
	 * HashCode da aposta que  leva em conta o campeonato, time, colcoao e o valor da aposta.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(campeonato, colocao, time, valorAposta);
	}
	
	/**
	 * Metodo sobrescito equals, que vai comparar se um objeto é uma aposta
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		return Objects.equals(campeonato, other.campeonato) && colocao == other.colocao
				&& Objects.equals(time, other.time)
				&& Double.doubleToLongBits(valorAposta) == Double.doubleToLongBits(other.valorAposta);
	}
	
	/**
	 * Representacao textual de uma aposta
	 * @return String
	 */
	@Override
	public String toString() {
		String out = this.time.toString() + "\n" + this.campeonato.getNome() + "\n";
		out += this.campeonato.getParticipantes() + "/" + this.campeonato.getQtdMaximaParticipantes();
		out += "\nR$ " + String.format("%.2f",this.valorAposta);
		return out;
	}

	/**
	 * Metodo que retorna a colocao do time que foi colocada ao criar a aposta
	 * @return int
	 */
	public int getColocao() {
		return colocao;
	}

	/**
	 * Metodo que muda a colocao do time que foi setado ao criar a aposta
	 * @param colocao
	 */
	public void setColocao(int colocao) {
		this.colocao = colocao;
	}
	
	/**
	 * Metodo que retorna o valor da aposta 
	 * @return valorAposta
	 */
	public double getValorAposta() {
		return valorAposta;
	}

	/**
	 * Metodo que muda o valor da aposta que foi realizada
	 * @param valorAposta
	 */
	public void setValorAposta(double valorAposta) {
		this.valorAposta = valorAposta;
	}
	
	/**
	 * Metodo que retorna qual foi o time que foi apostado
	 * @return time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Metodo que retorna em qual campeontao está sendo avaliado a aposta
	 * @return campeonato
	 */
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	
}
