package br.edu.ufcg.computacao.mrbet;

import java.util.*;

/**
 * Classe que sera a nossa representação de um campeonato
 * @author ruan.rodrigues.silva
 */
public class Campeonato {
	private String nome;
	private HashMap<String, Time> timesParticipantes;
	private int participantes;
	private int qtdMaximaParticipantes;
	
	/**
	 * Construtor do Campeonato que recebe um nome e qtd de times participantes e inicializa seus atributos
	 * @param nome
	 * @param qtdeParticipantes
	 */
	public Campeonato(String nome, int qtdeParticipantes) {
		this.nome = nome;
		this.timesParticipantes = new HashMap<String, Time>();
		this.qtdMaximaParticipantes = qtdeParticipantes;
	}

	/**
	 * HashCode do campeonato que leva em conta seu nome
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	/**
	 * Equals do campeonato que verifica se um obejeto é um campeonto igual
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	/**
	 * Representação textual de um campeonato
	 * 
	 * @return String
	 * */
	@Override
	public String toString() {
		return  this.nome + " - " + this.participantes + "/" + qtdMaximaParticipantes;
	}
	
	/**
	 * retorna o hashMap de times participantes
	 * @return timesParticipantes
	 */
	public HashMap<String, Time> getTimesParticipantes() {
		return timesParticipantes;
	}
	
	/**
	 * metodo que retorna a quantidade de times que estão participando naquele campeoanto
	 * @return participantes
	 */
	public int getParticipantes() {
		return participantes;
	}

	/**
	 * Metodo que retorna o nome do campeonato
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * Metodo que retorna a quantidae maxima de participantes de um campeonato
	 *
	 * @return
	 */
	public int getQtdMaximaParticipantes() {
		return qtdMaximaParticipantes;
	}

	/**
	 * Metodo que adiciona um time a um campeonato verificando a quantidade de vagas e se ele já está incluso no campeonato
	 * @param codigoTime
	 * @param time
	 * @return boolean
	 */
	public boolean adicionaTime(String codigoTime, Time time) {
		if(temVaga() && !(this.timesParticipantes.containsValue(time))) {
			this.timesParticipantes.put(codigoTime, time);
			this.participantes++;
			return true;
		}
		return false;
	}

	private boolean temVaga() {
		return (this.participantes < this.qtdMaximaParticipantes);
	}
	
	/**
	 * Metodo que verifica se um time está no campeonato pelo o seu codigo
	 * @param codigoTime
	 * @return boolean
	 */
	public boolean temTime(String codigoTime) {
		return this.timesParticipantes.containsKey(codigoTime);
	}
	
}

