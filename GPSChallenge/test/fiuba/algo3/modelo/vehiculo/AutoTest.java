package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class AutoTest {

	@Test
	public void testDeberiaCrearseElAutoConUnaEsquinaCuandoLoCreo() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unAuto.setearEsquina(esquinaFinal);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));

	}
	
	@Test
	public void testCambioDeVehiculoDeberiaCambiarAutoPorCamioneta() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		
		unAuto.cambioDeVehiculo();
		
		assertTrue(unJugador.devolverVehiculo() instanceof Camioneta);
	}
}
