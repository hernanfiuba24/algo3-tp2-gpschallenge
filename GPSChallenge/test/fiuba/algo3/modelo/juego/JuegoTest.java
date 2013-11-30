package fiuba.algo3.modelo.juego;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;

public class JuegoTest {

	@Test
	public void testJuegoDeberiaCrearseConMapaJugadorYRadar() throws ExcepcionEsquinaInvalida {
		Juego unJuego = new JuegoFacil();
		assertTrue(unJuego.devolverMapa() instanceof Mapa);
		assertTrue(unJuego.devolverJugador() instanceof Jugador);
	}
}
