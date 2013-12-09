package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GuardadorPuntajesTest {

	@Test
	public void testDeberiaGuardarPuntajes() {
		
		GuardadorPuntajes guardador = new GuardadorPuntajes();
		guardador.guardarPuntaje("Pepe", 1000);
		
		assertTrue(guardador.get("Pepe") == 1000);
	}
	
	@Test
	public void testDeberiaObtenerElPuntajeConElNombreCorrespondiente(){

		GuardadorPuntajes guardador = new GuardadorPuntajes();
		Puntaje puntaje = new Puntaje("Alfio", 200);
		guardador.guardarPuntaje("Alfio", 200);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(puntaje));
	}

}
