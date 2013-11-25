package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class JuegoTest {

	@Test
	public void testJuegoDeberiaCrearseConMapaJugadorYRadar() throws ExcepcionEsquinaInvalida {
		Juego unJuego = new Juego();
		assertTrue(unJuego.devolverMapa() instanceof Mapa);
		assertTrue(unJuego.devolverJugador() instanceof Jugador);
	}
}
