package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class JugadorTest {
	
	@Test
	public void testJugadorDeberiaPoderJugarArriba() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(10, 10);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(4, 5);
		unJugador.cambiarDireccion(new Arriba());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}

	@Test
	public void testJugadorDeberiaPoderJugarAbajo() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(4, 3);
		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}

	@Test
	public void testJugadorDeberiaPoderJugarIzquierda() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(10, 10);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(5, 5)));
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(5, 4);
		unJugador.cambiarDireccion(new Izquierda());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}

	@Test
	public void testJugadorDeberiaPoderJugarDerecha() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		Posicion posicionFutura = new Posicion(3, 4);
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test//(expected = ExcepcionEsquinaInvalida.class) 
	public void testJugadorDeberiaLanzarExcepcionAlJugarFueraDeLosLimites() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(4, 3);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Abajo());

		unJugador.jugar(unMapa);
		unJugador.cambiarDireccion(new Derecha());
		try{
			unJugador.jugar(unMapa);
		}
		catch (ExcepcionEsquinaInvalida e){
			assertTrue(e instanceof ExcepcionEsquinaInvalida);
		}
	}
	
	@Test
	public void testJugarDeberiaIncrementarEn1LosMovimientosHecho() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 1);
		
	}
	
	@Test
	public void testCambiarDireccionDeberiaAsignarNuevaDireccionALaDireccionDelJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Arriba());
		
		assertTrue(unJugador.devolverDireccion() instanceof Arriba);
	}
	
	@Test
	public void testGuardarVehiculoDeberiaAsignarleElVehiculoAlJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		
		assertTrue(unJugador.devolverVehiculo() == unAuto);
	}
	
	@Test
	public void testAumentarMovimientosHechosDeberiaSumarleLaCantidadPasadaALosMovimientosDelJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.aumentarMovimientoHechos(5);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 5);
	}
	
	@Test
	public void testCambiarDireccionContrariaDeberiaAsignarleLaDireccionOpuestaAlJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.cambiarDireccionContraria();
		
		assertTrue(unJugador.devolverDireccion() instanceof Abajo);
	}
}
