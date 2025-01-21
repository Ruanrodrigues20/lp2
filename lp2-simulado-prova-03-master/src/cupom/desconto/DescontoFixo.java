package cupom.desconto;

import compras.Compra;

public class DescontoFixo implements CupomDescontavel {
	private double percentualDesconto;
	private double maxDesconto;
	
	public DescontoFixo(Double percentualDesconto, double maxDesconto) {
		this.percentualDesconto = percentualDesconto;
		this.maxDesconto = maxDesconto;
	}
	
	@Override
	public String mostrarCupom() {
		String out = "Desconto Fixo de " + this.percentualDesconto + "%, até no máximo " + String.format("R$ %.2f", this.maxDesconto);
		return out;
	}
	
	
	@Override
	public void aplicarDesconto(Compra compra) {
		double valor = compra.getValor();
		double desconto = (valor * (this.percentualDesconto/100));
		double valorPosDesconto = valor - desconto;
		if((desconto <= this.maxDesconto && valorPosDesconto >= 0)){
			compra.setValor(valorPosDesconto);
		} 
		
		if (valorPosDesconto < 0){
			compra.setValor(0);
		}
	}

}
