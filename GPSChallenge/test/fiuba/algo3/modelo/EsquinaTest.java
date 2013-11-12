package fiuba.algo3.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.vehiculo.Auto;

public class EsquinaTest {

	@Test
	public void testEsquinaDeberiaExistir() {
		Esquina unaEsquina = new Esquina(new Posicion(3, 2));
		assertTrue(unaEsquina instanceof Esquina);
	}

	@Test
	public void testDeberiaColocarUnAutoEnUnaEsquina() {
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);

		Esquina esquinaFutura = unMapa.dameEsquina(new Posicion(5, 5));
		esquinaFutura.colocarAuto(unAuto);
		assertTrue(esquinaFutura.devolverPosicion().equals(
				unAuto.devolverEsquina().devolverPosicion()));
	}

	@Test
	public void testDeberiaNoSerVisibleAlCrearse() {
		Posicion unaPosicion = new Posicion(3, 3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		assertFalse(unaEsquina.devolverVisibilidad());
	}

	@Test
	public void testDeberiaPoderColocarUnObstaculo() {
		Posicion unaPosicion = new Posicion(3, 3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Pozo unPozo = new Pozo();

		unaEsquina.colocarObstaculo(unPozo);

		assertTrue(unaEsquina.getObstaculo() == unPozo);
	}

}
