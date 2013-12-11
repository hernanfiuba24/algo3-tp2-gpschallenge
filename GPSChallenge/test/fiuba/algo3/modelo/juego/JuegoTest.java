package fiuba.algo3.modelo.juego;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Camioneta;

public class JuegoTest {

	@Test
	public void testJuegoDeberiaCrearseConMapaJugadorYRadar()
			throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		Juego unJuego = new JuegoFacil("Ezequiel", 3, new Posicion(3, 3),
				new Camioneta(new Esquina(new Posicion(3, 3))));
		assertTrue(unJuego.devolverMapa() instanceof Mapa);
		assertTrue(unJuego.devolverJugador() instanceof Jugador);
	}
}
