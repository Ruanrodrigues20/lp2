package usuario;

import java.util.*;

import compras.Compra;
import cupom.desconto.CupomDescontavel;

public class Usuario implements Comparable<Usuario>{
	private String nome;
	private String cpf;
	private Map<Integer, CupomDescontavel> cupons;
	private int iPosicao;
	private int cumponsValidos;
	
	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.cupons = new HashMap<>();
		this.iPosicao = 0;
		this.cumponsValidos = 0;
		verificaATT();
	}
	
	private void verificaATT() {
		if(this.nome == null || this.cpf == null) {
			throw new NullPointerException();
		}
		
		if(this.nome.isEmpty() || this.cpf.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return this.nome + " - " + cpf;
	}
	
	public String addCupomDesconto(CupomDescontavel cupom) {
		this.cupons.put(this.iPosicao, cupom);
		this.cumponsValidos++;
		return cupom.mostrarCupom() + "Guardado na posicao " + this.iPosicao++;
	}
	
	public String[] listarCupons() {
		String[] out = new String[this.cupons.size()];
		int i = 0;
		for(CupomDescontavel c : this.cupons.values()) {
			out[i++] = c.mostrarCupom();
		}
		return out; 
	}
	
	public CupomDescontavel PegarCupom(int posicao) {
		CupomDescontavel cupom = this.cupons.get(posicao);
		this.cumponsValidos--;
		return cupom;
	}
	
	public String statusCupons() {
		return toString() + "\n"  + (this.iPosicao + 1) + "cupons - " + this.cumponsValidos + " cupons ativos";
	}
	
	public int getQtdeCuponsTotal() {
		return this.cupons.size();
	}

	@Override
	public int compareTo(Usuario o2) {
		if(this.getQtdeCuponsTotal() > o2.getQtdeCuponsTotal()) {
			return -1;
		}
		
		if(this.getQtdeCuponsTotal() < o2.getQtdeCuponsTotal()) {
			return 1;
		}
		return 0;
	}
	
	
	
	
}
