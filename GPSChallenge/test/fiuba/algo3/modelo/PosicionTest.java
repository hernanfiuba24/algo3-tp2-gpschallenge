package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PosicionTest {

	@Test
	public void testPosicionDeberiaCrearseConUnaFilaYUnaColumna() {
		Posicion unaPosicion = new Posicion(3,3);
		
		assertTrue(unaPosicion.devolverPosicionFila() == 3);
		assertTrue(unaPosicion.devolverPosicionColumna() == 3);
		
	}
	
	@Test
	public void testPosicionDeberiaSerIgualAOtraSiTienenLaMismaFilaYColumna() {
		Posicion unaPosicion = new Posicion(8,5);
		Posicion otraPosicion = new Posicion(8,5);
		
		assertTrue(unaPosicion.equals(otraPosicion));
		
	}
	

}
