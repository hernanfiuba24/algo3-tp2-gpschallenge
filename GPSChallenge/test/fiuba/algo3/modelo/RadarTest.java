package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.vehiculo.Auto;

public class RadarTest {
	
	@Test
	public void testRadarDeberiaExistir() {
		Radar unRadar = new Radar();
		assertTrue(unRadar instanceof Radar);
	}

	@Test
	public void testDeberiaCambiarEstadoDeVisibilidadDeUnaEsquina() {
		Esquina unaEsquina = new Esquina(new Posicion(3, 2));
		Radar unRadar = new Radar();
		unRadar.cambiarVisibilidad(unaEsquina);
	}

	@Test
	public void testDeberiaPrenderDosEsquinasALaRedondaAlCrearseElAuto() {
		Mapa unMapa = new Mapa(7, 7);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
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

	@Test
	public void testDeberianEstarPrendidaEsquinaAlJugar() {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.setDireccion(new Derecha());

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverVehiculo().devolverEsquina()
				.devolverVisibilidad() == true);

	}

	@Test
	public void testDeberianPrenderseLasEsquinas2ALaRedondaLuegoDelMovimientoDelAuto() {
		Mapa unMapa = new Mapa(20, 20);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
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
		// Chequeo de la esquina donde esta posicionado el auto
		assertTrue(unAuto.devolverEsquina().devolverVisibilidad() == true);
	}

	@Test
	public void testDeberiaApagarseLaEsquinaDondeEstabaElAutoAntesDeMoverseHaciaOtraEsquina() {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaPrevia = unAuto.devolverEsquina();
		unJugador.setDireccion(new Derecha());

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(esquinaPrevia.devolverVisibilidad() == false);
	}

}
