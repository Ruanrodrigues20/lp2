package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmeBonus;

/**
 * Classe para os teste da classe FilmeBonus
 * @author Ruan Rodrigues da Silva
 */
class FilmeBonusTest {
	
	/**
	 * Objeto do tipo FilmeBonus para realização dos testes
	 */
	private FilmeBonus filme;
	
	/**
	 * Objeto do tipo FilmeBonus para realização dos testes
	 */
	private FilmeBonus filmeBase;
	
	/**
	 * Inicialização dos Objetos do tipo FilmeBonus para realização dos testes
	 */
	@BeforeEach
	void initFilmeBonus() {
		filme = new FilmeBonus("Harry Potter e a Câmera Secreta", "2003");
		filmeBase = new FilmeBonus("Avatar", "Disney+", "2009");
	}
	
	/**
	 * Teste do toString com a funcionalidade de adicionar local, onde apenas adicionamos o filme
	 * com um local
	 */
	@Test
	void toStringTest() {
		String out = "Harry Potter e a Câmera Secreta, 2003";
		assertEquals(out, filme.toString());
	}
	
	/**
	 * Teste do toString com a funcionalidade de adicionar local, onde mais de um local ao filme
	 */
	@Test
	void toStringTest2() {
		String out = "Harry Potter e a Câmera Secreta, 2003\nCinema, HBO MAX";
		filme.adicionaLocal("Cinema", 0);
		filme.adicionaLocal("HBO MAX", 1);
		assertEquals(out, filme.toString());
	}
	
	/**
	 * Teste que verificamos se o metodo adicionaLocal está adicionando da forma certa, ele retorna um boolean mostrado
	 * se deu certo ou não
	 */
	@Test
	void adicionaLocalTest() {
		assertTrue(filme.adicionaLocal("Cinema", 0));
		assertTrue(filme.adicionaLocal("HBO MAX", 1));
		assertTrue(filme.adicionaLocal("PRIME", 2));
	}
	
	/**
	 * Teste aonde verificamos se o metodo não está adicionando os locais, pois estamos tentantdo adicionar com posições inválidas
	 */
	@Test
	void adicionaLocalPosicaoInvalidaTest() {
		assertFalse(filme.adicionaLocal("Cinema", -1));
		assertFalse(filme.adicionaLocal("HBO MAX", 6));
	}
	
	/**
	 * Teste aonde removemos um local do array de locais do filme, onde não pode ser possivel pois o filme
	 * so possui um local.
	 */
	@Test
	void removeLocalTest() {
		filme.adicionaLocal("Cinema", 0);
		assertFalse(filme.removeLocal(0));
	}
	
	/**
	 * Teste aonde sobrescevemos um local, adicionamos outro e removemos o local da primeira posição.
	 */
	@Test
	void removeLocalTest2() {
		filme.adicionaLocal("Cinema", 0);
		filme.adicionaLocal("HBO MAX", 1);
		assertTrue(filme.removeLocal(0));
	}
	
	/**
     * Teste para o método nomeAno que retorna uma String com o nome e o ano do filme 
     */
    @Test
    void nomeAnoTest() {
       assertEquals( "Harry Potter e a Câmera Secreta, 2003", this.filme.nomeAno());
    } 
    
    /**
     * Teste para o método equals, que leva em conta o nome do filme e o ano de lançamento.
     */
	@Test
	void equalsTest() {
		FilmeBonus filme1 = new FilmeBonus("Harry Potter e a Câmera Secreta", "2003");
		FilmeBonus filme2 = new FilmeBonus("Harry Potter", "Cinema", "2001");
		FilmeBonus filme3 = new FilmeBonus("Avatar", "Cinema", "2010");
		FilmeBonus filme4 = new FilmeBonus("Avatar2", "Disney+", "2009");
		assertFalse(filme.equals(filme3));
		assertFalse(filme.equals(filme4));
		assertTrue(filme.equals(filme1));
		assertFalse(filme.equals(filme2));
	}
	
	/**
	 * Segundo teste do toString, aonde testamos para quando o ano de lançamento do filme é uma String vazia
	 */
	@Test
	void toStringTestAnoVazio() {
		FilmeBonus filme = new FilmeBonus("Harry Potter e a Pedra Filosofal", "Cinema", "");
		String out = "Harry Potter e a Pedra Filosofal\nCinema";
		assertEquals(out, filme.toString());
	}
	
	/**
	 * Teste do método filmeHot aonde verifamos a funcionalidade so filmeHot que retorna uma String pra quando o filme
	 * é hot.
	 */
	@Test
	void filmeHotTest() {
		String out = "Avatar, " + "2009\nDisney+";
		assertEquals(out, filmeBase.filmeHot());
		filmeBase.atribuiHot();
		String out2 = "🔥"+ "Avatar, " + "2009\nDisney+";
		assertEquals(out2, filmeBase.filmeHot());
		filmeBase.removeHotFilme();
		assertEquals(out, filmeBase.filmeHot());
	}
	
	/**
	 * Teste que verificamos a funcionalidade de atribuir que um filme é hot
	 */
	@Test
	void atribuiHotTest() {
		FilmeBonus filme = new FilmeBonus("Harry Potter e a Ordem da Fenix", "Cinema", "2007");
		assertFalse(filme.isHot());
		filme.atribuiHot();
		assertTrue(filme.isHot());
	}
	
	/**
	 * Teste que verificamos a funcionalidade de remover o hot de um filme
	 */
	@Test
	void removeHotFilme() {
		FilmeBonus filme = new FilmeBonus("Harry Potter e a Ordem da Fenix", "Cinema", "2007");
		filme.atribuiHot();
		filme.removeHotFilme();
		assertFalse(filme.isHot());
	}

}
