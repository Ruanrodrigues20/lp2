package xabum;

import compras.ControllerCompras;
import cupom.desconto.CupomDescontoController;
import usuario.UsuarioController;

public class XaBumDescontosSistema {
	private UsuarioController controllerUser;
	private CupomDescontoController controllerCupom;
	private ControllerCompras controllerCompra;
	
	public XaBumDescontosSistema() {
		this.controllerUser = new UsuarioController();
		this.controllerCupom = new CupomDescontoController();
		this.controllerCompra = new ControllerCompras();
	}
	
	public String criarCupomFreteGratis(double maxDesconto) {
		return this.controllerCupom.criaCupomFreteGratis(maxDesconto);
	}
	
	public String criarCupomFreteGratis() {
		return this.controllerCupom.criaCupomFreteGratis();
	}
	
	public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto) {
		return this.controllerCupom.criaCupomDescontoFixo(percentualDesconto, maxDesconto);
	}
	
	public String criarCupomDescontoProgessivo() {
		return this.controllerCupom.criaCupomDescontoProgressivo();
	}
	
	public String adicionaUsuario(String cpf, String nome) {
		return this.controllerUser.adicionaUsuario(cpf, nome);
	}
	
	public String addCupomUsuario(String cpf, int indexCupom) {
		return this.controllerCupom.addCupomUsuario(this.controllerUser.getUser(cpf), indexCupom);
	}
	
	public String[] listarCuponsUsuario(String cpf) {
		return this.controllerUser.listarCuponsUsuario(cpf);
	}
	
	public String[] listarUsuariosPorNome() {
		return this.controllerUser.listarUsuarioPorNome();
	}
	
	public String[] listarUsuariosPorCuponsTotal() {
		return this.controllerUser.listarUsuariosPorCuponsTotais();
	}
	
	public void addCompra(String cpf, double valor, String produto, double valorFrete) {
		this.controllerCompra.criarCompraEmUser(this.controllerUser.getUser(cpf), valor, produto, valorFrete);
	}
}
