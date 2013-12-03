package fiuba.algo3.modelo.direccion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IzquierdaTest {

	@Test
	public void testCoordenadaXDeberiaSer0YCoordenadaYDeberiaSerMenos1() {
		Izquierda unIzquierda = new Izquierda();
		
		assertTrue(unIzquierda.devolverX() == 0);
		assertTrue(unIzquierda.devolverY() == 1);
	}
	
	@Test
	public void testCambiarDireccionContrariaDeberiaDevolverDerecha() {
		Izquierda unaIzquierda = new Izquierda();

		assertTrue(unaIzquierda.cambiarDireccionContraria() instanceof Derecha);
	}

}
