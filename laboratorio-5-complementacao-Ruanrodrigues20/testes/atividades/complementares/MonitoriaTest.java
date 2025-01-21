package atividades.complementares;

import org.junit.jupiter.api.Test;

import atividades.complemetares.Monitoria;

import static org.junit.jupiter.api.Assertions.*;

public class MonitoriaTest {

    @Test
    void testCriarMonitoriaValida() {
        Monitoria monitoria = new Monitoria("Monitoria", 4, "Matemática");
        assertNotNull(monitoria);
        assertEquals("Matemática", monitoria.getDisciplina());
        assertEquals(16, monitoria.getCredito());
    }

    @Test
    void testDisciplinaNula() {
        try {
            new Monitoria("Monitoria", 4, null);
        } catch (Exception e) {
            assertEquals("Atributo Null!", e.getMessage());
        }
    }

    @Test
    void testTipoNulo() {
        try {
            new Monitoria(null, 4, "Matemática");
        } catch (Exception e) {
            assertEquals("Atributo Null!", e.getMessage());
        }
    }

    @Test
    void testDisciplinaVazia() {
        try {
            new Monitoria("Monitoria", 4, "");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testTipoVazio() {
        try {
            new Monitoria("", 4, "Matemática");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testUnidadeContagemInvalida() {
        try {
            new Monitoria("Monitoria", 0, "Matemática");
        } catch (Exception e) {
            assertEquals("Unidade de Contagem inválida!", e.getMessage());
        }
    }

    @Test
    void testCreditoLimite() {
        Monitoria monitoria = new Monitoria("Monitoria", 5, "Física");
        assertEquals(16, monitoria.getCredito());
    }

    @Test
    void testCreditoAbaixoLimite() {
        Monitoria monitoria = new Monitoria("Monitoria", 3, "Química");
        assertEquals(12, monitoria.getCredito());
    }

    @Test
    void testCreditoExatoLimite() {
        Monitoria monitoria = new Monitoria("Monitoria", 4, "Biologia");
        assertEquals(16, monitoria.getCredito());
    }


    @Test
    void testDisciplinaComEspacos() {
        try {
            new Monitoria("Monitoria", 4, "   ");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }

    @Test
    void testTipoComEspacos() {
        try {
            new Monitoria("   ", 4, "Matemática");
        } catch (Exception e) {
            assertEquals("Atributo Vazio!", e.getMessage());
        }
    }
}
