package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class FavorableTest {

	@Test
	public void testDeberiaDescontarMovimiento() {
		Mapa unMapa = new Mapa(8, 8);
		Favorable unaSorpresaFavorable = new Favorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(5, 4);
		esquinaConSorpresa.colocarSorpresa(unaSorpresaFavorable);
		Jugador unJugador = new Jugador(new Auto(unMapa.dameEsquina(8, 4)));
		unJugador.jugarArriba(unMapa);
		unJugador.jugarArriba(unMapa);
		unJugador.jugarArriba(unMapa);
		assertTrue(unJugador.devolverMovimientosHechos() == (3-(3*20/100)));
	}

}
