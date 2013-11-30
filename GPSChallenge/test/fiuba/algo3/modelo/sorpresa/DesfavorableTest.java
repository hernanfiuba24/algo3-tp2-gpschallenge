package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.JugadorTesteador;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;


public class DesfavorableTest {

	@Test
	public void testDeberiaIncrementarDosMovimientoCuandoElJugadorSeMovio8vecesYEncuentraUnaSorpresaDesfavorableEnElUltimoMovimiento() throws ExcepcionEsquinaInvalida {
		JugadorTesteador jugador = new JugadorTesteador();
        jugador.movimientosHechos = 8;
        Desfavorable unaSorpresaDesfavorable = new Desfavorable();
        unaSorpresaDesfavorable.aplicar(jugador);
        
		assertTrue(jugador.devolverMovimientosHechos() == (8 * 1.25));
	}
}
