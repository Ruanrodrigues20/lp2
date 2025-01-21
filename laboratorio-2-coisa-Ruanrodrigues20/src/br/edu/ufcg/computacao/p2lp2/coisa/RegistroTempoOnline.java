package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Gerencia o nome, as horas esperadas e as horas utilizadas para determinada disciplina,
 * verifica se a quantidade de horas esperadas foram atingidas, adiciona tempo online e retorna a relação.
 * 
 * @author Ruan Rodrigues da Silva
 */
public class RegistroTempoOnline {
	/**
	 * Recebe uma String que representa o nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * Recebe um int que representa o tempo online esperado nessa disciplina.
	 */
	private int tempoOnlineEsperado;
	/**
	 * Recebe um int que representa o tempo online utilizado nessa disciplina.
	 */
	private int tempoOnline;
	
	
	/**
	 * Construtor que recebe apenas o nome da disciplina e atribui o valor default de tempo online esperado 
	 * que é de 120 horas.
	 * 
	 * @param nomeDisciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Construtor que recebe uma String com o nome da Disciplina e o int de tempo Online esperado da mesma.
	 * @param nomeDisciplina
	 * @param tempoOnline
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnline) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnline = 0;
		this.tempoOnlineEsperado = tempoOnline;
	}
	
	/**
	 * Recebe um int que representa horas utilizadas na disciplina e acumula esse valor ao acumulador tempoOnline.
	 * @param tempo
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	
	/**
	 * Verifica se o aluno já atingiu a meta de tempo online esperado na disciplina.
	 * @return tempoOnline >= tempoOnlineEsperado
	 */
	public boolean atingiuMetaTempoOnline() {
		return (this.tempoOnline >= this.tempoOnlineEsperado);
	}	
	
	/**
	 * Retorna uma String com o nome da disciplina e a relação de horas utilizadas / horas esperadas
	 * @return String (nomeDisciplina tempoOnline / tempoOnlineEsperado)
	 */
	public String toString() {
		String dadoDisciplina = this.nomeDisciplina + " " + this.tempoOnline;
		dadoDisciplina += "/" +this.tempoOnlineEsperado;
		return dadoDisciplina;
	}
}
