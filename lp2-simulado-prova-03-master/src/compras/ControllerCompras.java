package compras;

import java.util.*;
import usuario.*;

public class ControllerCompras {
	private List<Compra> compras;

	public ControllerCompras() {
		this.compras = compras;
	}
	
	public int criarCompraEmUser(Usuario user, double valor, String produto, double ValorFrete) {
		this.compras.add(new Compra(user, valor, produto, ValorFrete));
		return (this.compras.size() - 1);
	}
	
	public Compra getCompra(int posicao) {
		return this.compras.get(posicao);
	}
}
