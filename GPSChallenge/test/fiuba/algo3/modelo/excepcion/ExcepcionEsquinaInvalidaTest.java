package fiuba.algo3.modelo.excepcion;

import org.junit.Test;

import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;

public class ExcepcionEsquinaInvalidaTest {

	@Test(expected = ExcepcionEsquinaInvalida.class)
	public void testDeberiaLanzarExcepcion() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(2,2);
		unMapa.devolverUnaEsquina(new Posicion(3,3));
	}

}
