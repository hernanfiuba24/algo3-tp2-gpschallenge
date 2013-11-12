package fiuba.algo3.modelo.direccion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Arriba;

public class ArribaTest {
	
	@Test
	public void testArribaDeberiaExistir() {
		Arriba unArriba = new Arriba();
		assertTrue(unArriba instanceof Arriba);
	}

	@Test
	public void testCoordenadaXDeberiaSer1YCoordenadaYDeberiaSer0() {
		Arriba unArriba = new Arriba();
		
		assertTrue(unArriba.devolverX() == 1);
		assertTrue(unArriba.devolverY() == 0);
	}

}
