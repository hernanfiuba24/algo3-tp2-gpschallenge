package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.puntaje.GuardadorPuntajes;
import fiuba.algo3.modelo.puntaje.Puntaje;

public class GuardadorPuntajesTest {

	@Test
	public void testDeberiaGuardarPuntajes() {
		
		GuardadorPuntajes guardador = new GuardadorPuntajes();
		Puntaje unPuntaje = new Puntaje("Pepe", 1000);
		guardador.guardarPuntaje(unPuntaje);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(new Puntaje("Pepe", 1000)));
	}
	
	@Test
	public void testDeberiaObtenerElPuntajeConElNombreCorrespondiente(){

		GuardadorPuntajes guardador = new GuardadorPuntajes();
		Puntaje puntaje = new Puntaje("Alfio", 200);
		guardador.guardarPuntaje(puntaje);
		
		assertTrue(guardador.obtenerPuntaje(0).equals(puntaje));
	}
	
	@Test
	public void testDeberiaOrdenarLosPuntajes(){
		GuardadorPuntajes guardador = new GuardadorPuntajes();
		
		Puntaje puntaje = new Puntaje("Alfio", 200);
		Puntaje puntaje2 = new Puntaje("Pepe", 1000);
		Puntaje puntaje3 = new Puntaje("Otro", 500);
		
		guardador.guardarPuntaje(puntaje);
		guardador.guardarPuntaje(puntaje2);
		guardador.guardarPuntaje(puntaje3);		
		
		assertTrue(guardador.obtenerPuntaje(0).equals(puntaje2));
		assertTrue(guardador.obtenerPuntaje(1).equals(puntaje3));
		assertTrue(guardador.obtenerPuntaje(2).equals(puntaje));
	}

}
