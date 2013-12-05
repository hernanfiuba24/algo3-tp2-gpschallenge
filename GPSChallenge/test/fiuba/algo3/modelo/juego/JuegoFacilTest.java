package fiuba.algo3.modelo.juego;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoFacilTest {

	@Test
	public void testJuegoFacilDeberiaTener1DeCadaSorpresaYObstaculo() throws ExcepcionEsquinaInvalida, ExcepcionJugadorYaAsignadoAlVehiculo {
		JuegoFacil unJuegoFacil = new JuegoFacil("Ezequiel", 3, new Posicion(3, 3));
		assertTrue(unJuegoFacil.devolverCantidadDeCambiosDeVehiculos() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeControlesPoliciales() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeDesfavorables() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeFavorables() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDePiquetes() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDePozos() == 1);

	}

}
