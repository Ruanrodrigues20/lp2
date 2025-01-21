package br.edu.ufcg.computacao.mrbet;

import java.util.*;

/**
 * Classe do sistema da casa de apostas MrBet
 * @author ruan.rodrigues.silva
 */
public class MrBetSistema {
	private HashMap<String, Time> clubes;
	private HashMap<String, Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;
	
	/**
	 * Construtor do MrBetSistema aonde inicilizamos o atributos
	 */
	public MrBetSistema() {
		this.clubes = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Metodo que inclui o time em um campeonato recebendo o codigo do time, nome e nome do mascote
	 * verifica se o time ja existe no sistema, se não ele adiciona e retorna true, se não retorna false
	 * @param codigo
	 * @param nome
	 * @param mascote
	 * @return boolean
	 */
	public boolean incluiTime(String codigo, String nome, String mascote) {
		Time time = new Time(nome, codigo, mascote);
		
		if(!(this.clubes.containsKey(codigo))) {
			clubes.put(codigo, time);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que recebe o codigo de um time e verifica se esse time existe, se sim retorna a sua representação textual
	 * caso não é lançada uma execessão
	 * @param codigo
	 * @return String
	 */
	public String recuperaTime(String codigo) {
		if (this.clubes.containsKey(codigo)) {
			return this.clubes.get(codigo).toString();
		}
		throw new IllegalArgumentException("O TIME NÃO EXISTE!");
	}
	
	/**
	 * Metodo que recebe o nome e capacidade de um campeonato, verifica se ele existe e cria esse campeonato adicionado no sistema
	 * retornando uma String para mostrar se deu certo a inclusão
	 * @param nome
	 * @param capacidade
	 * @return String
	 */
	public String incluiCampeonato(String nome, int capacidade) {
		Campeonato c = new Campeonato(nome, capacidade);
		if(this.campeonatos.containsKey(nome.toUpperCase())) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		this.campeonatos.put(nome.toUpperCase(),c);
		return "CAMPEONATO ADICIONADO!"; 
		
	}
	
	/**
	 * Metodo que recebe o codigo do time e nome do campeonato, e verifica se eles existem, para adicionar o time no campeonato
	 * caso não retorna um excessão, no caso deles existes verifica se tem a capacidade suficiente e se o time já está no campeonato
	 * @param codigo
	 * @param nomeCampeonato
	 * @return String
	 */
	public String incluiTimeCampeonato(String codigo, String nomeCampeonato) {		
		timeExiste(codigo);
		campeonatoExiste(nomeCampeonato);
		
		Time time = this.clubes.get(codigo);
		if(this.campeonatos.get(nomeCampeonato.toUpperCase()).temTime(codigo)) {
			return "TIME JÁ INCLUÍDO NO CAMPEONATO!";
		}
		
		if (this.campeonatos.get(nomeCampeonato.toUpperCase()).adicionaTime(codigo, time)) {
			time.aumentaParticipacaoCampeonato();
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
		return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
	}
	
	
	/**
	 * Verifca se um time está em um campeonato, caso eles existam.
	 * @param codigo
	 * @param nomeCampeonato
	 * @return String
	 */
	public String buscaTimeCampeonato(String codigo, String nomeCampeonato) {
		timeExiste(codigo);
		campeonatoExiste(nomeCampeonato);
		
		if(!(this.campeonatos.get(nomeCampeonato.toUpperCase()).temTime(codigo))) {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}
		return "O TIME ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Metodo que verifica quais campeoanto o um time participa, caso ele exista
	 * @param codigo
	 * @return String
	 */
	public String campeonatosQueTimeParticipa(String codigo) {
		timeExiste(codigo);
		if(this.clubes.get(codigo).getParticipacaoCampeonato() == 0) {
			return "";
		}
		
		String out = "Campeonatos do " + this.clubes.get(codigo).getNome() + ":\n";
		for(Campeonato campeonato: this.campeonatos.values()) {
			if(campeonato.temTime(codigo)) {
				out += "* " + campeonato.toString() + "\n";
			}
		}
		return out.substring(0, out.length() - 1);
	}
	
	/**
	 * Metodo responsável por fazer uma aposta de um time, em um campeonato com uma colocação e o valor da aposta
	 * @param codigoTime
	 * @param campeonato
	 * @param colocao
	 * @param valorAposta
	 * @return String
	 */
	public String fazerAposta(String codigoTime, String campeonato, int colocao, double valorAposta) {
		timeExiste(codigoTime);
		campeonatoExiste(campeonato);
		Campeonato camp = campeonatos.get(campeonato.toUpperCase());
		
		
		if (camp.getQtdMaximaParticipantes() < colocao || colocao < 1 || !(camp.temTime(codigoTime))) {
			return "APOSTA NÃO REGISTRADA!";
		}
		
		Time t = this.clubes.get(codigoTime);
		
		if(colocao == 1) {
			t.aumentaparticipacaoApostaPrimeiroLugar();
		}
		
		Aposta aposta = new Aposta(t, camp, colocao, valorAposta);
		this.apostas.add(aposta);

		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Verifica se um time existe e lança uma excessão caso não exista
	 * @param codigoTime
	 */
	private void timeExiste(String codigoTime) {
		if(!this.clubes.containsKey(codigoTime)) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
	}
	
	/**
	 * Verifica se um campeonato existe e lança uma excessão caso não exista
	 * @param nomeCampeonato
	 */
	private void campeonatoExiste(String nomeCampeonato) {
		if(!this.campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
	}
	
	/**
	 * Retorna um array de String com a representação textual de todas as apostas feitas no Sistema
	 * @return String[]
	 */
	public String[] statusDeApostas() {
		String out[] = new String[this.apostas.size()];
		for(int i = 0; i < this.apostas.size(); i++) {
			out[i] = apostas.get(i).toString();
		}
		return out;
	}
	
	/**
	 * Metodo que retorna um array de String com a representação textual dos times que mais
	 * participam de campeonatos
	 * @return String[]
	 */
	public String[] timesMaisParticipa() {
		ArrayList<String> lista = buscaTimeMaisParticipacaoCamp();
		return converteListArray(lista);
	}
	
	/**
	 * Método que eu busco os times que participam de campeonatos e retorna uma lista com a representação 
	 * textual deles
	 * @return ArrayList<String>
	 */	
	private ArrayList<String> buscaTimeMaisParticipacaoCamp() {
		ArrayList<String> timeMaisParticipa = new ArrayList<String>();
		List<Time> times = new ArrayList<Time>(this.clubes.values());
		ComparaTimes ordenacao = new ComparaTimes();
		Collections.sort(times, ordenacao);
		
		if(times.get(0).getParticipacaoCampeonato() == 0) {
			return timeMaisParticipa;
		}
		
		timeMaisParticipa.add(times.get(0).toStringParticipacaoCamp());
		for(int i = 1; i < times.size(); i++) {
			if(times.get(i).getParticipacaoCampeonato() < times.get(0).getParticipacaoCampeonato()) {
				break;
			}
			timeMaisParticipa.add(times.get(i).toStringParticipacaoCamp());
		}
		return timeMaisParticipa;	
	}
	
	/**
	 * Método que converte uma lista de String em um array de String
	 * @param lista
	 * @return String[]
	 */
	private String[] converteListArray(ArrayList<String> lista) {
		String[] array = new String[lista.size()];
		for(int i = 0; i < lista.size(); i++) {
			array[i] = lista.get(i);
		}
		return array;
	}
	
	/**
	 * Metodo que retorna um array de String com a representação textual dos times que menos
	 * participam de campeonatos
	 * @return
	 */
	public String[] timesNaoParticipa() {
		ArrayList<String> lista = buscaTimeMenosParticipacaoCamp();
		return converteListArray(lista);
	}

	/**
	 * Método que eu busco os times que menos participam de campeonatos e retorna uma lista com a representação 
	 * textual deles
	 * @return ArrayList<String>
	 */
	private ArrayList<String> buscaTimeMenosParticipacaoCamp() {
		ArrayList<String> timeMenosParticipa = new ArrayList<String>();
		int maior = 0; 
		for (Time time: this.clubes.values()) {
			if(time.getParticipacaoCampeonato() == 0) {
				timeMenosParticipa.add(time.toString());
			}
		}
		return timeMenosParticipa;	
	}
	
	/**
	 * Método que eu retorno a representação textual do time pela popularidades com as apostas
	 * em que ele apostaram que ele ficaria em primeiro lugar no campeonato 
	 * @return String[]
	 */
	public String[] timesPolularAposta() {
		ArrayList<String> lista = buscaTimesMaisPopular();
		return converteListArray(lista);
	}
	
	/**
	 * Método que eu faço a busca dos times pela a sua popularidade em apostas e retorno uma lista com os times que ficaram
	 * em primeiro lugar nas apostas, com a quantidades de vezes que isso aconteceu
	 * @return
	 */
	private ArrayList<String> buscaTimesMaisPopular() {
		ArrayList<String> timeMaisPopular = new ArrayList<String>();
		for(Time time: this.clubes.values()) {
			if(time.getparticipacaoApostaPrimeiroLugar () > 0) {
				timeMaisPopular.add(time.getNome() + " / " + time.getparticipacaoApostaPrimeiroLugar());
			}
		}
		return timeMaisPopular;
	}
}
	