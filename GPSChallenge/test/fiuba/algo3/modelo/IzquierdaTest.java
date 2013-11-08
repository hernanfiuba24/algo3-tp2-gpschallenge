package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class IzquierdaTest {

	@Test
	public void testCoordenadaXDeberiaSer0YCoordenadaYDeberiaSerMenos1() {
		Izquierda unIzquierda = new Izquierda();
		
		assertTrue(unIzquierda.devolverX() == 0);
		assertTrue(unIzquierda.devolverY() == -1);
	}

}
