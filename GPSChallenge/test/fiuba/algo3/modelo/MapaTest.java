package fiuba.algo3.modelo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MapaTest {

	@Test
	public void testDeberiaCrearMapa() {
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
	public void testDeberiaDevolverUnaEsquina() {
		Mapa mapa = new Mapa(2, 2);
		Esquina esquina = mapa.devolverUnaEsquina(new Posicion(1, 1));

		int x = 1;
		int y = 1;

		assertTrue(esquina.devolverPosicion().devolverPosicionFila() == x);
		assertTrue(esquina.devolverPosicion().devolverPosicionColumna() == y);

	}
}
