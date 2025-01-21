package br.edu.ufcg.computacao.mrbet;

import java.util.Scanner;

/**
 * Main para o sistema MrBet, onde vamos testar as funcionalidades da classe MrBetSistema
 * @author ruan.rodrigues.silva
 */
public class MainMrBet {
	/**
	 * Metodo main aonde instaciamos uma String, um scanner e um MrBetSistema que serão usados em todos o 
	 * a classe
	 * @param args
	 */
	public static void main(String[] args) {
		String escolha = "";
		Scanner scan = new Scanner(System.in);
		MrBetSistema mr = new MrBetSistema();
		
		while (true) {
			escolha = menu(scan);
			comando(escolha, scan, mr);
		}
	}

	/**
	 * Método que serve menu para o Main, onde sera mostrado as principais funcionalidades do sistema
	 * e o usuario irá escolher qual opção
	 * @param scan
	 * @return String
	 */
	private static String menu(Scanner scan) {
		System.out.print(
				"\n                  MENU\n" + 
						"\n(M)Minha inclusão de times\n" + 
						"(R)Recuperar time\n" + 
						"(.)Adiciona campeonato\n" +
						"(B)Bora incluir time em campeonato e Verificar se time está em\n campeonato\n" +
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(H)Histórico\n" +
						"(!)Já ṕde fechar o programa!"+
						"\n" + 
						"Opção> ");
		return scan.nextLine().toUpperCase();
	}
	
	/**
	 * Metodo que recebe a escolha e redereciona o fluxo de execução a respeito do escolha feita pelo
	 * usuário
	 * @param escolha
	 * @param scan
	 * @param mr
	 */
	private static void comando(String escolha, Scanner scan, MrBetSistema mr) {
		switch (escolha) {
		case "M":
			incluirTime(scan, mr);
			break;
		case "R":
			recuperaTime(scan, mr);
			break;
		case ".":
			adicionaCampeonato(scan, mr);
			break;
		case "B":
			timeCampeonato(scan, mr);
			break;
		case "E":
			exibirCampeonatoTime(scan, mr);
			break;
		case "T":
			tentarSorteStatus(scan, mr);
			break;
		case "H":
			historico(mr);
			break;
		case "!":
			sair(scan);
			break;
		}
	}

	

	/**
	 * Método para a funcionalidade incluir Time no campeoanato, onde recebemos o nome, codigo e o mascote de um time
	 * que queremos adicionar, verificando se a inclusão foi feita ou não
	 * @param scan
	 * @param mr
	 */
	private static void incluirTime(Scanner scan, MrBetSistema mr) {
		System.out.print("Código: ");
		String codigo = scan.next();
		scan.nextLine();
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Mascote: ");
		String mascote = scan.nextLine();
		if(mr.incluiTime(codigo, nome, mascote)) {
			System.out.println("INCLUSÃO REALIZADA!");
		} else {
			System.out.println("TIME JÁ EXITSTE");
		}
	}
	
	/**
	 * Método que serve para a funcionalidade de recuperar um filme representar ele visualmente,
	 * fazendo a busca por meio do código do time
	 * @param scan
	 * @param mr
	 */
	private static void recuperaTime(Scanner scan, MrBetSistema mr) {
		System.out.print("Código: ");
		String codigo = scan.nextLine();
		System.out.println(mr.recuperaTime(codigo));
	}

	/**
	 * Método que serve para a funcionalidade de adicionar um campeonato no sistema, por meio do seu nome
	 * e a quantidades de participantes
	 * @param scan
	 * @param mr
	 */
	private static void adicionaCampeonato(Scanner scan, MrBetSistema mr) {
		System.out.print("Campeonato: ");
		String nomeCampeonato = scan.nextLine();
		System.out.print("Participantes: ");
		String qtdeParticipantes = scan.next();
		scan.nextLine();
		System.out.println(mr.incluiCampeonato(nomeCampeonato, Integer.parseInt(qtdeParticipantes)));
	}
	
	/**
	 * Metodo para testar a funcionalidade que relaciona um time com um campeoanto
	 * @param scan
	 * @param mr
	 */
	private static void timeCampeonato(Scanner scan, MrBetSistema mr) {
		String opcao = menuCampeonato(scan);
		comandoCampeonato(opcao, mr, scan);
	}
	
	/**
	 * Método que serve como menu para as funcionalidades que relacionam um time e campeonato
	 * @param scan
	 * @return
	 */
	private static String menuCampeonato(Scanner scan) {
		System.out.println(
						"(I) Incluir time em campeonato "
						+ "ou "
						+ "(V) Verificar se time está em campeonato");
		
		return scan.next().toUpperCase();
	}
	
	/**
	 * Metodo para ler o comando a respeito da funcionalidade do menu de campeonatos
	 * @param opcao
	 * @param mr
	 * @param scan
	 */
	private static void comandoCampeonato(String opcao, MrBetSistema mr, Scanner scan) {
		switch(opcao) {
		case "I":
			incluirTimeCampeonato(scan, mr);
			break;
		case "V":
			verificaTimeCampeonato(scan, mr);
			break;
		default:
			System.out.println("ENTRADA INVÁLIDA!");
			break;
		}
	}
	
	/**
	 * Metodo referente a funcao de incluir um time em um campeonato
	 * @param scan
	 * @param mr
	 */
	private static void incluirTimeCampeonato(Scanner scan, MrBetSistema mr) {
		System.out.print("Código: ");
		String codigoTime = scan.next();
		scan.nextLine();
		System.out.print("Campeonato: ");
		String nomeCampeonato = scan.nextLine();
		System.out.println(mr.incluiTimeCampeonato(codigoTime, nomeCampeonato));
	}

	/**
	 * Metodo referente a responsabilidade de verificar se um time está em um campeonato
	 * @param scan
	 * @param mr
	 */
	private static void verificaTimeCampeonato(Scanner scan, MrBetSistema mr) {
		System.out.print("Código: ");
		String codigoTime = scan.next();
		scan.nextLine();
		System.out.print("Campeonato: ");
		String nomeCampeonato = scan.nextLine();
		System.out.println(mr.buscaTimeCampeonato(codigoTime, nomeCampeonato));
	}
	
	/**
	 * Metodo para exibir as funcionalidade se um time esta incluso em um campeonato
	 */
	private static void exibirCampeonatoTime(Scanner scan, MrBetSistema mr) {
		System.out.print("Codigo Time: ");
		String codigo = scan.next();
		scan.nextLine();
		
		String busca = mr.campeonatosQueTimeParticipa(codigo);
		System.out.println(busca);
	}
	
	/**
	 * Método para lidar com as apostas e o status das apostas, exibindo um menu apropriado.
	 * 
	 * @param scan Scanner para capturar a entrada do usuário.
	 * @param mr Instância do sistema MrBet.
	 */
	private static void tentarSorteStatus(Scanner scan, MrBetSistema mr) {
		String escolha = menuAposta(scan);
		comando(mr, scan, escolha);
	}
	
	/**
	 * Método que exibe o menu para apostar ou verificar o status das apostas.
	 * 
	 * @param scan Scanner para capturar a entrada do usuário.
	 * @return A escolha do usuário como uma String.
	 */
	private static String menuAposta(Scanner scan) {
		System.out.print(
							"(A)Apostar ou (S)Status das Apostas");
		String escolha = scan.nextLine();
		return escolha.toUpperCase();
	}
	
	/**
	 * Método que processa a escolha do usuário no menu de apostas e executa o comando correspondente.
	 * 
	 * @param mr Instância do sistema MrBet.
	 * @param scan Scanner para capturar a entrada do usuário.
	 * @param escolha A escolha do usuário como uma String.
	 */
	private static void comando(MrBetSistema mr, Scanner scan, String escolha) {
		switch(escolha){
		case "A": 
			fazerAposta(mr, scan);
			break;
		case "S": 
			StatusDasApostas(mr, scan);
			break;
		default:
			System.out.println("ENTRADA INVÁLIDA!");
			break;
		}
	
	}
	
	/**
	 * Método para realizar uma aposta. Solicita o código do time, o campeonato, a colocação desejada 
	 * e o valor da aposta ao usuário, e então chama o método apropriado no sistema MrBet.
	 * 
	 * @param mr Instância do sistema MrBet.
	 * @param scan Scanner para capturar a entrada do usuário.
	 */
	private static void fazerAposta(MrBetSistema mr, Scanner scan) {
		System.out.print("Código: ");
		String codigo = scan.next();
		scan.nextLine();
		
		System.out.print("Campeonato: ");
		String campeonato = scan.nextLine();
		
		System.out.print("Colocação: ");
		String colocao = scan.next();
		scan.nextLine();
		
		System.out.print("Valor da Apota: R$");
		String valorAposta = scan.next();
		scan.nextLine();
		
		System.out.println(mr.fazerAposta(codigo, campeonato, Integer.parseInt(colocao), Double.parseDouble(valorAposta)));
	}
	
	/**
	 * Método para exibir o status das apostas realizadas. Obtém o status das apostas do sistema MrBet
	 * e imprime cada aposta com seu índice.
	 * 
	 * @param mr Instância do sistema MrBet.
	 * @param scan Scanner para capturar a entrada do usuário (não utilizado diretamente neste método).
	 */
	private static void StatusDasApostas(MrBetSistema mr, Scanner scan) {
		String[] status = mr.statusDeApostas();
		int i = 1;
		for(String aposta: status) {
			System.out.println(i + ". " + aposta + "\n");
			i++;
		}
		
	}
	
	/**
	 * Método para exibir o histórico de times. Chama métodos que mostram times com base em diferentes critérios
	 * como participação em campeonatos e popularidade em apostas.
	 * 
	 * @param mr Instância do sistema MrBet.
	 */
	private static void historico(MrBetSistema mr) {
		timesMaisParticipa(mr);
		timesMenosParticipa(mr);
		timesMaisPopular(mr);
	}

	/**
	 * Método para exibir times que ainda não participaram de campeonatos. Obtém a lista de tais times 
	 * do sistema MrBet e imprime.
	 * 
	 * @param mr Instância do sistema MrBet.
	 */
	private static void timesMenosParticipa(MrBetSistema mr) {
		String[] historicoTime = mr.timesNaoParticipa();
		System.out.println("Ainda não participou de campeonato");
		for(String time: historicoTime) {
			System.out.println(time);
		}	
	}

	/**
	 * Método para exibir os times que mais participam de campeonatos. Obtém a lista de tais times
	 * do sistema MrBet e imprime.
	 * 
	 * @param mr Instância do sistema MrBet.
	 */
	private static void timesMaisParticipa(MrBetSistema mr) {
		String[] historicoTime = mr.timesMaisParticipa();
		System.out.println("Participação mais frequente em campeonatos");
		for(String time: historicoTime) {
			System.out.println(time);
		}
	}
	
	/**
	 * Método para exibir os times mais populares em apostas. Obtém a lista de tais times do sistema MrBet
	 * e imprime.
	 * 
	 * @param mr Instância do sistema MrBet.
	 */
	private static void timesMaisPopular(MrBetSistema mr) {
		String[] historicoTime = mr.timesPolularAposta();
		System.out.println("Popularidade em apostas");
		for(String time: historicoTime) {
			System.out.println(time);
		}
	}

	/**
	 * Método para fechar o programa. Fecha o scanner e exibe uma mensagem de encerramento antes de 
	 * encerrar a aplicação.
	 * 
	 * @param scanner Scanner a ser fechado.
	 */
	private static void sair(Scanner scanner) {
		scanner.close();
		System.out.println("\nPor hoje é só, pessoal!");
		System.exit(0);
	}

}

