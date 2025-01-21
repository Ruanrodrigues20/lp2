package br.edu.ufcg.computacao.mrbet;

import java.util.Comparator;
/**
 * Criação da classe ordenação com intuito de implementar o Compare da interface Comparator
 * @author ruan.rodrigues.silva
 */
public class ComparaTimes implements Comparator<Time>{

	@Override
	public int compare(Time time1, Time time2) {
		if(time1.getParticipacaoCampeonato() < time2.getParticipacaoCampeonato()) {
			return 1;
		}
		
		if(time1.getParticipacaoCampeonato() > time2.getParticipacaoCampeonato()) {
			return -1;
		}
		return 0;
	}

}
