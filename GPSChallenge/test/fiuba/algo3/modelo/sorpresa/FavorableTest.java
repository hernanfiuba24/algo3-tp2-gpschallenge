package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;
import fiuba.algo3.modelo.JugadorTesteador;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.sorpresa.Favorable;

public class FavorableTest {

	@Test
	public void testDeberiaDescontarUnMovimientoCuandoElJugadorSeMovio5VecesYEncuentraUnaSorpresaFavorableEnElUltimoMovimiento() throws ExcepcionEsquinaInvalida {
		JugadorTesteador jugador = new JugadorTesteador();
        jugador.movimientosHechos = 5;
        Favorable unaSorpresaFavorable = new Favorable();
        unaSorpresaFavorable.aplicar(jugador);
       
		assertTrue(jugador.devolverMovimientosHechos() == 5 * 0.80);
	}

}
