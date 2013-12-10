package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.puntaje.Puntaje;

public class PuntajeTest {

	@Test
	public void testDeberiaGuardarNombreYValor() {
		Puntaje puntaje = new Puntaje("pepe",100);
		
		assertTrue(puntaje.getNombre() == "pepe");
		assertTrue(puntaje.getValor() == 100);
	}

}
