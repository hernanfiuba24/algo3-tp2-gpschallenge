package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
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
	public void testDeberiaIncrementarDosMovimientoCuandoElJugadorSeMovio8vecesYEncuentraUnaSorpresaDesfavorableEnElUltimoMovimiento() {
		Mapa unMapa = new Mapa(20, 20);
		Desfavorable unaSorpresaDesfavorable = new Desfavorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(new Posicion(1, 4));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaDesfavorable);
		Jugador unJugador = new Jugador(new Auto(
				unMapa.dameEsquina(new Posicion(9, 4))));
		unJugador.setDireccion(new Arriba());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == (8 + (8 * 25 / 100)));
	}
}
