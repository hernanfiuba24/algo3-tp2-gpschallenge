package fiuba.algo3.modelo;

import junit.framework.Assert;

import org.junit.Test;

public class MapaTest {

		@Test
		public void testDeberiaCrearMapa() {
			Mapa mapa = new Mapa(2 , 1);
			Assert.assertEquals(2, mapa.dameFilas());
			Assert.assertEquals(1, mapa.dameColumnas());
			for (int i = 1 ; i <= mapa.dameFilas() ; i++){
				for (int j = 1 ; j <= mapa.dameColumnas() ; j++){
					Assert.assertNotNull(mapa.dameEsquina(new Posicion(i, j)));
				}
			}
		}
}
