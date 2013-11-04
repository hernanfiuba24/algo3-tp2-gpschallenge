package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void testJugadorDeberiaExistir() {
		Jugador unJugador = new Jugador();
		assertTrue(unJugador instanceof Jugador);
	}

	@Test
	public void testJugadorDeberiaPoderJugarArriba() {
		Jugador unJugador = new Jugador();
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Esquina esquinaPreviaAlMovimiento = unAuto.devolverEsquina();

		unJugador.jugarArriba(unAuto, unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionFila() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionFila() - 1));
	}
}
