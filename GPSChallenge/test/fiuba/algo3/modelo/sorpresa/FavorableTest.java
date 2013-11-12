package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class FavorableTest {

	@Test
	public void testDeberiaDescontarUnMovimientoCuandoElJugadorSeMovio5VecesYEncuentraUnaSorpresaFavorableEnElUltimoMovimiento() {
		Mapa unMapa = new Mapa(12, 12);
		Favorable unaSorpresaFavorable = new Favorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(new Posicion(8,3));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaFavorable);
	
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		
		unJugador.setDireccion(new Abajo());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);	
		
		assertTrue(unJugador.devolverMovimientosHechos() == (5-(5*20/100)));
	}

}
