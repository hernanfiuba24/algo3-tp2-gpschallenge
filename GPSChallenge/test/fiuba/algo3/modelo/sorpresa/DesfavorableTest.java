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
	public void testDeberiaIncrementarDosMovimientoCuandoElJugadorSeMovio8vecesYEncuentraUnaSorpresaDesfavorableEnElUltimoMovimiento() {
		Mapa unMapa = new Mapa(20, 20);
		Desfavorable unaSorpresaDesfavorable = new Desfavorable();
		Esquina esquinaConSorpresa = unMapa.devolverUnaEsquina(new Posicion(3,
				4));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaDesfavorable);
		Jugador unJugador = new Jugador(new Auto(
				unMapa.devolverUnaEsquina(new Posicion(11, 4))));
		unJugador.cambiarDireccion(new Arriba());
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
