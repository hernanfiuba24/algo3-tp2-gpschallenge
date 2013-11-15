package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class RadarTest {

	@Test
	public void testDeberiaCambiarEstadoDeVisibilidadDeUnaEsquina() {
		Esquina unaEsquina = new Esquina(new Posicion(3, 2));
		Radar unRadar = new Radar();
		unRadar.encenderVisibilidad(unaEsquina);
	}

	@Test
	public void testDeberiaPrenderDosEsquinasALaRedondaAlCrearseElAuto() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(7, 7);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				boolean visibilidad = unRadar.devolverVisibilidad(unMapa
						.devolverUnaEsquina(new Posicion(unAuto
								.devolverEsquina().devolverPosicion()
								.devolverPosicionFila()
								+ i, unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionColumna()
								+ j)));

				assertTrue(visibilidad);
			}
		}
	}

	@Test
	public void testDeberianEstarPrendidaEsquinaAlJugar() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverVehiculo().devolverEsquina()
				.devolverVisibilidad() == true);

	}

	@Test
	public void testDeberianPrenderseLasEsquinas2ALaRedondaLuegoDelMovimientoDelAuto() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(20, 20);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Derecha());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				boolean visibilidad = unRadar.devolverVisibilidad(unMapa
						.devolverUnaEsquina(new Posicion(unAuto
								.devolverEsquina().devolverPosicion()
								.devolverPosicionFila()
								+ i, unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionColumna()
								+ j)));

				assertTrue(visibilidad);
			}
		}
		// Chequeo de la esquina donde esta posicionado el auto
		assertTrue(unAuto.devolverEsquina().devolverVisibilidad() == true);
	}

	@Test
	public void testDeberiaApagarseLaEsquinaDondeEstabaElAutoAntesDeMoverseHaciaOtraEsquina() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPrevia = unAuto.devolverEsquina();
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(esquinaPrevia.devolverVisibilidad() == false);
	}

	@Test
	public void testDeberianApagarseEsquinasConDistanciaMayorQueDosALaRedonda() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(20, 20);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Derecha());
		unJugador.jugar(unMapa);
		for (int i = 3; i <= 5; i++) {
			for (int j = 3; j <= 5; j++) {
				boolean visibilidad = unRadar.devolverVisibilidad(unMapa
						.devolverUnaEsquina(new Posicion(unAuto
								.devolverEsquina().devolverPosicion()
								.devolverPosicionFila()
								+ i, unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionColumna()
								+ j)));

				assertTrue(visibilidad == false);
			}
		}
	}

	@Test
	public void testSiEsquinaDondeEstabaElAutoEstaDentroDelRadio2DeLaNuevaEsquinaDeberiaEstarPrendida() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPrevia = unAuto.devolverEsquina();
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(esquinaPrevia.devolverVisibilidad() == true);
	}

	@Test
	public void testSiAutoVaYVieneDeEsquinaLaActualDeberiaEstarPrendida() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPrevia = unAuto.devolverEsquina();
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);
		unJugador.cambiarDireccion(new Izquierda());
		unJugador.jugar(unMapa);

		assertTrue(esquinaPrevia.devolverVisibilidad() == true);
	}

}
