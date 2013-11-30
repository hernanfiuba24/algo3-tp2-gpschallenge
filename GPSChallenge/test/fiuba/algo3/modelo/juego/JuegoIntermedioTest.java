package fiuba.algo3.modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class JuegoIntermedioTest {

	@Test
	public void testJuegoIntermedioDeberiaTener2DeCadaSorpresaYObstaculo() throws ExcepcionEsquinaInvalida {
		JuegoIntermedio unJuegoIntermedio = new JuegoIntermedio();
		assertTrue(unJuegoIntermedio.devolverCantidadDeCambiosDeVehiculos() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeControlesPoliciales() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeDesfavorables() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDeFavorables() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDePiquetes() == 2);
		assertTrue(unJuegoIntermedio.devolverCantidadDePozos() == 2);

	}
}
