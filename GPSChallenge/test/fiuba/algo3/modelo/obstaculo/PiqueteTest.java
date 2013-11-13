package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Radar;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PiqueteTest {

	@Test
	public void testDeberiaCambiarleLaDireccionAlAuto() {
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Piquete unPiquete = new Piquete(unAuto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(3, 4));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverDireccion() instanceof Izquierda);
	}

	@Test
	public void testDeberiaCambiarleLaDireccionALaCamioneta() {
		Mapa unMapa = new Mapa(20, 20);
		Camioneta unaCamioneta = new Camioneta(unMapa);
		Jugador unJugador = new Jugador(unaCamioneta);
		Piquete unPiquete = new Piquete(unaCamioneta.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(4, 3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverDireccion() instanceof Arriba);
	}

	@Test
	public void testNoDeberiaCambiarleLaDireccionALaMoto() {
		Mapa unMapa = new Mapa(20, 20);
		Moto unaMoto = new Moto(unMapa);
		Jugador unJugador = new Jugador(unaMoto);
		Piquete unPiquete = new Piquete(unaMoto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(4, 3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverDireccion() instanceof Abajo);
	}

	@Test
	public void testDeberiaAumentarleLosMovimientosALaMoto() {
		Mapa unMapa = new Mapa(20, 20);
		Moto unaMoto = new Moto(unMapa);
		Jugador unJugador = new Jugador(unaMoto);
		Piquete unPiquete = new Piquete(unaMoto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(4, 3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 3);
	}

	@Test
	public void testElAutoDeberiaVolverALaPosicionOriginal() {
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Piquete unPiquete = new Piquete(unAuto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(4, 3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assert (unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion().equals(esquinaConObstaculo
				.devolverPosicion()));
	}

	@Test
	public void testElAutoDeberiaTenerLaVisibilidadCorrectaAlVolverALaPosicionOriginal() {
		Mapa unMapa = new Mapa(20, 20);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Piquete unPiquete = new Piquete(unAuto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.dameEsquina(new Posicion(4, 3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				boolean visibilidad = unRadar.devolverVisibilidad(unMapa
						.dameEsquina(new Posicion(unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionFila()
								+ i, unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionColumna()
								+ j)));

				assertTrue(visibilidad);
			}
		}
	}
}