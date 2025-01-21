package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import filmnow.Filme;

/**
 * Classe para os testes da Classe Filme
 * @author Ruan Rodrigues da Silva
 */
class FilmeTest {
	/**
	 * Objeto do tipo filme que sera usado nos testes a seguir
	 */
    private Filme filmeBase;


    @BeforeEach
    void preparaFilmes() {
        this.filmeBase = new Filme("Avatar", "Disney+", "2009");
    }
    
    /**
     * Teste para o método nomeAno que retorna uma String com o nome e o ano do filme 
     */
    @Test
    void nomeAnoTest() {
       assertEquals( "Avatar, 2009", this.filmeBase.nomeAno());

    } 
   
    /**
     * Teste para o método equals, que leva em conta o nome do filme e o ano de lançamento.
     */
	@Test
	void equalsTest() {
		Filme filme1 = new Filme("Avatar", "Disney+", "2009");
		Filme filme2 = new Filme("Harry Potter", "Cinema", "2001");
		Filme filme3 = new Filme("Avatar", "Cinema", "2010");
		Filme filme4 = new Filme("Avatar2", "Disney+", "2009");
		assertFalse(filmeBase.equals(filme3));
		assertFalse(filmeBase.equals(filme4));
		assertTrue(filmeBase.equals(filme1));
		assertFalse(filmeBase.equals(filme2));
	}
	
	/**
	 * Teste do metodo toString que retorna a String com o nome do filme, ano e local de lançameto.
	 */
	@Test
	void toStringTest() {
		String out = "Avatar, 2009\nDisney+";
		assertEquals(out, filmeBase.toString());
	}
	
	/**
	 * Segundo teste do toString, aonde testamos para quando o ano de lançamento do filme é uma String vazia
	 */
	@Test
	void toStringTestAnoVazio() {
		Filme filme = new Filme("Harry Potter e a Pedra Filosofal", "Cinema", "");
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
		Filme filme = new Filme("Harry Potter e a Ordem da Fenix", "Cinema", "2007");
		assertFalse(filme.isHot());
		filme.atribuiHot();
		assertTrue(filme.isHot());
	}
	
	/**
	 * Teste que verificamos a funcionalidade de remover o hot de um filme
	 */
	@Test
	void removeHotFilme() {
		Filme filme = new Filme("Harry Potter e a Ordem da Fenix", "Cinema", "2007");
		filme.atribuiHot();
		filme.removeHotFilme();
		assertFalse(filme.isHot());
	}

	/**
	 * Teste para quando da um erro ao criar um filme com nome null
	 */
	@Test
	public void testNomeNull() {
	 try {
	     Filme filmeInvalido = new Filme(null, "Disney+", "2009");
	     fail("Uma exceção era esperada ao passar nome nulo");

	  } catch (NullPointerException npe) {
	       assertEquals("FILME NULO", npe.getMessage());
	  }
	}
	
	/**
	 * Teste aonde tentamos criar um filme com um local nulo e tratamos esse erro
	 */
	@Test
	public void testLocalLancamentoNull2() {
	 try {
	     Filme filmeInvalido = new Filme("Sei la", null, "2009");
	     fail("Uma exceção era esperada ao passat o local nulo");

	  } catch (NullPointerException npe) {
	       assertEquals("FILME NULO", npe.getMessage());
	  }
	}
	
	/**
	 * Teste aonde tentamos criar um filme com um nome sendo uma String vazia e tratamos esse erro
	 */
	@Test
	public void testNomeVazio(){
		try {
			Filme filmeInvalido = new Filme("", "Disney+",  "2009");
			fail("Uma exceção era esperada ao passar nome nulo");
		} catch (IllegalArgumentException npe){
			assertEquals("FILME INVALIDO",npe.getMessage());
		}
	}
}