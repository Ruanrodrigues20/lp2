package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author eliane
 * @author Ruan Rodrigues da Silva
 *
 */
public class MainFilmNow {
	/**
	 * Main aonde chamaremos todos os outros os metodos da interface
	 * @param args
	 */
	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" + 
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			atribuirHot(fn, scanner);
			break;
		case "R":
			removerHot(fn, scanner);
			break;
		case "S":
			sai(scanner);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {
		String[] filmes = fn.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if(filmes[i] != null) {
				System.out.println(formataFilme(i + 1, filmes[i]));
				}
			}
		}

	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = scanner.nextInt();
		System.out.println(fn.buscaFilme(posicao));
	}

	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, String filme) {
		return posicao + " - " + filme;
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		if (posicao > 0 && posicao <= 100) {
			System.out.print("Nome> ");
			String nome = scanner.nextLine();
			System.out.print("Ano> ");
			String ano = scanner.nextLine();
			System.out.print("Local> ");
			String local = scanner.nextLine();
			String out = fn.cadastraFilme(posicao, nome, ano, local);
			System.out.println(out);
		} else {
			System.out.println("POSIÇÃO INVÁLIDA");
		}	
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai(Scanner scanner) {
		scanner.close();
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
	/**
	 * Metodo aonde exibimos todos os filmes que estão na hotList do sistema FilmNow
	 * @param fn
	 */
	private static void exibirHotList(FilmNow fn) {
		String[] hotList = fn.exibirHotList();
		for (int i = 0; i < hotList.length; i ++) {
			System.out.println(formataFilme(i + 1, hotList[i]));
		}
		}
	
	/**
	 * Metodo aonde pegamos a posição de um filme para ser hot 
	 * @param fn
	 * @param sc
	 */
	private static void atribuirHot(FilmNow fn, Scanner sc){
		System.out.print("\nFilme> ");
		int filme = sc.nextInt();
		sc.nextLine();
		System.out.print("Posicao> ");
		int posicao = sc.nextInt();
		sc.nextLine();
		
		String condicao = fn.adicionaHotList(filme, posicao);
		System.out.println(condicao);
	}
	
	/**
	 * Método aonde pegamos uma posição de um filme para removermos da HotList do Sistema FilmNow
	 * @param fn
	 * @param sc
	 */
	private static void removerHot(FilmNow fn, Scanner sc) {
		System.out.print("\nPosicao> ");
		int posicao = sc.nextInt();
		sc.nextLine();
		fn.removeHotList(posicao);
	}
}
