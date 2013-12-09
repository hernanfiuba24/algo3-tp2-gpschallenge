package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GuardadorPuntajesTest {

	@Test
	public void testDeberiaGuardarPuntajes() {
		
		GuardadorPuntajes guardador = new GuardadorPuntajes();
		guardador.guardarPuntaje("Pepe", 1000);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(new Puntaje("Pepe", 1000)));
	}
	
	@Test
	public void testDeberiaObtenerElPuntajeConElNombreCorrespondiente(){

		GuardadorPuntajes guardador = new GuardadorPuntajes();
		Puntaje puntaje = new Puntaje("Alfio", 200);
		guardador.guardarPuntaje("Alfio", 200);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(puntaje));
	}
	
	@Test
	public void testDeberiaOrdenarLosPuntajes(){
		GuardadorPuntajes guardador = new GuardadorPuntajes();
		guardador.guardarPuntaje("Alfio", 200);
		guardador.guardarPuntaje("Pepe", 1000);
		guardador.guardarPuntaje("Otro", 500);
		
		Puntaje puntaje = new Puntaje("Alfio", 200);
		Puntaje puntaje2 = new Puntaje("Pepe", 1000);
		Puntaje puntaje3 = new Puntaje("Otro", 500);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(puntaje2));
		assertTrue(guardador.obtenerPuntaje(1).equals(puntaje3));
		assertTrue(guardador.obtenerPuntaje(2).equals(puntaje));
	}

}
