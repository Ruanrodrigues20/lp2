package cupom.desconto;

import java.util.*;

import compras.Compra;
import usuario.Usuario;

public class CupomDescontoController {
	private Map<Integer ,CupomDescontavel> cupons;
	private int iPosicao;
	
	public CupomDescontoController() {
		this.cupons = new HashMap<>();
		this.iPosicao = 0;
	}
	
	public String criaCupomFreteGratis(double maxDesconto){
		CupomDescontavel cupom = new FreteGratis(maxDesconto);
		return addCupom(cupom);
	}
	
	public String criaCupomFreteGratis(){
		CupomDescontavel cupom = new FreteGratis();
		return addCupom(cupom);
	}
	
	public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto){
		CupomDescontavel  cupom = new DescontoFixo(percentualDesconto, maxDesconto);
		return addCupom(cupom);
	}
	
	public String criaCupomDescontoProgressivo(){
		CupomDescontavel  cupom = new DescontoProgessivo();
		return addCupom(cupom);
	}
	
	public String addCupomUsuario(Usuario user, int indexCupom) {
		return user.addCupomDesconto(this.cupons.get(indexCupom));
	}
	
	public String[] mostrarCuponsUsuario(Usuario user) {
		return user.listarCupons();
	}
	
	
	private String addCupom(CupomDescontavel cupom) {
		this.cupons.put(this.iPosicao, cupom);
		String out = cupom.mostrarCupom() + " Guardado na posicao " + this.iPosicao++;
		return out;
	}
	
	
	public String aplicarDescontoCompra(Compra minhaCompra, int indexCupomUsuario) {
		minhaCompra.getUser().PegarCupom(indexCupomUsuario).aplicarDesconto(minhaCompra);
		return minhaCompra.getUser().statusCupons();
	}
	
	
	
}
