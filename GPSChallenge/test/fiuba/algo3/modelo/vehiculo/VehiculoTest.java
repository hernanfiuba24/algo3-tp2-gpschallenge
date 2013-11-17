package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class VehiculoTest {

	@Test
	public void testSetearEsquinaDeberiaCambiarLaEsquinaDelVehiculo() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Esquina unaEsquina = unMapa.devolverUnaEsquina(new Posicion(7, 7));
		unAuto.setearEsquina(unaEsquina);

		assertTrue(unAuto.devolverEsquina() == unaEsquina);

	}

}
