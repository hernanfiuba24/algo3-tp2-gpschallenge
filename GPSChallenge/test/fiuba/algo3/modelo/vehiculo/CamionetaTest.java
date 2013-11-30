package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class CamionetaTest {

	@Test
	public void testDeberiaCrearseLaCamionetaConUnaEsquinaCuandoLoCreo() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Camioneta unaCamioneta = new Camioneta(unMapa);

		assertTrue(unaCamioneta.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Camioneta unaCamioneta = new Camioneta(unMapa);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unaCamioneta.setearEsquina(esquinaFinal);

		assertTrue(unaCamioneta.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));

	}
	
	@Test
	public void testCambioDeVehiculoDeberiaCambiarCamionetaPorMoto() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(12, 12);
		Camioneta unaCamioneta = new Camioneta(unMapa);
		JugadorImplementacion unJugador = new JugadorImplementacion(unaCamioneta, null);
		
		unaCamioneta.cambioDeVehiculo();
		
		assertTrue(unJugador.devolverVehiculo() instanceof Moto);
	}

}