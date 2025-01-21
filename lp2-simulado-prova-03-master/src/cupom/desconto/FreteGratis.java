package cupom.desconto;

import compras.Compra;

public class FreteGratis implements CupomDescontavel {
	
	private double maxDesconto;
	
	public FreteGratis(double maxDesconto) {
		this.maxDesconto = maxDesconto;
	}
	
	public FreteGratis() {
		this.maxDesconto =0;
	}
	
	@Override
	public String mostrarCupom() {
		if(this.maxDesconto == 0) {
			return "FreteGratis";
		}
		String out = "Desconto de até " + String.format("R$ %.2f", this.maxDesconto);
		out += "no Frete.";
		return out;
	}


	@Override
	public void aplicarDesconto(Compra compra) {
		double valor = compra.getValorFrete();
		double desconto = this.maxDesconto;
		double valorPosDesconto = valor - desconto;
		
		if(maxDesconto == 0) {
			compra.setValorFrete(0);
		}
		
		if(this.maxDesconto != 0 && valorPosDesconto >= 0) {
			compra.setValorFrete(valorPosDesconto);
		} else {
			compra.setValorFrete(0);
		}
	}

}
