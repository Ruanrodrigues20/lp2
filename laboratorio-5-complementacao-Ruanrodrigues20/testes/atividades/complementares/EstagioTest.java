package atividades.complementares;

import org.junit.jupiter.api.Test;

import atividades.complemetares.Estagio;

import static org.junit.jupiter.api.Assertions.*;

public class EstagioTest {

    @Test
    void testCriarEstagioValido() {
        Estagio estagio = new Estagio("Estágio", 360, "Empresa XYZ");
        assertNotNull(estagio);
        assertEquals("Empresa XYZ", estagio.getNomeEmpresa());
        assertEquals(6, estagio.getCredito());
    }

    @Test
    void testNomeEmpresaNulo() {
    	try {
    		new Estagio("Estágio", 360, null);
		} catch (Exception e) {
			assertEquals("Atributo Nulo!", e.getMessage());
		}
    	
   }

    @Test
    void testTipoNulo() {
    	try {
    		new Estagio(null, 360, "Empresa XYZ");
		} catch (Exception e) {
			assertEquals("Atributo Nulo!", e.getMessage());

		}
    }

    @Test
    void testNomeEmpresaVazio() {
    	try {
    		new Estagio("Estágio", 360, "");
		} catch (Exception e) {
			assertEquals("Atributo Vazio!", e.getMessage());

		}
    }
    

    @Test
    void testTipoVazio() {
       try {
    	   new Estagio("", 360, "Empresa XYZ");
	} catch (Exception e) {
		assertEquals("Atributo Vazio!", e.getMessage());
	}
    }

    @Test
    void testUnidadeContagemInvalida() {
        try {
        	new Estagio("Estágio", 250, "Empresa XYZ");
		} catch (Exception e) {
			assertEquals("Unidade de Contagem inválida!", e.getMessage());

		}
    }

    @Test
    void testCreditoLimite() {
        Estagio estagio = new Estagio("Estágio", 1080, "Empresa ABC");
        assertEquals(18, estagio.getCredito());
    }

    @Test
    void testToString() {
        Estagio estagio = new Estagio("Estágio", 360, "Empresa XYZ");
        assertTrue(estagio.toString().contains("nomeEmpresa=Empresa XYZ"));
    }
}
