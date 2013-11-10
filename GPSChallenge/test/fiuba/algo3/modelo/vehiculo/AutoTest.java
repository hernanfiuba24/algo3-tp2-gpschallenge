package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.vehiculo.Auto;

public class AutoTest {

	@Test
	public void testDeberiaCrearseElAutoConUnaEsquinaCuandoLoCreo() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Auto unAuto = new Auto(esquinaInicial);

		assertEquals(unAuto.devolverEsquina(), esquinaInicial);
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Auto unAuto = new Auto(esquinaInicial);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unAuto.actualizarEsquina(esquinaFinal);

		assertEquals(unAuto.devolverEsquina(), esquinaFinal);

	}
}
