package cupom.desconto;

import compras.Compra;

public class DescontoProgessivo implements CupomDescontavel{

	public DescontoProgessivo() {}
	
	@Override
	public String mostrarCupom() {
		String out =  "Desconto Progressivo, 1%, 5% ou 10%";
		return out;
	}

	@Override
	public void aplicarDesconto(Compra compra) {
		double valor = compra.getValor();
		if (valor <= 100) {
			compra.setValor(valor - (valor * (1/100))); 
		}
		
		if(valor > 100 && valor <= 500) {
			compra.setValor(valor - (valor * (5/100))); 
		}
		
		if(valor > 500) {
			compra.setValor(valor - (valor * (10/100))); 
		}
	}

}
