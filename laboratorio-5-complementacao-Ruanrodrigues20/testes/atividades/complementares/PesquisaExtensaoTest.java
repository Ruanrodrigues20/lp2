package atividades.complementares;

import org.junit.jupiter.api.Test;

import atividades.complemetares.PesquisaExtensao;

import static org.junit.jupiter.api.Assertions.*;

public class PesquisaExtensaoTest {

    @Test
    void testCriarPesquisaExtensaoValida() {
        PesquisaExtensao pesquisa = new PesquisaExtensao("Pesquisa", 12, "PET");
        assertNotNull(pesquisa);
        assertEquals("PET", pesquisa.getSubTipo());
        assertEquals(10, pesquisa.getCredito());
    }

    @Test
    void testTipoNulo() {
        try {
            new PesquisaExtensao(null, 12, "PET");
        } catch (Exception e) {
            assertEquals("Atributo Nulo!", e.getMessage());
        }
    }

    @Test
    void testSubTipoNulo() {
        try {
            new PesquisaExtensao("Pesquisa", 12, null);
        } catch (Exception e) {
            assertEquals("Atributo Nulo!", e.getMessage());
        }
    }

    @Test
    void testSubTipoInvalido() {
        try {
            new PesquisaExtensao("Pesquisa", 12, "INVALIDO");
        } catch (Exception e) {
            assertEquals("Sub tipo inválido!", e.getMessage());
        }
    }

    @Test
    void testUnidadeContagemInvalida() {
        try {
            new PesquisaExtensao("Pesquisa", 0, "PET");
        } catch (Exception e) {
            assertEquals("Unidade de Contagem inválida!", e.getMessage());
        }
    }

    @Test
    void testUnidadeContagemAcimaLimite() {
        try {
            new PesquisaExtensao("Pesquisa", 19, "PET");
        } catch (Exception e) {
            assertEquals("Unidade de Contagem inválida!", e.getMessage());
        }
    }

    @Test
    void testSubTipoVazio() {
        try {
            new PesquisaExtensao("Pesquisa", 12, "");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testTipoVazio() {
        try {
            new PesquisaExtensao("", 12, "PET");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testCreditoLimite() {
        PesquisaExtensao pesquisa = new PesquisaExtensao("Pesquisa", 18, "PET");
        assertEquals(15, pesquisa.getCredito());
    }

    @Test
    void testToString() {
        PesquisaExtensao pesquisa = new PesquisaExtensao("Pesquisa", 12, "PET");
        assertTrue(pesquisa.toString().contains("subTipo=PET"));
    }

    @Test
    void testSubTipoComEspacos() {
        try {
            new PesquisaExtensao("Pesquisa", 12, "   ");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }
}
