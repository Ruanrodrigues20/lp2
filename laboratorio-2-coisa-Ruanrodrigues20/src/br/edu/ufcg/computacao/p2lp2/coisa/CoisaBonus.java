package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Classe responsável por testar as novas funcionalidades implementas nas Classes Descanso, Disciplina, RegistroDeResumos
 * e RegistroTempoOnline
 * @author Ruan Rodrigues da Silva
 */
public class CoisaBonus {
	public static void main(String[] args) {
		registrarResumos();
		registrarDescanso();
		disciplinas();
	}
	
	public static void registrarResumos() {
		RegistroResumos resumos = new RegistroResumos(5);
		resumos.adiciona("objeto", "instancia de uma classe");
		resumos.adiciona("Classe", "Bloco de codigo");
		String[] busca = resumos.busca("de");
		System.out.println(Arrays.toString(busca));
	}
	
	public static void registrarDescanso() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(30);
		descanso.defineNumeroSemanas(1);
		descanso.definirEmoji(":(");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		descanso.definirEmoji("*_*");
		System.out.println(descanso.getStatusGeral());
	}
	
	public static void disciplinas() {
		int [] pesos = {6, 4};
		Disciplina prog = new Disciplina("p2", 2, pesos);
		prog.cadastraNota(1, 10);
		prog.cadastraNota(2, 10);
		prog.cadastraHoras(60);
		System.out.println(prog.aprovado());
		System.out.println(prog);
	}
}