package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class JugadorTest {

	
	@Test
	public void testJugadorDeberiaTenerNombre() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto,"Raul");	
		
		assertTrue(unJugador.devolverNombre() == "Raul");
	}
	
	@Test
	public void testJugadorDeberiaPoderJugarArriba() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(10, 10);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(5, 5)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto,"Raul" );
		Posicion posicionFutura = new Posicion(4, 5);
		unJugador.cambiarDireccion(new Arriba());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}

	@Test
	public void testJugadorDeberiaPoderJugarAbajo() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
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
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		Posicion posicionFutura = new Posicion(5, 4);
		unJugador.cambiarDireccion(new Izquierda());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}

	@Test
	public void testJugadorDeberiaPoderJugarDerecha() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		Posicion posicionFutura = new Posicion(3, 4);
		unJugador.cambiarDireccion(new Derecha());

		unJugador.jugar(unMapa);

		assertTrue(unAuto.devolverEsquina().devolverPosicion()
				.equals(posicionFutura));
	}
	
	@Test//(expected = ExcepcionEsquinaInvalida.class) 
	public void testJugadorDeberiaLanzarExcepcionAlJugarFueraDeLosLimites() throws ExcepcionEsquinaInvalida {

		Mapa unMapa = new Mapa(4, 3);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
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
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 1);
		
	}
	
	@Test
	public void testCambiarDireccionDeberiaAsignarNuevaDireccionALaDireccionDelJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		unJugador.cambiarDireccion(new Arriba());
		
		assertTrue(unJugador.devolverDireccion() instanceof Arriba);
	}
	
	@Test
	public void testGuardarVehiculoDeberiaAsignarleElVehiculoAlJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		
		assertTrue(unJugador.devolverVehiculo() == unAuto);
	}
	
	@Test
	public void testAumentarMovimientosHechosDeberiaSumarleLaCantidadPasadaALosMovimientosDelJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		unJugador.aumentarMovimientoHechos(5);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 5);
	}
	
	@Test
	public void testCambiarDireccionContrariaDeberiaAsignarleLaDireccionOpuestaAlJugador() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(8, 8);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.cambiarDireccionContraria();
		
		assertTrue(unJugador.devolverDireccion() instanceof Abajo);
	}
	
	@Test
	public void testUnAutoDeberiaEncontrarseConUnaSorpresaFavorableYUnPozo() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, "Raul");
		
		Pozo unPozo = new Pozo();
		Favorable unaSorpresaFavorable = new Favorable();
		
		Esquina unaEsquinaConSorpresaYObstaculo = unMapa.devolverUnaEsquina(new Posicion(2,3));
		unaEsquinaConSorpresaYObstaculo.setearObstaculo(unPozo);
		unaEsquinaConSorpresaYObstaculo.setearSorpresa(unaSorpresaFavorable);
		
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 4);		
		
	}
	
	@Test
	public void testUnaCamionetaDeberiaEncontrarseConUnaSorpresaCambioDeVehiculoYAlCambiarAMotoDebeSumarleMovimientosUnPiquete() throws ExcepcionEsquinaInvalida{
		Mapa unMapa = new Mapa(20, 20);
		Camioneta unaCamioneta = new Camioneta(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		
		JugadorImplementacion unJugador = new JugadorImplementacion(unaCamioneta, "Raul");
		
		Piquete unPiquete = new Piquete();
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		
		Esquina unaEsquinaConSorpresaYObstaculo = unMapa.devolverUnaEsquina(new Posicion(2,3));
		unaEsquinaConSorpresaYObstaculo.setearObstaculo(unPiquete);
		unaEsquinaConSorpresaYObstaculo.setearSorpresa(unCambioDeVehiculo);
		
		unJugador.cambiarDireccion(new Arriba());
		
		unJugador.jugar(unMapa);
		
		assertTrue(unJugador.devolverMovimientosHechos() == 3);
		assertTrue(unJugador.devolverVehiculo() instanceof Moto);
	}
}
