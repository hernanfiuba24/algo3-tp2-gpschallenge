package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void testJuegoDeberiaExistir() {
		Juego unJuego = new Juego();
		assertTrue(unJuego instanceof Juego);
	}

}
