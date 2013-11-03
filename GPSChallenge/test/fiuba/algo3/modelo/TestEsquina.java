package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEsquina {
	
	@Test
	public void testDeberiaColocarUnAutoEnUnaEsquina(){
		Posicion unaPosicion = new Posicion(3,3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Auto unAuto = new Auto();
		unaEsquina.colocarAuto(unAuto);
		assertEquals(unaEsquina.obtenerAuto(),unAuto);		
	}

}
