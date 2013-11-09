package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;

public class CambioDeVehiculoTest {

	@Test
	public void testDesfavorableDeberiaExistir() {
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		assertTrue(unCambioDeVehiculo instanceof CambioDeVehiculo);
	}

}
