package atividades.complementares;

import org.junit.jupiter.api.Test;

import atividades.complemetares.RepresentacaoEstudantil;

import static org.junit.jupiter.api.Assertions.*;

public class RepresentacaoEstudantilTest {

    @Test
    void testCriarRepresentacaoEstudantilValida() {
        RepresentacaoEstudantil representacao = new RepresentacaoEstudantil("Representação", 1, "DIRETORIA");
        assertNotNull(representacao);
        assertEquals("DIRETORIA", representacao.getSubtipo());
        assertEquals(2, representacao.getCredito());
    }

    @Test
    void testTipoNulo() {
        try {
            new RepresentacaoEstudantil(null, 1, "DIRETORIA");
        } catch (Exception e) {
            assertEquals("Atributo Nulo!", e.getMessage());
        }
    }

    @Test
    void testSubtipoNulo() {
        try {
            new RepresentacaoEstudantil("Representação", 1, null);
        } catch (Exception e) {
            assertEquals("Atributo Nulo!", e.getMessage());
        }
    }

    @Test
    void testSubtipoInvalido() {
        try {
            new RepresentacaoEstudantil("Representação", 1, "INVALIDO");
        } catch (Exception e) {
            assertEquals("Subtipo inválido!", e.getMessage());
        }
    }

    @Test
    void testUnidadeContagemInvalida() {
        try {
            new RepresentacaoEstudantil("Representação", 0, "DIRETORIA");
        } catch (Exception e) {
            assertEquals("Unidade de Contagem inválida!", e.getMessage());
        }
    }

    @Test
    void testSubtipoVazio() {
        try {
            new RepresentacaoEstudantil("Representação", 1, "");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testTipoVazio() {
        try {
            new RepresentacaoEstudantil("", 1, "DIRETORIA");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testCredito() {
        RepresentacaoEstudantil representacao = new RepresentacaoEstudantil("Representação", 2, "COMISSAO");
        assertEquals(2, representacao.getCredito());
    }

    @Test
    void testToString() {
        RepresentacaoEstudantil representacao = new RepresentacaoEstudantil("Representação", 1, "DIRETORIA");
        assertTrue(representacao.toString().contains("subtipo=DIRETORIA"));
    }

    @Test
    void testSubtipoComEspacos() {
        try {
            new RepresentacaoEstudantil("Representação", 1, "   ");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }
}
