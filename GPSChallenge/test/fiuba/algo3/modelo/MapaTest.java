package fiuba.algo3.modelo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MapaTest {
	
		@Test
		public void testMapaDeberiaExistir() {
			Mapa unMapa = new Mapa(12, 12);
			assertTrue(unMapa instanceof Mapa);
		}

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
		
		@Test
		public void testDeberiaDevolverUnaEsquina (){
			Mapa mapa = new Mapa (2,2);
			Esquina esquina = mapa.dameEsquina(new Posicion(1,1));
			
			int x = 1;
			int y = 1;
			
			assertTrue(esquina.devolverPosicion().devolverPosicionFila() == x);
			assertTrue(esquina.devolverPosicion().devolverPosicionColumna() == y);
			
		}
}
