package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DireccionTest {

	@Test
	public void testDeberiaTenerUnSentidoXyUnSentidoY() {
		Direccion unaDireccion = new Arriba();
		
		assertTrue(unaDireccion.devolverX() == 1);
		assertTrue(unaDireccion.devolverY() == 0);
	}

}
