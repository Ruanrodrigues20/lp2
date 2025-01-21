package br.edu.ufcg.computacao.p2lp2.coisa.cli;

import java.util.*;

import br.edu.ufcg.computacao.p2lp2.coisa.Descanso;

/**
 * Classe responsável por criar um objeto do tipo MenuDescanso, que serve para a interface de teste de funcionalidades
 * relacionada a classe Descanso.
 * @author Ruan Rodrigues da Silva.
 */
public class MenuDescanso{
	/**
	 * Declaração de um objeto do tipo Descanso.
	 */
	private Descanso descanso;
	
	/**
	 * Construtor da classe MenuDescanso, onde não tem nenhum parametro de entrada, apenas o papel de inicializar o objeto
	 * do tipo Descanso.
	 */
	public MenuDescanso() {
		this.descanso = new Descanso();
	}
	
	/**
	 * Metodo responsável pela interação com o usuario no menu de descanso da "interface".
	 */
	public void menu() {
		Scanner sc = new Scanner(System.in);
		 
		int escolha = 0;
		int entrada;
		
		do {
			System.out.println("1 - Cadastrar horas Descansadas.");
			System.out.println("2 - Definir numeros de semanas.");
			System.out.println("3 - Definir emoji.");
			System.out.println("4 - Verificar Status.");
			System.out.println("5 - Voltar ao menu.");
			System.out.print("Digite um comando: ");
			escolha = Integer.parseInt(sc.nextLine());
			
			if (escolha == 1) {
				System.out.print("Quantas horas? ");
				entrada = Integer.parseInt(sc.nextLine());
				this.descanso.defineHorasDescanso(entrada);
			} else if (escolha == 2) {
				System.out.print("Quantas Semanas? ");
				entrada = Integer.parseInt(sc.nextLine());
				this.descanso.defineNumeroSemanas(entrada);
			} else if (escolha == 3) {
				System.out.print("Digite um emoji: ");
				this.descanso.definirEmoji(sc.nextLine());
			} else if (escolha == 4) {
				System.out.println("Status: " + descanso.getStatusGeral() + "\n") ;
			}
			
		} while (escolha != 5 );
	}
	
}
