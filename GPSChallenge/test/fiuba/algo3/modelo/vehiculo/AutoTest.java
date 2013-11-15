package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.vehiculo.Auto;

public class AutoTest {

	@Test
	public void testDeberiaCrearseElAutoConUnaEsquinaCuandoLoCreo() {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unAuto.setearEsquina(esquinaFinal);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(new Posicion(3, 3)));

	}
}
