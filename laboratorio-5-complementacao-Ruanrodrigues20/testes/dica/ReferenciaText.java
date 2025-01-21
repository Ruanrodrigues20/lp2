package dica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReferenciaText {
	Referencia ref;
	
	@BeforeEach
	void initRef() {
		ref = new Referencia("Ruan", "sei la", "vozes da minha cabeça", 2024, 5, true);
	}
	
	@Test
	void testIsConferida() {
		assertTrue(ref.isConferida());
	}
	
	@Test
	void testGetVisualizacao() {
		
	}
	
	 
}
