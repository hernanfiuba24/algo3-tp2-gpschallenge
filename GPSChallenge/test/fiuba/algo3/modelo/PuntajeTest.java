package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuntajeTest {

	@Test
	public void testDeberiaGuardarNombreYValor() {
		Puntaje puntaje = new Puntaje("pepe",100);
		
		assertTrue(puntaje.getNombre() == "pepe");
		assertTrue(puntaje.getValor() == 100);
	}

}
