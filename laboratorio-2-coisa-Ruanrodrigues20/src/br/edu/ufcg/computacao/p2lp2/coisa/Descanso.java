package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Responsavel por calcular as horas de descanso, e se está na hora do aluno
* descansar ou se ele já está descansado, usando como critério a relacao de 
* horas de descanso, por quantidade de semanas
* 
* @author Ruan Rodrigues da Silva
*/import java.util.Scanner;

public class Descanso {
	/**
	* Quantidade de horas de descanso do aluno, e não é algo acumulativa
	*/
	private int horasDescanso;
	
	/**
	* Quantidade de semanas que está sendo analizado em relação ao descanso 
	* do aluno
	*/
	private int numeroSemanas;
	
	/**
	* Status do aluno com base na relação horasDescanso / numeros de semanas
	*/
	private String statusAluno;
	/**
	 * Status de emoção do aluno, com base um emoji que ele vai adicionar
	 */
	private String emoji;
	/**
	 * Para a verificação do emoji, se foi setado ou não
	 */
	private boolean temEmoji;

	/**
	* Constrói o Objeto da classe Descanso 
	*/
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroSemanas = 1;
		this.statusAluno = "cansado";
		this.emoji = "";
		this.temEmoji = false;
	}
	
	/**
	* Recebe um valor inteiro como argumento e o atribui ao atributo
	* horasDescanso. 
	* 
	* @param valor
	*/
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	* Recene um valor do tipo int como argumento e o atribui ao atributo
	* numerosSemanas 
	* @param valor
	*/
	public void defineNumeroSemanas(int valor) {
		this.numeroSemanas = valor;
	}
	
	/**
	* Responsável por calcular a média de horas por numeros de semanas e se a
	* média for maior ou igual a 26 returno "descansado", caso contrário, retorna "cansado" 
	* E ta também retorna o emoji na primeira chamada após indicação de um emoji
	* @return statusAluno + emoji
	*/
	public String getStatusGeral() {
		if ((this.horasDescanso / this.numeroSemanas) >= 26) {
			this.statusAluno = "descansado";
		} else {
			this.statusAluno = "cansado";
		}
		
		if (temEmoji) {
			this.statusAluno += "-" + this.emoji;
			this.temEmoji = false;
		}
		return this.statusAluno;
	}
	
	/**
	 * Metodo que recebe como parâmetro a String que comporta um emoji especificado pelo aluno
	 * @param valor
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
		this.temEmoji = true;
	}
}
