package br.edu.ufcg.computacao.p2lp2.coisa.cli;

import java.util.Scanner;

/**
 * Classe com uma tipo de "interface" onde podemos testar um pouco das funcionalidades das classes desenvovidas.
 * @author Ruan Rodrigues da Silva
 */
public class CoisaCLI {
	/**
	 * Objeto do tipo MenuDescanso, onde está presente um "menu" para as funcionalidades relacionados a classe Descanso.
	 */
	static MenuDescanso menuDescanso;
	
	/**
	 * Objeto do tipo MenuResumo, onde está presente um "menu" para as funcionalidades relacionados a classe RegistroResumos.
	 */
	static MenuResumo menuResumo;
	
	/**
	 * Objeto do tipo MenuMedia, onde está presente um "menu" para as funcionalidades relacionados a classe Disciplina.
	 */
	static MenuDisciplina menuDisciplina;
	
	/**
	 * Metodo onde inicializamos todos os objetos citados, e chamamos eles, cada qual com o metodo menu(), para começarem a inicializar.
	 * @param args
	 */
	public static void main(String[] args) {
		menuDescanso = new MenuDescanso();
		menuDisciplina =  new MenuDisciplina();
		menuResumo = new MenuResumo();
		int entrada = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("              CoisaCLI\n");
		
		
		do {
			menu();
			entrada = Integer.parseInt(sc.nextLine());
			
			if(entrada == 1) {
				menuResumo.menu();;
			} else if(entrada == 2) {
				menuDisciplina.menu();;
			} else if(entrada == 3) {
				menuDescanso.menu();
			} else {
				System.out.println("Entrada inválida.\n");
			}			
		} while(entrada != 4);	
	}
	
	/**
	 * Metodo onde fica o menu principal da "interface.
	 */
	private static void menu() {
		System.out.println("(1) Cadastrar resumo.");
		System.out.println("(2) Calcular media disciplina.");
		System.out.println("(3) Descanso.");
		System.out.println("(4) Sair.");

	}

}
