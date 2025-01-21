package cupom.desconto;

import compras.Compra;

public interface CupomDescontavel {
	String mostrarCupom();
	void aplicarDesconto(Compra compra);
}
