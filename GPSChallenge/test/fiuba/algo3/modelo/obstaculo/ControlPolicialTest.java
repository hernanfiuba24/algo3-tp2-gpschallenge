package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicialTest {

	@Test
	public void testControlPolicialDeberiaExistir() {
		ControlPolicial control = new ControlPolicial();
		assertTrue(control instanceof ControlPolicial);
	}
	
	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosAlAuto() {
		ControlPolicial control = new ControlPolicial();
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa.dameEsquina(new Posicion(10, 10)));
		Jugador unJugador = new Jugador(unAuto);

		Esquina esquinaConControl = unMapa.dameEsquina(new Posicion(10, 11));
		esquinaConControl.colocarObstaculo(control);

		unJugador.setDireccion(new Derecha());
		unJugador.jugar(unMapa);

		if(control.obtenerProbabilidad() <= 0.5){
			assertTrue(unJugador.devolverMovimientosHechos() == 4);
		}else{
			assertTrue(unJugador.devolverMovimientosHechos() == 1);		
		}
			
	}

	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosALaMoto() {
		ControlPolicial control = new ControlPolicial();
		Mapa unMapa = new Mapa(20, 20);
		Moto unaMoto = new Moto(unMapa.dameEsquina(new Posicion(10, 10)));
		Jugador unJugador = new Jugador(unaMoto);

		Esquina esquinaConControl = unMapa.dameEsquina(new Posicion(8, 10));
		esquinaConControl.colocarObstaculo(control);

		unJugador.setDireccion(new Arriba());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		if(control.obtenerProbabilidad() <= 0.8){
			assertTrue(unJugador.devolverMovimientosHechos() == 5);
		}else{
			assertTrue(unJugador.devolverMovimientosHechos() == 2);		
		}		
		
	}

	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosALaCamioneta() {
		ControlPolicial control = new ControlPolicial();
		Mapa unMapa = new Mapa(20, 20);
		Camioneta unaCamioneta = new Camioneta(unMapa.dameEsquina(new Posicion(
				10, 10)));
		Jugador unJugador = new Jugador(unaCamioneta);

		Esquina esquinaConControl = unMapa.dameEsquina(new Posicion(13, 10));
		esquinaConControl.colocarObstaculo(control);

		unJugador.setDireccion(new Abajo());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		if(control.obtenerProbabilidad() <= 0.3){
			assertTrue(unJugador.devolverMovimientosHechos() == 6);
		}else{
			assertTrue(unJugador.devolverMovimientosHechos() == 3);		
		}

	}

}
