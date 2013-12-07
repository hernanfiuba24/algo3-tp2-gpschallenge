package fiuba.algo3.modelo.juego;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoIntermedioTest {

	@Test
	public void testJuegoIntermedioDeberiaTener2DeCadaSorpresaYObstaculo() throws ExcepcionEsquinaInvalida, ExcepcionJugadorYaAsignadoAlVehiculo {
		JuegoIntermedio unJuegoIntermedio = new JuegoIntermedio("Ezequiel", 5, new Posicion(5, 5), new Posicion(3, 3));
		assertTrue(unJuegoIntermedio.devolverCantidadDeCambiosDeVehiculos() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeControlesPoliciales() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeDesfavorables() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeFavorables() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDePiquetes() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDePozos() == 2);

	}
}
