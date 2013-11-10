package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;

public class CamionetaTest {

	@Test
	public void testDeberiaCrearseLaCamionetaConUnaEsquinaCuandoLoCreo() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Camioneta unaCamioneta = new Camioneta(esquinaInicial);

		assertEquals(unaCamioneta.devolverEsquina(), esquinaInicial);
	}

	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Camioneta unaCamioneta = new Camioneta(esquinaInicial);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unaCamioneta.actualizarEsquina(esquinaFinal);

		assertEquals(unaCamioneta.devolverEsquina(), esquinaFinal);

	}

}