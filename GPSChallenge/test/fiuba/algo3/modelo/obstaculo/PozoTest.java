package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PozoTest {

	@Test
	public void testDeberiaSumarleTresMovimientosAlAuto() {
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.colocarObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 5);

	}

	@Test
	public void testDeberiaSumarleTresMovimientosALaMoto() {
		Mapa unMapa = new Mapa(12, 12);
		Moto unaMoto = new Moto(unMapa);
		Jugador unJugador = new Jugador(unaMoto);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.colocarObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 5);

	}

	@Test
	public void testNoDeberiaSumarleMovimientosALaCamioneta() {
		Mapa unMapa = new Mapa(12, 12);
		Camioneta unaCamioneta = new Camioneta(unMapa);
		Jugador unJugador = new Jugador(unaCamioneta);
		Esquina esquinaConObstaculo = unMapa.devolverUnaEsquina(new Posicion(5,
				3));
		unJugador.cambiarDireccion(new Abajo());
		Pozo unPozo = new Pozo();
		esquinaConObstaculo.colocarObstaculo(unPozo);

		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);

	}
}