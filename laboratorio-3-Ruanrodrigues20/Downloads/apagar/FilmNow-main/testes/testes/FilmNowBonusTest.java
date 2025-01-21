package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import filmnow.FilmNowBonus;

/**
 * Classe responsável por testar as principais funcionalidades da classe FilmNow
 * @author Ruan Rodrigues da Silva
 */
class FilmNowBonusTest {
	/**
	 * Objeto do tipo FilmNow que usaremos nos testes adiante
	 */
	private static FilmNowBonus fn;
	
	/**
	 * Metodo aonde inicializamos o objeto fn, onde sera inicializado a cada teste feito
	 */
	@BeforeEach
	void initFilmeNow() {
		fn = new FilmNowBonus();
	}
	
	/**
	 * Teste a respeito da cadastrar um filme no sistema. Onde passo os parâmetros e o retorno esperado
	 * é uma String mostrando que o filme foi adicionado.
	 */
	@Test
	void cadastraFilmeTest() {
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(2, "20 dias em Mariupol", "2023", "Cinema"));
	}
	
	/**
	 * Teste aonde cadastramos um filme faltando o ano de lançamento, onde deve ser cadastrado.
	 */
	@Test
	void cadastraFilmeTest2() {
		assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema"));
		assertEquals("FILME ADICIONADO", fn.cadastraFilme(2, "Harry Potter", "", "Cinema"));
		assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "", "Cinema"));
	}
	
	/**
	 * Teste aonde tentamos cadastrar um filme com o nome sendo vazio
	 */
	@Test
	void cadastraFilmeTest3() {
		assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "", "2020", "Cinema"));
		assertEquals("FILME INVALIDO", fn.cadastraFilme(2, "", "", "Cinema"));
		assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "", "2000", "Cinema"));
	}
	
	/**
	 * Teste aonde tentamos cadastrar um filme com o local de lançamento sendo vazio
	 */
	@Test
	void cadastraFilmeTest4() {
		assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "Avatar 2", "2022", ""));
		assertEquals("FILME INVALIDO", fn.cadastraFilme(2, "Avatar", "2009", ""));
		assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", ""));
	}
	
	/**
	 * Caso de teste aonde vamos testamos adicionar um filme nos limites do tamanho especificado no sistema.
	 */
	@Test
	void cadastraFilmeTest5() {
		assertEquals("POSIÇÃO INVÁLIDA",  fn.cadastraFilme(0, "Avatar", "2009", "Disney+"));
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(100, "Avatar", "2009", "Disney+"));
		assertEquals("POSIÇÃO INVÁLIDA",  fn.cadastraFilme(101, "Avatar", "2009", "Disney+"));
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(1, "Avatar2", "2022", "Cinema"));
	}
	
	/**
	 * Teste aonde adiciono um filme e tento adicionar ele novamente na mesma posição e em posiçôes diferentes.
	 * Aonde o metodo cadastraFilme não vai cadastra-lo e informar que o filme já foi adicionado.
	 */
	@Test
	void cadastraFilmeNovamenteTest() {
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
		assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(2, "Avatar", "2009", "Disney+"));
		assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(2, "Avatar", "2009", "Popcornflix"));
		assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(3, "Avatar", "2009", "Popcornflix"));
	}
	
	/**
	 * Teste aonde tento adicionar o mesmo filme novamente, mas mudando o local de lançamento, aonde também não
	 * deve ser possivel o cadastro do filme no sistema, pois ele já está nele.
	 */
	@Test
	void cadastraFilmeNovamenteTest2() {
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
	}
	
	
	/**
	 * Teste aonde tento adicionar o mesmo filme novamente, mas mudando o local de lançamento e posição diferente, 
	 * aonde também não deve ser possivel o cadastro do filme no sistema, pois ele já está nele.
	 */
	void cadastraFilmeNovameteTest3() {
		assertEquals("FILME ADICIONADO",  fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
		assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(2, "Avatar", "2009", "Popcornflix"));
		assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(3, "Avatar", "2009", "Cinema"));
	}
	
	/**
	 * Teste aonde vamos testar o retorno do metodo detalharFilme, aonde ele deve retornar o nome do filme,
	 * ano de lançamento e local de lançamento.
	 */
	@Test
	void detalharFilmeTest() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraFilme(2, "Harry Potter", "2001", "Cinema");
		assertEquals("Avatar, 2009\nDisney+",fn.buscaFilme(1));
		assertEquals("Harry Potter, 2001\nCinema", fn.buscaFilme(2));
	}
	
	/**
	 * Teste aonde vamos verifar o detalhaFilme para filmes que não tem o ano espeficado
	 */
	@Test
	void detalhaFilmeTest2() {
		fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
		assertEquals("20 dias em Mariupol\nCinema", fn.buscaFilme(1));
		assertEquals("", fn.buscaFilme(100));
	}
	
	/**
	 * Teste aonde tentamos detalhar um filme em uma posição inválida
	 */
	@Test
	void detalhaFilmeTest3() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.buscaFilme(0));
		assertEquals("POSIÇÃO INVÁLIDA", fn.buscaFilme(101));
	}
	
	/**
	 * Teste aonde tentamos detalhar um filme de uma posição vazia do sistema
	 */
	@Test
	void detalhaFilmeTest4() {
		assertEquals("", fn.buscaFilme(1));
		assertEquals("", fn.buscaFilme(100));
		assertEquals("", fn.buscaFilme(50));
	}
	
	/**
	 * Teste de detalhaFilme aonde vamos verificar para um filme Hot
	 */
	@Test
	void detalhaFilmeTest5() {
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");
		fn.cadastraFilme(2, "Harry Potter e a Câmara Secreta", "2002", "Cinema");
		fn.adicionaHotList(1, 1);
		fn.adicionaHotList(2, 2);
		assertEquals("🔥Harry Potter, 2001\nCinema", fn.buscaFilme(1));	
		assertEquals("🔥Harry Potter e a Câmara Secreta, 2002\nCinema", fn.buscaFilme(2));
	}
	
	/**
	 * Teste aonde vamos tentar adicionar um filme a hotList com o metodo adicionaHotList
	 */
	@Test
	void adicionaHotListTest() {
		fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", "Cinema");
		fn.cadastraFilme(2, "Harry Potter e a Câmara Secreta", "2002", "Cinema");
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 1", fn.adicionaHotList(1, 1));
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 2", fn.adicionaHotList(2, 2));
	}
	
	/**
	 * Teste aonde vamos tentar sobrescer um filme na hotList com o metodo adicionaHotList, aonde deve remover
	 * o emoji de hot do filme antigo, e remove-lo da hotList
	 */
	@Test
	void adicionaHotListTest2() {
		fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", "Cinema");
		fn.cadastraFilme(2, "Harry Potter e a Câmara Secreta", "2002", "Cinema");
		fn.adicionaHotList(1, 1);
		fn.adicionaHotList(2, 1);
		assertEquals("Harry Potter e a Pedra Filosofal, 2001\nCinema", fn.buscaFilme(1));	
		assertEquals("🔥Harry Potter e a Câmara Secreta, 2002\nCinema", fn.buscaFilme(2));

	}
	
	/**
	 * Teste adicionar um filme mais de uma vez na hotList
	 */
	@Test
	void adicionaHotListTest3() {
		fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", "Cinema");
		fn.adicionaHotList(1, 1);
		assertEquals("FILME JÁ ADICIONADO A HOTLIST", fn.adicionaHotList(1, 2));

	}
	
	/**
	 * Teste adicionar um filme mais de uma vez na hotList na mesma posição
	 */
	@Test
	void adicionaHotListTest4() {
		fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", "Cinema");
		fn.adicionaHotList(1, 1);
		assertEquals("FILME JÁ ADICIONADO A HOTLIST", fn.adicionaHotList(1, 1));
	}
	
	/**
	 * Teste de adicionar um filme em uma posicao inválida da hotList
	 */
	@Test
	void adicionaHotListTest5() {
		fn.cadastraFilme(1, "Harry Potter e a Pedra Filosofal", "2001", "Cinema");
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 0));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 11));
	}
	
	/**
	 * Teste de adicionar um filme que não existe na hotList
	 */
	@Test
	void adicionaHotListTest6() {
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 1));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 2));
	}
	
	/**
	 * Teste de adicionar um filme que não existe na hotList nos limite do tamanho da hotList
	 */
	@Test
	void adicionaHotListTest7() {
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 11));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(1, 0));
	
	}
	
	/**
	 * Teste de adicionar um filme de posição inválida que não existe na hotList nos limites do tamanho
	 * da hotList
	 */
	@Test
	void adicionaHotListTest8() {
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(0, 0));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(101, 0));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(100, 0));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(0, 1));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(101, 11));
		assertEquals("POSIÇÃO INVÁLIDA!", fn.adicionaHotList(100, 11));
	}
	
	/**
	 * Removendo um filme da hotList com o método removeHotList
	 */
	@Test
	void removeHotTest() {
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");		
		fn.adicionaHotList(1, 1);	
		fn.removeHotList(1);
		assertEquals("Harry Potter, 2001\nCinema", fn.buscaFilme(1));
		
	}
	
	/**
	 * Removendo varios filmes da hotList com o método removeHotList
	 */
	@Test
	void removeHotTest2() {
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");
		fn.cadastraFilme(2, "Harry Potter 2", "2003", "Cinema");
		fn.adicionaHotList(1, 1);	
		fn.adicionaHotList(2, 2);
		fn.removeHotList(1);
		assertEquals("Harry Potter, 2001\nCinema", fn.buscaFilme(1));
		fn.removeHotList(2);
		assertEquals("Harry Potter 2, 2003\nCinema", fn.buscaFilme(2));
	}
	
	/**
	 * Teste de remover um filme de posição inválida hotList
	 */
	@Test
	void removeHotTest3() {
		fn.removeHotList(1);
		fn.removeHotList(2);
	}
	
	
	/**
	 * Teste do metodo que exibirHotList que retorna um array de array de String das informações do filmes da hotList
	 */
	
	@Test 
	void exibirHotListTest() {
		String[] hotList = {"Harry Potter, 2001", "Harry Potter 2, 2003", "Harry Potter 3, 2005"};
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");
		fn.cadastraFilme(2, "Harry Potter 2", "2003", "Cinema");
		fn.cadastraFilme(3, "Harry Potter 3", "2005", "Cinema");
		fn.adicionaHotList(1, 1);	
		fn.adicionaHotList(2, 2);
		fn.adicionaHotList(3, 3);
		assertArrayEquals(hotList, fn.exibirHotList());
	}
	
	/**
	 * Teste de exibir a hotList vazia
	 */
	@Test
	void exibirHotListTest2() {
		String[] hotListVazia = {};
		assertArrayEquals(hotListVazia, fn.exibirHotList());
	}
	
	/**
	 * Teste de exibir a hotList com apenas um filme
	 */
	@Test 
	void exibirHotListTest3() {
		String[] hotList = {"Harry Potter, 2001"};
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");
		fn.adicionaHotList(1, 1);	
		assertArrayEquals(hotList, fn.exibirHotList());
	}	
	
	/**
	 * Teste de exibir a hotList sobrepondo os filmes dela
	 */
	@Test
	void exibirHotListTest4() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraFilme(2, "Harry Potter", "2001", "Cinema");	
		fn.adicionaHotList(1, 1);
		fn.adicionaHotList(2, 1);
		String[] hotList = {"Harry Potter, 2001"};
		assertArrayEquals(hotList, fn.exibirHotList());
	}	
	
	/**
	 * Teste que removeo um filme da lista e esse time também deve ser removido da hotList caso ele esteja lá.
	 */
	@Test
	void removeFilmeTest() {
		fn.cadastraFilme(1, "Harry Potter", "2001", "Cinema");
		assertTrue(fn.removeFilme(1));
	}
	
	/**
	 * Teste aonde tentamos buscar um filme pelo o nome
	 */
	@Test
	void buscaFilmeNomeTest() {
		String[] out = {"Harry Potter\nCinema"};
		fn.cadastraFilme(2, "Harry Potter", "", "Cinema");
		assertArrayEquals(out, fn.buscaFilmeNome("Harry Potter"));
	}
	
	/**
	 * Teste aonde tentamos buscar mais de um filme pelo o nome
	 */
	@Test
	void buscaFilmeNomeTest2() {
		String[] out = {"Harry Potter\nCinema", "Harry Potter, 2001\nHBO"};
		fn.cadastraFilme(2, "Harry Potter", "", "Cinema");
		fn.cadastraFilme(3, "Harry Potter", "2001", "HBO");
		assertArrayEquals(out, fn.buscaFilmeNome("Harry Potter"));
	}
	
	/**
	 * Teste aonde tentamos buscar um filme pelo o nome, mas não existe nenhum com esse nome
	 */
	@Test
	void buscaFilmeNomeTest3() {
		String[] out = new String[0];
		assertArrayEquals(out, fn.buscaFilmeNome("Harry Potter"));
	}
	
	/**
	 * Teste aonde buscamos varios filmes que foram lançados no mesmo lugar
	 */
	@Test
	void buscaFilmeLocalLancamentoTest() {
		String[] out = {"Harry Potter 1\nCinema", "Harry Potter 2, 2001\nCinema"};
		fn.cadastraFilme(2, "Harry Potter 1", "", "Cinema");
		fn.cadastraFilme(3, "Harry Potter 2", "2001", "Cinema");
		assertArrayEquals(out, fn.buscaFilmeLocalLancamento("Cinema"));
	}
	
	/**
	 * Teste aonde buscamos filmes que foram lançados no mesmo lugar, mas que não há nenhum com esse lugar
	 */
	@Test
	void buscaFilmeLocalLancamentoTest2() {
		String[] out = new String[0];
		fn.cadastraFilme(2, "Harry Potter 1", "2001", "Cinema");
		fn.cadastraFilme(3, "Harry Potter 2", "2003", "Cinema");
		assertArrayEquals(out, fn.buscaFilmeLocalLancamento(""));
	}
	
	/**
	 * Teste aonde fazemos a busca de um filme por seu local de lançamento
	 */
	@Test
	void buscaFilmeLocalLancamentoTest3() {
		String[] out = {"Harry Potter\nCinema"};
		fn.cadastraFilme(2, "Harry Potter", "", "Cinema");
		assertArrayEquals(out, fn.buscaFilmeLocalLancamento("Cinema"));
	}
	
	 /**
     * Testa a adição de um filme a um local válido.
     * Neste teste, um filme é cadastrado e, em seguida, é adicionado ao local "HBO MAX" na posição 1.
     * Espera-se que o método `adicionaLocalFilme` retorne verdadeiro, indicando que a adição foi bem-sucedida.
     */
    @Test
    void adicionaLocalFilmeTest() {
        fn.cadastraFilme(1, "Harry Potter 1", "2001", "Cinema");
        assertTrue(fn.adicionaLocalFilme("HBO MAX", 1, 1));
    }
    
    /**
     * Testa a adição de um filme a um local com nome inválido (string vazia).
     * Neste teste, um filme é cadastrado e tenta-se adicionar o filme a um local com nome vazio.
     * Dependendo da implementação do método `adicionaLocalFilme`, isso pode ser considerado válido.
     * Neste caso, espera-se que o método retorne verdadeiro, assumindo que a string vazia é aceita como local válido.
     * Caso contrário, o teste pode precisar ser revisado se o comportamento esperado for diferente.
     */
    @Test
    void adicionaLocalFilmeNullTest() {
        fn.cadastraFilme(1, "Harry Potter 1", "2001", "Cinema");
        assertTrue(fn.adicionaLocalFilme("", 1, 1));
    }
    
    /**
     * Testa a adição de um filme a posições inválidas na lista de locais.
     * Neste teste, um filme é cadastrado e tenta-se adicionar o filme a posições fora dos limites válidos (como 101, 100 e 0).
     * Espera-se que o método `adicionaLocalFilme` retorne falso para todas essas tentativas, indicando que a posição é inválida.
     */
    @Test
    void adicionaLocalFilmePosicaoInvalidaTest() {
        fn.cadastraFilme(1, "Harry Potter 1", "2001", "Cinema");
        assertFalse(fn.adicionaLocalFilme("HBO MAX", 1, 101));
        assertFalse(fn.adicionaLocalFilme("HBO MAX", 1, 100));
        assertFalse(fn.adicionaLocalFilme("HBO MAX", 1, 0));
    }
	
	
	
}