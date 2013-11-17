package fiuba.algo3.modelo.direccion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Derecha;

public class DerechaTest {

	@Test
	public void testCoordenadaXDeberiaSer0YCoordenadaYDeberiaSer1() {
		Derecha unDerecha = new Derecha();

		assertTrue(unDerecha.devolverX() == 0);
		assertTrue(unDerecha.devolverY() == -1);
	}
	
	@Test
	public void testCambiarDireccionContrariaDeberiaDevolverIzquierda() {
		Derecha unaDerecha = new Derecha();

		assertTrue(unaDerecha.cambiarDireccionContraria() instanceof Izquierda);
	}

}
