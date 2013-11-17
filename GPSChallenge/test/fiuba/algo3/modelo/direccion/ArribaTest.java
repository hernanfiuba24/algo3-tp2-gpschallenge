package fiuba.algo3.modelo.direccion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Arriba;

public class ArribaTest {

	@Test
	public void testCoordenadaXDeberiaSer1YCoordenadaYDeberiaSer0() {
		Arriba unArriba = new Arriba();

		assertTrue(unArriba.devolverX() == 1);
		assertTrue(unArriba.devolverY() == 0);
	}
	
	@Test
	public void testCambiarDireccionContrariaDeberiaDevolverAbajo() {
		Arriba unArriba = new Arriba();

		assertTrue(unArriba.cambiarDireccionContraria() instanceof Abajo);
	}

}
