package fiuba.algo3.modelo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Camioneta;

public class MapaTest {

	@Test
	public void testDeberiaCrearMapa() throws ExcepcionEsquinaInvalida {
		Mapa mapa = new Mapa(2, 1);
		Assert.assertEquals(2, mapa.devolverFilas());
		Assert.assertEquals(1, mapa.devolverColumnas());
		for (int i = 1; i <= mapa.devolverFilas(); i++) {
			for (int j = 1; j <= mapa.devolverColumnas(); j++) {
				Assert.assertNotNull(mapa
						.devolverUnaEsquina(new Posicion(i, j)));
			}
		}
	}

	@Test
	public void testDeberiaDevolverUnaEsquina() throws ExcepcionEsquinaInvalida {
		Mapa mapa = new Mapa(2, 2);
		Esquina esquina = mapa.devolverUnaEsquina(new Posicion(1, 1));

		int x = 1;
		int y = 1;

		assertTrue(esquina.devolverPosicion().devolverPosicionFila() == x);
		assertTrue(esquina.devolverPosicion().devolverPosicionColumna() == y);

	}

	@Test
	public void testDeberiaSerInvalidaEsquinaFueraDeLimites() {
		Mapa mapa = new Mapa(2, 2);
		assertFalse(mapa.existeEsquina(new Posicion(3,2)));
		assertFalse(mapa.existeEsquina(new Posicion(2,3)));
		assertFalse(mapa.existeEsquina(new Posicion(-1,2)));
		assertFalse(mapa.existeEsquina(new Posicion(3,-1)));
		assertFalse(mapa.existeEsquina(new Posicion(0,2)));
		assertFalse(mapa.existeEsquina(new Posicion(3,0)));
	}
	
	@Test
	public void testDeberiaPoderAgregarUnAutoAUnMapaDe1x1() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(1,1);
		Camioneta unaCamioneta = new Camioneta(unMapa.devolverUnaEsquina(new Posicion(1,1)));
		assertTrue(unaCamioneta.devolverEsquina().devolverPosicion().equals(unMapa.devolverUnaEsquina(new Posicion(1,1)).devolverPosicion()));
	}
}
