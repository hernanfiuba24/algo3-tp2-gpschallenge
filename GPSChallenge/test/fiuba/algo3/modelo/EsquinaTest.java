package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EsquinaTest {
	
	@Test
	public void testEsquinaDeberiaExistir() {
		Esquina unaEsquina = new Esquina( new Posicion(3,2) );
		assertTrue(unaEsquina instanceof Esquina);
	}
	
	@Test
	public void testDeberiaColocarUnAutoEnUnaEsquina(){
		Posicion unaPosicion = new Posicion(3,3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Auto unAuto = new Auto(unaEsquina);
		unaEsquina.colocarAuto(unAuto);
		assertEquals(unaEsquina.obtenerAuto(),unAuto);		
	}

}
