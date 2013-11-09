package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Direccion;

public class DireccionTest {

	@Test
	public void testDeberiaTenerUnSentidoXyUnSentidoY() {
		Direccion unaDireccion = new Arriba();
		
		assertTrue(unaDireccion.devolverX() == 1);
		assertTrue(unaDireccion.devolverY() == 0);
	}

}
