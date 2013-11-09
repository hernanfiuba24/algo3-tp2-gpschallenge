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
		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(4, 5);
		unJugador.setDireccion(new Arriba());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarAbajo() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(6, 5);
		unJugador.setDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarIzquierda() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(5, 6);
		unJugador.setDireccion(new Izquierda());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarDerecha() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(5, 4);
		unJugador.setDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
}
