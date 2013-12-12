package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.cambiadorDeVisibilidad.EncendedorDeVisibilidad;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PiqueteTest {

	@Test
	public void testDeberiaPermitirMovimientoALaMoto() throws ExcepcionJugadorYaAsignadoAlVehiculo {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3, 3));

		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		@SuppressWarnings("unused")
		// Jugador creado para que la moto tenga un jugador asignado
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);

		Piquete unPiquete = new Piquete();
		unPiquete.aplicar(unaMoto);

		assertTrue(unaMoto.devolverEsquina().equals(unaEsquinaConMotoYPiquete));
	}

	@Test
	public void testDeberiaAumentarleLosMovimientosALaMoto() throws ExcepcionJugadorYaAsignadoAlVehiculo {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3, 3));

		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);
		unJugador.cambiarDireccion(new Abajo());

		Piquete unPiquete = new Piquete();
		unPiquete.aplicar(unaMoto);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);
	}

	@Test
	public void testElAutoDeberiaVolverALaPosicionOriginal()
			throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, null);
		Piquete unPiquete = new Piquete();
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(4,
				3));
		esquinaConObstaculo.setearObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assert (unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion().equals(esquinaConObstaculo
				.devolverPosicion()));
	}

	@Test
	public void testElAutoDeberiaTenerLaVisibilidadCorrectaAlVolverALaPosicionOriginal()
			throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {
		Mapa unMapa = new Mapa(20, 20);
		EncendedorDeVisibilidad unEncendedor = new EncendedorDeVisibilidad(unMapa);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, null);
		Piquete unPiquete = new Piquete();
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(4,
				3));
		esquinaConObstaculo.setearObstaculo(unPiquete);

		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				boolean visibilidad = unEncendedor.devolverVisibilidad(unMapa
						.devolverUnaEsquina(new Posicion(unAuto
								.devolverEsquina().devolverPosicion()
								.devolverPosicionAlto()
								+ i, unAuto.devolverEsquina()
								.devolverPosicion().devolverPosicionAncho()
								+ j)));

				assertTrue(visibilidad);
			}
		}
	}
}