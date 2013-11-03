package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void testJugadorDeberiaExistir() {
		Jugador unJugador = new Jugador();
		assertTrue(unJugador instanceof Jugador);
	}
	
}
