package fiuba.algo3.modelo.vehiculo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;

public class MotoTest {

	@Test
	public void testDeberiaCrearseLaMotoConUnaEsquinaCuandoLoCreo() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Moto unaMoto = new Moto(esquinaInicial);

		assertEquals(unaMoto.devolverEsquina(), esquinaInicial);
	}
	
	@Test
	public void testDeberiaModificarseEsquinaCuandoActualizoPosicion() {
		Posicion posicionInicial = new Posicion(3, 2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Moto unaMoto = new Moto(esquinaInicial);

		Posicion posicionFinal = new Posicion(3, 3);
		Esquina esquinaFinal = new Esquina(posicionFinal);

		unaMoto.actualizarEsquina(esquinaFinal);

		assertEquals(unaMoto.devolverEsquina(), esquinaFinal);

	}
}
