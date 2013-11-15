package fiuba.algo3.modelo.direccion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbajoTest {

	@Test
	public void testCoordenadaXDeberiaSerMenos1YCoordenadaYDeberiaSer0() {
		Abajo unAbajo = new Abajo();

		assertTrue(unAbajo.devolverX() == -1);
		assertTrue(unAbajo.devolverY() == 0);
	}
}
