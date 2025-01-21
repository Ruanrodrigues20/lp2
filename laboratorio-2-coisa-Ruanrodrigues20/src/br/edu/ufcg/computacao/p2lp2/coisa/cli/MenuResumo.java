package br.edu.ufcg.computacao.p2lp2.coisa.cli;

import java.util.Arrays;
import java.util.Scanner;

import br.edu.ufcg.computacao.p2lp2.coisa.RegistroResumos;

/**
 * Classe responsável por criar um objeto do tipo MenuResumo, que serve para a interface de teste de funcionalidades
 * relacionada a classe ResgitroResumos.
 * @author Ruan Rodrigues da Silva.
 */
public class MenuResumo {
	/**
	 * Declaração de um objeto do tipo ResgitroResumos.
	 */
	RegistroResumos resumos;
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int entrada = 0;
		
		System.out.print("Capacidade do Registro: ");
		int tamanhoRegistro = Integer.parseInt(sc.nextLine());
		resumos = new RegistroResumos(tamanhoRegistro);
		
		do {
			System.out.println("1 - Adiciona resumo.");
			System.out.println("2 - Fazer Busca.");
			System.out.println("3 - Imprimir resumos.");
			System.out.println("4 - Sair.");
			
			entrada = Integer.parseInt(sc.nextLine());
			
			if (entrada == 1) {
				adicionaResumo();
			} else if (entrada == 2) {
				fazerBusca();
			} else if(entrada == 3) {
				System.out.println(Arrays.toString(resumos.pegaResumos()));
			}
		} while(entrada != 4);
		
	}
	
	private void adicionaResumo() {
		Scanner sc = new Scanner(System.in);
		String tema;
		String texto;
		
		System.out.print("Tema do resumo: ");
		tema = sc.nextLine();
		
		System.out.print("Digite o Resumo: ");
		texto = sc.nextLine();
		
		resumos.adiciona(tema, texto);
	}
	

	private void fazerBusca() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma palavra de Busca: ");
		String chave = sc.nextLine();
		String[] busca = resumos.busca(chave);
		
		System.out.println(Arrays.toString(busca));
	}
}
