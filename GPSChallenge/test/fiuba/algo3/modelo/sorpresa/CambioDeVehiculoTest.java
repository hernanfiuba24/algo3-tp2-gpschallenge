package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class CambioDeVehiculoTest {

	@Test
	public void testDesfavorableDeberiaExistir() {
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		assertTrue(unCambioDeVehiculo instanceof CambioDeVehiculo);
	}
	
	@Test
	public void testDeberiaCambiarDeAutoACamioneta(){
		Mapa unMapa = new Mapa(12, 12);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		CambioDeVehiculo unaSorpresaCambioDeVehiculo = new CambioDeVehiculo();
		unMapa.dameEsquina(new Posicion(5,3)).colocarSorpresa(unaSorpresaCambioDeVehiculo);
		unJugador.setDireccion(new Abajo());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverVehiculo() instanceof Camioneta);
		
	}
	
	@Test
	public void testDeberiaCambiarDeMotoAAuto(){
		Mapa unMapa = new Mapa(12, 12);
		Moto unaMoto = new Moto(unMapa);
		Jugador unJugador = new Jugador(unaMoto);
		CambioDeVehiculo unaSorpresaCambioDeVehiculo = new CambioDeVehiculo();
		unMapa.dameEsquina(new Posicion(5,3)).colocarSorpresa(unaSorpresaCambioDeVehiculo);
		unJugador.setDireccion(new Abajo());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverVehiculo() instanceof Auto);
		
	}
	
	@Test
	public void testDeberiaCambiarDeCamionetaAMoto(){
		Mapa unMapa = new Mapa(12, 12);
		Camioneta unaCamioneta = new Camioneta(unMapa);
		Jugador unJugador = new Jugador(unaCamioneta);
		CambioDeVehiculo unaSorpresaCambioDeVehiculo = new CambioDeVehiculo();
		unMapa.dameEsquina(new Posicion(5,3)).colocarSorpresa(unaSorpresaCambioDeVehiculo);
		unJugador.setDireccion(new Abajo());
		
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverVehiculo() instanceof Moto);
		
	}

}
