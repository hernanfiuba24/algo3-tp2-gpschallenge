package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void testJuegoDeberiaExistir() {
		Juego unJuego = new Juego();
		assertTrue(unJuego instanceof Juego);
	}
	
	@Test
	public void testJuegoDeberiaCrearseConMapaJugadorYRadar(){
		Mapa unMapa = new Mapa(7,7);
		Jugador unJugador = new Jugador();
		Radar unRadar = new Radar(unMapa);
		Juego unJuego = new Juego(unMapa,unJugador,unRadar);
		assertTrue(unJuego.dameMapa() == unMapa);
		assertTrue(unJuego.dameJugador() == unJugador);
		assertTrue(unJuego.dameRadar() == unRadar);
	}

}
