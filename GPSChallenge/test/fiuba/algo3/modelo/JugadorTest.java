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

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(5,5));
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPreviaAlMovimiento = unAuto.devolverEsquina();

		unJugador.jugarArriba(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionFila() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionFila() - unAuto.movimientos()));
	}
}
