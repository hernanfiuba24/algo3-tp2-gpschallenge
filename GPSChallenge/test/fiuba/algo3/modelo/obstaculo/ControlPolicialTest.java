package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicialTest {

	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosAlAuto() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {
		
		RandomizadorTesteador unRandomizadorTest = new RandomizadorTesteador();
		unRandomizadorTest.numeroRandomADevolver(0.5);
				
		ControlPolicial control = new ControlPolicial(unRandomizadorTest);
		
		Mapa unMapa = new Mapa(20, 20);
		Auto unAuto = new Auto(unMapa.devolverUnaEsquina(new Posicion(10, 10)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unAuto, null);

		Esquina esquinaConControl = unMapa.devolverUnaEsquina(new Posicion(10, 11));
		esquinaConControl.setearObstaculo(control);

		unJugador.cambiarDireccion(new Derecha());
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 4);
	

	}

	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosALaMoto() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {
		
		RandomizadorTesteador unRandomizadorTest = new RandomizadorTesteador();
		unRandomizadorTest.numeroRandomADevolver(0.8);
		
		ControlPolicial control = new ControlPolicial(unRandomizadorTest);
				
		Mapa unMapa = new Mapa(20, 20);
		Moto unaMoto = new Moto(unMapa.devolverUnaEsquina(new Posicion(10, 10)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);

		Esquina esquinaConControl = unMapa.devolverUnaEsquina(new Posicion(8,
				10));
		esquinaConControl.setearObstaculo(control);

		unJugador.cambiarDireccion(new Arriba());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 5);
	
	}
	
	@Test
	public void testControlPolicialNoDeberiaSumarle3MovimientosALaMoto() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {
		
		RandomizadorTesteador unRandomizadorTest = new RandomizadorTesteador();
		unRandomizadorTest.numeroRandomADevolver(0.9);
		
		ControlPolicial control = new ControlPolicial(unRandomizadorTest);
				
		Mapa unMapa = new Mapa(20, 20);
		Moto unaMoto = new Moto(unMapa.devolverUnaEsquina(new Posicion(10, 10)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaMoto, null);

		Esquina esquinaConControl = unMapa.devolverUnaEsquina(new Posicion(8,
				10));
		esquinaConControl.setearObstaculo(control);

		unJugador.cambiarDireccion(new Arriba());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);
	
	}

	@Test
	public void testControlPolicialDeberiaSumarle3MovimientosALaCamioneta() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {		
		
		RandomizadorTesteador unRandomizadorTest = new RandomizadorTesteador();
		unRandomizadorTest.numeroRandomADevolver(0.3);
		
		ControlPolicial control = new ControlPolicial(unRandomizadorTest);
		
		Mapa unMapa = new Mapa(20, 20);
		Camioneta unaCamioneta = new Camioneta(
				unMapa.devolverUnaEsquina(new Posicion(10, 10)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaCamioneta, null);

		Esquina esquinaConControl = unMapa.devolverUnaEsquina(new Posicion(13,
				10));
		esquinaConControl.setearObstaculo(control);

		unJugador.cambiarDireccion(new Abajo());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 6);

	}
	
	@Test
	public void testControlPolicialNoDeberiaSumarle3MovimientosALaCamioneta() throws ExcepcionEsquinaInvalida, ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {		
		
		RandomizadorTesteador unRandomizadorTest = new RandomizadorTesteador();
		unRandomizadorTest.numeroRandomADevolver(0.7);
		
		ControlPolicial control = new ControlPolicial(unRandomizadorTest);
		
		Mapa unMapa = new Mapa(20, 20);
		Camioneta unaCamioneta = new Camioneta(
				unMapa.devolverUnaEsquina(new Posicion(10, 10)));
		JugadorImplementacion unJugador = new JugadorImplementacion(unaCamioneta, null);

		Esquina esquinaConControl = unMapa.devolverUnaEsquina(new Posicion(13,
				10));
		esquinaConControl.setearObstaculo(control);

		unJugador.cambiarDireccion(new Abajo());
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);
		unJugador.jugar(unMapa);

		assertTrue(unJugador.devolverMovimientosHechos() == 3);

	}

}
