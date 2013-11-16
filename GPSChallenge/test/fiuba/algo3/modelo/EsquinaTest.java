package fiuba.algo3.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class EsquinaTest {
	
	Posicion unaPosicion = new Posicion(3, 3);
	Esquina unaEsquina = new Esquina(unaPosicion);
	
	@Test
	public void testDeberiaColocarUnAutoEnUnaEsquina() {
		Auto unAuto = new Auto(unaEsquina);
		unaEsquina.colocarVehiculo(unAuto);
		assertTrue(unaEsquina.devolverPosicion().equals(
				unAuto.devolverEsquina().devolverPosicion()));
	}

	@Test
	public void testDeberiaNoSerVisibleAlCrearse() {
		assertFalse(unaEsquina.devolverVisibilidad());
	}
	
	@Test 
	public void testDeberiaTenerUnaPosicionAlCrearse() {
		assertTrue(unaEsquina.devolverPosicion() == unaPosicion);
		
	}
	
	@Test
	public void testDeberiaEncenderLaVisibilidad() {
		unaEsquina.encenderVisibilidad();
		assertTrue(unaEsquina.devolverVisibilidad());
	}
	
	@Test
	public void testDeberiaApagarLaVisibilidad() {
		unaEsquina.apagarVisibilidad();
		assertFalse(unaEsquina.devolverVisibilidad());
	}

	@Test
	public void testDeberiaBorrarUnVehiculo() {
		unaEsquina.borrarVehiculo();
		assertTrue(unaEsquina.devolverVehiculo()== null);
	}
	
	@Test
	public void testDeberiaPoderColocarUnObstaculo() {
		Pozo unPozo = new Pozo();
        unaEsquina.colocarObstaculo(unPozo);
		assertTrue(unaEsquina.devolverObstaculo() == unPozo);
	}
	
	@Test
	public void testDeberiaPoderColocarUnaSorpresa() {
		Favorable unaSorpresaFavorable = new Favorable();
		unaEsquina.colocarSorpresa(unaSorpresaFavorable);
		assertTrue(unaEsquina.devolverSorpresa() == unaSorpresaFavorable);
	}

	@Test
	public void testDeberiaDevolverPosicionesAdyacentesConUnRadio() {
		int radio = 2;
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
