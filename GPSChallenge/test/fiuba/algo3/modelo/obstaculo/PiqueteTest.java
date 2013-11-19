package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Radar;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PiqueteTest {

	@Test
	public void testDeberiaPermitirMovimientoALaMoto() {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3, 3));

		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		@SuppressWarnings("unused")
		// Jugador creado para que la moto tenga un jugador asignado
		Jugador unJugador = new Jugador(unaMoto);

		Piquete unPiquete = new Piquete(unaEsquinaConMotoYPiquete);
		unPiquete.aplicar(unaMoto);

		assertTrue(unaMoto.devolverEsquina().equals(unaEsquinaConMotoYPiquete));
	}

	@Test
	public void testDeberiaAumentarleLosMovimientosALaMoto() {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3, 3));

		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		Jugador unJugador = new Jugador(unaMoto);
		unJugador.cambiarDireccion(new Abajo());

		Piquete unPiquete = new Piquete(unaEsquinaConMotoYPiquete);
		unPiquete.aplicar(unaMoto);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);
	}

	// TEST DE PiqueteTest MOVIDO ACA
	@Test
	public void testElAutoDeberiaVolverALaPosicionOriginal()
			throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Piquete unPiquete = new Piquete(unAuto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(4,
				3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assert (unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion().equals(esquinaConObstaculo
				.devolverPosicion()));
	}

	// TEST DE PiqueteTest MOVIDO ACA
	@Test
	public void testElAutoDeberiaTenerLaVisibilidadCorrectaAlVolverALaPosicionOriginal()
			throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(20, 20);
		Radar unRadar = new Radar(unMapa);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Piquete unPiquete = new Piquete(unAuto.devolverEsquina());
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(4,
				3));
		esquinaConObstaculo.colocarObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

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
	}
}