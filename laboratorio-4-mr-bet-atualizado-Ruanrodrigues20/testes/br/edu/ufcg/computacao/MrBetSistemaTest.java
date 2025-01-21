package br.edu.ufcg.computacao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.MrBetSistema;


class MrBetSistemaTest {
	private MrBetSistema mr;
	
	@BeforeEach
	void initMrBet() {
		mr = new MrBetSistema();
		mr.incluiTime("002_RJ", "Clube de Regatas do Flamengo",  "Urubu");
		mr.incluiTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
		mr.incluiTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mr.incluiTime("250_PB", "Nacional de Patos", "Canário");
	}
	
	@Test
	void testIncluiTimes() {
		assertTrue(mr.incluiTime("003_RJ", "Clube de Regatas do Flamengo",  "Urubu"));
	}
	
	@Test
	void testIncluiTimesReptido() {
		assertTrue(mr.incluiTime("003_RJ", "Clube de Regatas do Flamengo",  "Urubu"));
		assertFalse(mr.incluiTime("003_RJ", "Clube de Regatas do Flamengo",  "Urubu"));
	}
	
	@Test
	void testIncluiTimesMesmoCodigo() {
		assertTrue(mr.incluiTime("003_RJ", "Clube de Regatas do Flamengo",  "Urubu"));
		assertFalse(mr.incluiTime("003_RJ", "Vasco da Gama",  "Corvo"));
	}
	
	@Test
	void testIncluiTimesVariosTimes() {
		assertTrue(mr.incluiTime("003_RJ", "Clube de Regatas do Flamengo",  "Urubu"));
		assertTrue(mr.incluiTime("106_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião"));
		assertTrue(mr.incluiTime("253_PB", "Sport Lagoa Seca", "Carneiro"));
		assertTrue(mr.incluiTime("254_PB", "Nacional de Patos", "Canário"));
	}
	
	@Test
	void testIncluiCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", mr.incluiCampeonato("Brasileirão série A 2024", 20));
	}
	
	@Test
	void testIncluiCampeonatoRepetido() {
		assertEquals("CAMPEONATO ADICIONADO!", mr.incluiCampeonato("Brasileirão série A 2024", 20));
		assertEquals("CAMPEONATO JÁ EXISTE!", mr.incluiCampeonato("Brasileirão série A 2024", 20));
	}
	
	@Test
	void testIncluiTimeCampeonato() {
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("250_PB", "Brasileirão série A 2024"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "Brasileirão série A 2024"));
	}
	
	@Test
	void testIncluiTimeCampeontaoTimeJaIncluido() {
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "Brasileirão série A 2024"));
		assertEquals("TIME JÁ INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "Brasileirão série A 2024"));
	}
	
	@Test
	void testInclutiTimeCampeonatoAcimaLimiteCampeonato() {
		mr.incluiCampeonato("Brasileirão série A 2024", 2);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "Brasileirão série A 2024"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("250_PB", "Brasileirão série A 2024"));
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", mr.incluiTimeCampeonato("002_RJ", "Brasileirão série A 2024"));
	}
	
	@Test
	void testIncluiTimeCampeonatoTimeNaoExiste() {
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		try {
			mr.incluiTimeCampeonato("005_Pb", "Brasileirão série A 2024");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testIncluiTimeCampeonatoCampeonatoNaoExiste() {
		try {
			mr.incluiTimeCampeonato("252_PB", "Brasileirão série D 2024");
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testCampeonatosQueTimeParticipa() {
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		mr.incluiTimeCampeonato("002_RJ", "Brasileirão série A 2024");
		String out = "Campeonatos do Clube de Regatas do Flamengo:\n" 
					+"* Brasileirão série A 2024 - 1/20";
		assertEquals(out, mr.campeonatosQueTimeParticipa("002_RJ"));
	}
	
	@Test
	void testCampeonatosQueTimeParticipaMaisDeUmCamp() {
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		mr.incluiCampeonato("Cdb 2024", 38);

		mr.incluiTimeCampeonato("002_RJ", "Brasileirão série A 2024");
		mr.incluiTimeCampeonato("002_RJ", "Cdb 2024");

		String out = "Campeonatos do Clube de Regatas do Flamengo:\n" 
					+"* Brasileirão série A 2024 - 1/20\n"
					+"* Cdb 2024 - 1/38";
		assertEquals(out, mr.campeonatosQueTimeParticipa("002_RJ"));
	}
	
	@Test
	void testCampeonatosQueTimeParticipaTimeNaoParticipa() {
		assertEquals("", mr.campeonatosQueTimeParticipa("002_RJ"));
	}
	
	@Test
	void testCampeonatosQueTimeParticipaTimeNaoExiste() {
		try{
			mr.campeonatosQueTimeParticipa("fla");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}

	
	@Test
	void testBuscaTimeCampeonato() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2024");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", mr.buscaTimeCampeonato("250_PB", "Copa do Nordeste 2024"));
	}
	
	@Test
	void testBuscaTimeCampeonatoTimeForaCampeontao() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", mr.buscaTimeCampeonato("250_PB", "Copa do Nordeste 2024"));
	}
	
	@Test
	void testBuscaTimeCampeonatoTimeNaoExite() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		
		try {
			 mr.buscaTimeCampeonato("250_PB", "Copa do Nordeste 2024");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}	
	}
	
	@Test
	void testBuscaTimeCampeonatoCampeonatoNaoExite() {
		try {
			 mr.buscaTimeCampeonato("250_PB", "Copa do Nordeste 2024");
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}	
	}
	
	@Test
	void testRecuperaTime() {
		assertEquals("[002_RJ] Clube de Regatas do Flamengo / Urubu", mr.recuperaTime("002_RJ"));
	}
	
	@Test
	void testRecuperaTimeNaoExiste() {
		try {
			mr.recuperaTime("123_RJ");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testFazerAposta() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2024");
		assertEquals("APOSTA REGISTRADA!", mr.fazerAposta("250_PB", "Copa do Nordeste 2024", 1, 500));
	}
	
	@Test
	void testFazerApostaTimeNaoExiste() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		try {
			mr.fazerAposta("255_PB", "Copa do Nordeste 2024", 1, 500);
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testFazerApostaCampeonatoNaoExiste() {
		try {
			mr.fazerAposta("250_PB", "Copa do Nordeste 2024", 1, 500);
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testFazerApostaExcendoPosicoesCampeonato() {
		mr.incluiCampeonato("Copa do Nordeste 2024", 16);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2024");
		assertEquals("APOSTA NÃO REGISTRADA!", mr.fazerAposta("250_PB",  "Copa do Nordeste 2024", 17, 100));
	}
	
	@Test
	void testFazerApostaTimeNaoEstaCampeontao() {
		mr.incluiCampeonato("Copa do Brasil 2024", 32);
		assertEquals("APOSTA NÃO REGISTRADA!", mr.fazerAposta("250_PB", "Copa do Brasil 2024", 1, 500));
	}
	
	@Test
	void testStatusDaApostas1() {
	    mr.incluiCampeonato("Libertadores", 32);
	    mr.incluiTimeCampeonato("002_RJ", "Libertadores");
	    mr.fazerAposta("002_RJ", "Libertadores", 1, 10);

	    String[] out = {"[002_RJ] Clube de Regatas do Flamengo / Urubu\n"
	            + "Libertadores\n"
	            + "1/32\n"
	            + "R$ 10,00"};
	    
	    assertArrayEquals(out,  mr.statusDeApostas());
	}
	
	@Test
	void testTimeMaisParticipa() {
		mr.incluiTime("250_PB", "Nacional de Patos", "Canário");
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		mr.incluiTimeCampeonato("002_RJ", "Brasileirão série A 2024");
		String[] out = {"[002_RJ] Clube de Regatas do Flamengo / Urubu 1"};
		assertArrayEquals(out, mr.timesMaisParticipa());
	}
	
	@Test
	void testTimeMaisParticipaQuantidadeDeParticipacaoEmpata() {
		mr.incluiTime("250_PB", "Nacional de Patos", "Canário");
		mr.incluiCampeonato("Brasileirão série A 2024", 20);
		mr.incluiTimeCampeonato("002_RJ", "Brasileirão série A 2024");
		mr.incluiTimeCampeonato("250_PB", "Brasileirão série A 2024");
		String[] out = {"[002_RJ] Clube de Regatas do Flamengo / Urubu 1", "[250_PB] Nacional de Patos / Canário 1"};
		assertArrayEquals(out, mr.timesMaisParticipa());
	}
	
	@Test
	void testTimeMaisParticipaSemNenhumTime() {
		String[] out = new String[0];
		assertArrayEquals(out, mr.timesMaisParticipa());
	}
	
	@Test
	void testTimeNaoParticipa() {
		String[] out = {"[002_RJ] Clube de Regatas do Flamengo / Urubu", 
				"[105_PB] Sociedade Recreativa de Monteiro (SOCREMO) / Gavião", 
				"[250_PB] Nacional de Patos / Canário",
				"[252_PB] Sport Lagoa Seca / Carneiro"};
		assertArrayEquals(out, mr.timesNaoParticipa());
	}
	
	@Test
	void testBuscaTimeMaisPopularUmTime() {
		mr.incluiCampeonato("cdb", 38);
		mr.incluiTimeCampeonato("002_RJ", "cdb");
		mr.fazerAposta("002_RJ", "cdb", 1, 100);
		String[] out = {"Clube de Regatas do Flamengo / 1"};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
	@Test
	void testBuscaTimeMaisPopularNenhumTimePrimeiro() {
		mr.incluiCampeonato("cdb", 38);
		mr.incluiTimeCampeonato("002_RJ", "cdb");
		mr.fazerAposta("002_RJ", "cdb", 2, 100);
		String[] out = {};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
	@Test
	void testBuscaTimeMaisPopularSemApostas() {
		String[] out = {};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
	@Test
	void testBuscaTimeMaisPopularTimeMaisDeUmaAposta() {
		mr.incluiCampeonato("cdb", 38);
		mr.incluiCampeonato("libertadores", 38);
		mr.incluiTimeCampeonato("002_RJ", "libertadores");
		mr.incluiTimeCampeonato("002_RJ", "cdb");
		mr.fazerAposta("002_RJ", "cdb", 1, 100);
		mr.fazerAposta("002_RJ", "libertadores", 1, 100);

		String[] out = {"Clube de Regatas do Flamengo / 2"};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
	@Test
	void testBuscaTimeMaisPopularVariosTimesPrimeiro() {
		mr.incluiCampeonato("cdb", 38);
		mr.incluiTimeCampeonato("002_RJ", "cdb");
		mr.incluiTimeCampeonato("105_PB", "cdb");
		mr.incluiTimeCampeonato("252_PB", "cdb");
		
		mr.fazerAposta("002_RJ", "cdb", 1, 100);
		mr.fazerAposta("105_PB", "cdb", 1, 100);
		mr.fazerAposta("252_PB", "cdb", 1, 100);
		String[] out = {"Clube de Regatas do Flamengo / 1", 
						"Sociedade Recreativa de Monteiro (SOCREMO) / 1",
						"Sport Lagoa Seca / 1",};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
	@Test
	void testBuscaTimeMaisPopularVariosTimesPrimeiro2() {
		mr.incluiCampeonato("cdb", 38);
		mr.incluiTimeCampeonato("002_RJ", "cdb");
		mr.incluiTimeCampeonato("105_PB", "cdb");
		mr.incluiTimeCampeonato("252_PB", "cdb");
		
		mr.fazerAposta("002_RJ", "cdb", 1, 100);
		mr.fazerAposta("105_PB", "cdb", 1, 100);
		mr.fazerAposta("252_PB", "cdb", 1, 100);
		mr.fazerAposta("002_RJ", "cdb", 1, 1000);

		String[] out = {"Clube de Regatas do Flamengo / 2", 
						"Sociedade Recreativa de Monteiro (SOCREMO) / 1",
						"Sport Lagoa Seca / 1",};
		assertArrayEquals(out, mr.timesPolularAposta());
	}
	
}
