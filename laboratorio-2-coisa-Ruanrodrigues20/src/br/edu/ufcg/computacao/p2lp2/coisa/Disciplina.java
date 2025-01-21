package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Responsável por gerenciar o nome e as notas de um aluno em determinada disciplina,
 * além de calcular sua media e retornar a situação do aluno, se está aprovado ou reprovado.
 * 
 * @author Ruan Rodrigues da Silva
 */
public class Disciplina {
	/**
	 * Recebe uma String que é o nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * Acumulador de horas Estudadas.
	 */
	private int horasEstudo;
	/**
	 * Declara um array onde serão armazenadas as notas nessa disciplinas. 
	 */
	private double[] notas;
	/**
	 * Declara um array onde serão armazenada os pesos das notas, caso a pessoa use media
	 * ponderada.
	 */
	private int[] pesosNotas;
	private double media;
	
	
	/**
	 * Construtor que recebe como parâmetro um String que representa o nome da disciplinas.
	 * inicializa o atriubuto horasEstudo com um valor defaul igual a 0.
	 * Instancia o array de notas com o tamanho 4.
	 * Instancia o array de pesosNotas com tamanho 0, o que indica que não sera usado este
	 * tipo de media.
	 * @param nomeDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[4];
		this.pesosNotas = new int[0];
		this.media =0;
	}
	
	/**
	 * Construtor que recebe como parâmetro a quantidade de Notas que seram usadas para calcular
	 * a media. Inicializa o array de pesosNotas com tamanho 0, o que indica que não sera usado;
	 * @param nNotas
	 */
	public Disciplina(int nNotas, String nomeDisciplina) {
		this.pesosNotas = new int[0];
		this.horasEstudo = 0;
		this.notas = new double[nNotas];
		this.nomeDisciplina = nomeDisciplina;
		this.media =0;
	}
	
	/**
	 * Construtor que indica o nome da disciplina, a quantidade de notas e o peso array com pesos de notas,
	 * onde já passa como parâmetro quais os pesos de cada nota.
	 * @param nomeDisciplina
	 * @param nNotas
	 * @param pesosNotas
	 */
	public Disciplina(String nomeDisciplina, int nNotas, int[] pesosNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.pesosNotas = pesosNotas;
		this.notas = new double[nNotas];
		this.media =0;
	}
	
	/**
	 * Recebe como parâmetros o numero de horas em int, e atualizar o acumulador de horas de estudo.
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	 * Recebe como parâmetro uma nota da disciplina e a aloca na devida posição no array "notas".
	 * @param nota
	 * @param valorNota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Verifica a média do aluno, se maior ou igual a 7.
	 * @return boolean mediaDisciplina >= 7.
	 */
	public boolean aprovado() {
		calculaMedia();
		return ( this.media>= 7);
	}
	
	/**
	 * Calcula a media do aluno na disciplina, que pode ser a media aritmética ou ponderada,
	 *  e retorta o valor double da média.
	 * @param notas
	 * @return media
	 */
	private void calculaMediaAritmetica(double[] notas) {
		double soma = 0.0;
		for (int i = 0; i < notas.length; i ++) {
			soma += notas[i];
		}
		this.media = soma / notas.length;
	}
	
	/**
	 * Metodo responsável por calcular a media com peso, quando necessário.
	 * @param notas
	 * @param pesos
	 * @return
	 */
	private void calculaMediaPeso(double[] notas, int[] pesos) {
		double soma = 0.0;
		for (int i = 0; i < notas.length; i ++) {
			soma += notas[i] * pesos[i];
		}
		this.media = soma/10;
	}
	
	/**
	 * Metodo responsável por verficar qual tipo de media o usuario quer, se é ponderada ou não, e ele chamara um
	 * dos metodos desejados, e retorna o valor da media.
	 */
	public void calculaMedia() {
		if (this.pesosNotas.length == 0) {
			calculaMediaAritmetica(this.notas);
		} else {
			calculaMediaPeso(this.notas, this.pesosNotas);
		}
	}
	
	/**
	 * Responsável por retornar uma String com os dados da disciplinas, como a nota, nome,
	 * horas de Estudo e média.
	 */
	public String toString() {
		String dados = this.nomeDisciplina + " " + this.horasEstudo + " "; 
		dados += this.media + " " + Arrays.toString(notas);
		return dados;
	}
	
	/**
	 * Metodo responsável por receber as notas, caso o usuário queira passar um array com todas elas.
	 * @param notas
	 */
	public void recebeNotas(double[] notas) {
		this.notas = notas;
	}
	
}