package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PozoTest {

	@Test
	public void testDeberiaSumarleTresMovimientosAlAuto() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, null);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.setearObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 5);

	}

	@Test
	public void testDeberiaSumarleTresMovimientosALaMoto() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado {
		Mapa unMapa = new Mapa(12, 12);
		Moto unaMoto = new Moto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.setearObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 5);

	}

	@Test
	public void testNoDeberiaSumarleMovimientosALaCamioneta() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado {
		Mapa unMapa = new Mapa(12, 12);
		Camioneta unaCamioneta = new Camioneta(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaCamioneta, null);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.setearObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);

	}
}