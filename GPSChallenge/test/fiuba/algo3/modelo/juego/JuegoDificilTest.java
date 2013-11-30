package fiuba.algo3.modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class JuegoDificilTest {

	@Test
	public void testJuegoDificilDeberiaTener6DeCadaSorpresaYObstaculoY3CambioDeVehiculo() throws ExcepcionEsquinaInvalida {
		JuegoDificil unJuegoDificil = new JuegoDificil("Ezequiel", 8, new Posicion(8, 8));
		assertTrue(unJuegoDificil.devolverCantidadDeCambiosDeVehiculos() == 3);
		assertTrue(unJuegoDificil.devolverCantidadDeControlesPoliciales() == 5);
		assertTrue(unJuegoDificil.devolverCantidadDeDesfavorables() == 5);
		assertTrue(unJuegoDificil.devolverCantidadDeFavorables() == 5);
		assertTrue(unJuegoDificil.devolverCantidadDePiquetes() == 5);
		assertTrue(unJuegoDificil.devolverCantidadDePozos() == 5);

	}

}
