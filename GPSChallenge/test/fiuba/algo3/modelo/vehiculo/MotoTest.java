package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class MotoTest {

	@Test
	public void testDeberiaCrearseLaMotoConUnaEsquinaCuandoLoCreo() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Moto unaMoto = new Moto(unMapa);

		assertTrue(unaMoto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() throws ExcepcionEsquinaInvalida {
		Mapa unMapa = new Mapa(8, 8);
		Moto unaMoto = new Moto(unMapa);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unaMoto.setearEsquina(esquinaFinal);

		assertTrue(unaMoto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));
	}
	
	@Test
	public void testCambioDeVehiculoDeberiaCambiarMotoPorAuto() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(12, 12);
		Moto unaMoto = new Moto(unMapa);
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);
		
		unaMoto.cambioDeVehiculo();
		
		assertTrue(unJugador.devolverVehiculo() instanceof Auto);
	}
}
