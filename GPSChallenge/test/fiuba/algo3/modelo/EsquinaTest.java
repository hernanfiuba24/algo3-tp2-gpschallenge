package fiuba.algo3.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class EsquinaTest {

	@Test
	public void testDeberiaColocarUnAutoEnUnaEsquina() {
		Esquina esquinaFutura = new Esquina(new Posicion(5, 5));
		Auto unAuto = new Auto(esquinaFutura);
		esquinaFutura.colocarVehiculo(unAuto);
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

		assertTrue(unaEsquina.devolverObstaculo() == unPozo);
	}
	
	@Test
	public void testDeberiaPoderColocarUnaSorpresa() {
		Posicion unaPosicion = new Posicion(3, 3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Favorable unaSorpresaFavorable = new Favorable();

		unaEsquina.colocarSorpresa(unaSorpresaFavorable);

		assertTrue(unaEsquina.devolverSorpresa() == unaSorpresaFavorable);
	}

	@Test
	public void testDeberiaDevolverPosicionesAdyacentesConUnRadio() {
		int radio = 2;
		Esquina unaEsquina = new Esquina(new Posicion(3, 4));
		ArrayList<Posicion> unaListaDePosiciones = unaEsquina
				.devolverPosicionesADistanciaDeRadio(radio);
		int indice = 0;
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				assertTrue(unaListaDePosiciones.get(indice).equals(
						new Posicion(unaEsquina.devolverPosicion()
								.devolverPosicionFila() + i, unaEsquina
								.devolverPosicion().devolverPosicionColumna()
								+ j)));
				indice++;
			}
		}

	}
}
