package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class DesfavorableTest {

	@Test
	public void testDesfavorableDeberiaExistir() {
		Desfavorable unaDesfavorable = new Desfavorable();
		assertTrue(unaDesfavorable instanceof Desfavorable);
	}
	
	@Test
	public void testDeberiaIncrementarMovimiento() {
		Mapa unMapa = new Mapa(8, 8);
		Desfavorable unaSorpresaDesfavorable = new Desfavorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(new Posicion(5, 4));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaDesfavorable);
		Jugador unJugador = new Jugador(new Auto(
				unMapa.dameEsquina(new Posicion(8, 4))));
		unJugador.setDireccion(new Arriba());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		assertTrue(unJugador.devolverMovimientosHechos() == (3 + (3 * 25 / 100)));
	}
}
