package fiuba.algo3.modelo;

import org.junit.Test;

public class RadarTest {
		
	@Test
	public void testDeberiaCambiarEstadoDeVisibilidadDeUnaEsquina() {
		Esquina unaEsquina = new Esquina(new Posicion(3, 2));
		Radar unRadar = new Radar();
		unRadar.cambiarVisibilidad(unaEsquina);
	}

//	@Test
//	public void testDeberiaPrenderDosEsquinasALaRedonda() {
//		Mapa unMapa = new Mapa(7, 7);
//		Radar unRadar = new Radar(unMapa);
//		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(4, 5)));
//		for (int i = 1; i <= 2; i++) {
//			for (int j = 1; j <= 2; j++) {
//				boolean visibilidad = unRadar.devolverVisibilidad(unMapa.dameEsquina(new Posicion(
//						unAuto.devolverEsquina().devolverPosicion()
//								.devolverPosicionFila() + i, unAuto
//								.devolverEsquina().devolverPosicion()
//								.devolverPosicionColumna() + j)));
//			
//				assertTrue (visibilidad);
//			}
//		}
//	}

}
