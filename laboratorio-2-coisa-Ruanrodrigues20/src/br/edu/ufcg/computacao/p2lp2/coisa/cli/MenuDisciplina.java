package br.edu.ufcg.computacao.p2lp2.coisa.cli;

import java.util.Scanner;

import br.edu.ufcg.computacao.p2lp2.coisa.Disciplina;

/**
 * Classe responsável por criar um objeto do tipo MenuMedia, que serve para a interface de teste de funcionalidades
 * relacionada a classe Disciplina.
 * @author Ruan Rodrigues da Silva.
 */
public class MenuDisciplina {
	Disciplina disciplina;
	String nomeDisciplina;
	String entrada;
	double[] notas;
	int[] pesos;
	int nNotas;
	
	/**
	 * Metodo para ter a interação do usuario, sobre as funcionalidades da classe Disciplina.
	 */
	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome da disciplina: ");
		this.nomeDisciplina  = sc.nextLine();
		
		System.out.print("Quantas Notas: ");
		this.nNotas = Integer.parseInt(sc.nextLine());
		
		this.notas = recebeNotas(nNotas);
		
		System.out.print("Media com peso?[s/n] ");
		this.entrada = sc.nextLine();
		
		if (entrada.equals("s")) {
			this.pesos = recebePesos(nNotas);
			this.disciplina = new Disciplina(nomeDisciplina, nNotas, pesos);
		} else {
			this.disciplina = new Disciplina(nNotas, nomeDisciplina);
		}
		
		this.disciplina.recebeNotas(notas);

		System.out.println(disciplina.toString());
	}
	

	private double[] recebeNotas(int nNotas) {
		Scanner sc = new Scanner(System.in);
		String entrada;
		double[] notas = new double[nNotas];
		
		for (int i = 0; i < nNotas; i ++) {
			System.out.print(i + 1 + "° nota: ");
			entrada = sc.nextLine();
			notas[i] = Double.parseDouble(entrada);
		}
		return notas;
	}
	
	private int[] recebePesos(int nPesos) {
		Scanner sc = new Scanner(System.in);
		String entrada;
		int[] pesos = new int[nPesos];
		
		for (int i = 0; i < nPesos; i ++) {
			System.out.print(i + 1 + "° peso: ");
			entrada = sc.nextLine();
			pesos[i] = Integer.parseInt(entrada);
		}
		return pesos;
	}
}
