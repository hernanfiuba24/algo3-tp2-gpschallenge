package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class FavorableTest {

	@Test
	public void testDeberiaDescontarUnMovimientoCuandoElJugadorSeMovio5VecesYEncuentraUnaSorpresaFavorableEnElUltimoMovimiento() {
		Mapa unMapa = new Mapa(8, 8);
		Favorable unaSorpresaFavorable = new Favorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(new Posicion(3, 4));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaFavorable);
		
		Esquina esquinaInicialAuto = unMapa.dameEsquina(new Posicion(8, 4));
		Auto unAuto = new Auto(esquinaInicialAuto);
		Jugador unJugador = new Jugador(unAuto);
		
		unJugador.setDireccion(new Arriba());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);	
		
		assertTrue(unJugador.devolverMovimientosHechos() == (5-(5*20/100)));
	}

}
