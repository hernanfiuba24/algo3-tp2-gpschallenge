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
		unJugador.setDireccion(new Arriba());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionFila() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionFila() - unAuto.movimientos()));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarAbajo() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(5,5));
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPreviaAlMovimiento = unAuto.devolverEsquina();
		unJugador.setDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionFila() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionFila() + unAuto.movimientos()));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarIzquierda() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(5,5));
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPreviaAlMovimiento = unAuto.devolverEsquina();
		unJugador.setDireccion(new Izquierda());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionColumna() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionColumna() + unAuto.movimientos()));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarDerecha() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(5,5));
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPreviaAlMovimiento = unAuto.devolverEsquina();
		unJugador.setDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.devolverPosicionColumna() == (esquinaPreviaAlMovimiento
				.devolverPosicion().devolverPosicionColumna() - unAuto.movimientos()));
	}
}
