package fiuba.algo3.modelo.obstaculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class PiqueteTest {

	@Test
	public void testDeberiaCambiarleLaDireccionAlAuto() {
		Esquina unaEsquinaConAutoYPiquete = new Esquina(new Posicion(3,3));
		
		Auto unAuto = new Auto(unaEsquinaConAutoYPiquete);
		Jugador unJugador = new Jugador(unAuto);
		unJugador.cambiarDireccion(new Derecha());
		
		Piquete unPiquete = new Piquete(unaEsquinaConAutoYPiquete);
		unPiquete.aplicar(unAuto);

		assertTrue(unJugador.devolverDireccion() instanceof Izquierda);
	}

	@Test
	public void testDeberiaCambiarleLaDireccionALaCamioneta() {
		Esquina unaEsquinaConCamionetaYPiquete = new Esquina(new Posicion(3,3));
		
		Camioneta unaCamioneta = new Camioneta(unaEsquinaConCamionetaYPiquete);
		Jugador unJugador = new Jugador(unaCamioneta);
		unJugador.cambiarDireccion(new Arriba());
		
		Piquete unPiquete = new Piquete(unaEsquinaConCamionetaYPiquete);
		unPiquete.aplicar(unaCamioneta);

		assertTrue(unJugador.devolverDireccion() instanceof Abajo);
	}

	@Test
	public void testNoDeberiaCambiarleLaDireccionALaMoto() {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3,3));
		
		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		Jugador unJugador = new Jugador(unaMoto);
		unJugador.cambiarDireccion(new Abajo());
		
		Piquete unPiquete = new Piquete(unaEsquinaConMotoYPiquete);
		unPiquete.aplicar(unaMoto);
		
		assertTrue(unJugador.devolverDireccion() instanceof Abajo);
	}

	@Test
	public void testDeberiaAumentarleLosMovimientosALaMoto() {
		Esquina unaEsquinaConMotoYPiquete = new Esquina(new Posicion(3,3));
		
		Moto unaMoto = new Moto(unaEsquinaConMotoYPiquete);
		Jugador unJugador = new Jugador(unaMoto);
		unJugador.cambiarDireccion(new Abajo());
		
		Piquete unPiquete = new Piquete(unaEsquinaConMotoYPiquete);	
		unPiquete.aplicar(unaMoto);

		assertTrue(unJugador.devolverMovimientosHechos() == 2);
	}
}