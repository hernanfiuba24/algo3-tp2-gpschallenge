package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.vehiculo.Auto;

public class JugadorTest {

	@Test
	public void testJugadorDeberiaExistir() {
		Jugador unJugador = new Jugador();
		assertTrue(unJugador instanceof Jugador);
	}

	@Test
	public void testJugadorDeberiaPoderJugarArriba() {

		Mapa unMapa = new Mapa(10, 10);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(5,5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(4, 5);
		unJugador.cambiarDireccion(new Arriba());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarAbajo() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(4, 3);
		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarIzquierda() {

		Mapa unMapa = new Mapa(10, 10);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(5,5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(5, 4);
		unJugador.cambiarDireccion(new Izquierda());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarDerecha() {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(3, 4);
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
}
