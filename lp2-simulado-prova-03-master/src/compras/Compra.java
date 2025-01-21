package compras;

import java.util.*;

import usuario.Usuario;


public class Compra {
	private double valor;
	private String produto;
	private double valorFrete;
	private Usuario user;
	
	
	public Compra( Usuario user, Double valor, String produto, double valorFrete) {
		this.valor = valor;
		this.produto = produto;
		this.valorFrete = valorFrete;
		this.user = user;
	}


	@Override
	public int hashCode() {
		return Objects.hash(produto, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(produto, other.produto)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getValorFrete() {
		return valorFrete;
	}


	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	@Override
	public String toString() {
		return "Compra: , valor=" + valor + ", produto=" + produto;
	}


	public Usuario getUser() {
		return user;
	}

	
	
	
	
	
	
}
