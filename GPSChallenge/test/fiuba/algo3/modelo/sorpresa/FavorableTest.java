package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class FavorableTest {
	
	@Test
	public void testFavorableDeberiaExistir() {
		Favorable unaSorpresaFavorable = new Favorable();
		assertTrue(unaSorpresaFavorable instanceof Favorable);
	}

	@Test
	public void testDeberiaDescontarUnMovimientoCuandoElJugadorSeMovio5VecesYEncuentraUnaSorpresaFavorableEnElUltimoMovimiento() {
		Mapa unMapa = new Mapa(15, 15);
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
