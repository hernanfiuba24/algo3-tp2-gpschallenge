package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArribaTest {

	@Test
	public void testCoordenadaXDeberiaSer1YCoordenadaYDeberiaSer0() {
		Arriba unArriba = new Arriba();
		
		assertTrue(unArriba.devolverX() == 1);
		assertTrue(unArriba.devolverY() == 0);
	}

}
