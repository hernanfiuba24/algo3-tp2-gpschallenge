package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Derecha;
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
		Mapa unMapa = new Mapa(12, 12);
		Desfavorable unaSorpresaDesfavorable = new Desfavorable();
		Esquina esquinaConSorpresa = unMapa.dameEsquina(new Posicion(5, 3));
		esquinaConSorpresa.colocarSorpresa(unaSorpresaDesfavorable);
		Jugador unJugador = new Jugador(new Auto(unMapa));
		
		unJugador.setDireccion(new Derecha());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == (2 + (2 * 25 / 100)));
	}
}
