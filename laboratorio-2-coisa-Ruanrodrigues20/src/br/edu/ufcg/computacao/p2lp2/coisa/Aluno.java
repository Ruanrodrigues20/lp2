package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação de um estudante, especificamente de computação, matriculado da * UFCG. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
* 
* @author Ruan Rodrigues da Silva
*/


public class Aluno {
	
	/**
	* Matrícula do aluno. No formato 2XXXYYZZZ onde XX é o ano e 
	* semestre de entrada, YY é o código do curso e ZZ é um identificador * do aluno no curso.
	*/
	
	private String nome;
	private int anoNascimento;
	private double cra;
	
	/**
	* Constrói um aluno a partir de sua matrícula e nome.
	* Todo aluno começa com o campo CRA como nulo.
	*
	* @param anoNascimento Ano de nascimento do aluno.
	* @param nome o nome do aluno
	*/

	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
	}

	public void setCra(double cra) {
		this.cra = cra;
	}
	
	public double getCra() {
		return this.cra;
	}
	

	public int getIdade() {
		return 2021 - anoNascimento;
	}
	
	/*** Retorna a String que representa o aluno. A representação segue o 
	 * formato “MATRICULA - Nome do Aluno”.
	 *
	 * 	@return a representação em String de um aluno.
	 */

	public String toString() {
		return "Aluno - "  + this.nome;
	}
}