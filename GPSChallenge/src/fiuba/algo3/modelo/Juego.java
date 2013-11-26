package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.obstaculo.RandomizadorImplementacion;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public class Juego extends Observado {

	private Mapa unMapa;
	private Jugador unJugador;

	public Juego() throws ExcepcionEsquinaInvalida {
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa));
		unMapa.devolverUnaEsquina(new Posicion(5,5)).setearObstaculo(new Pozo());
		unMapa.devolverUnaEsquina(new Posicion(6,3)).setearObstaculo(new ControlPolicial(new RandomizadorImplementacion()));
		unMapa.devolverUnaEsquina(new Posicion(2,1)).setearSorpresa(new CambioDeVehiculo());;
		unMapa.devolverUnaEsquina(new Posicion(3,4)).setearSorpresa(new Desfavorable());
		unMapa.devolverUnaEsquina(new Posicion(7,4)).setearSorpresa(new Favorable());
		unMapa.devolverUnaEsquina(new Posicion(8,2)).setearObstaculo(new Piquete(new Esquina(new Posicion(8,1))));
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina().devolverPosicion());		
	}

	public Mapa devolverMapa() {
		return this.unMapa;
	}

	public Jugador devolverJugador() {
		return this.unJugador;
	}

	public int devolverMapaFila() {
		return this.unMapa.devolverFilas();
	}
	
	public int devolverMapaColumna(){
		return this.unMapa.devolverColumnas();
	}

	public void moverJugadorEnDireccion(Direccion unaDireccion) {
		this.unJugador.cambiarDireccion(unaDireccion);
	}

	public void setearPosicionInicial() throws ExcepcionEsquinaInvalida {
		this.unJugador.devolverVehiculo().setearEsquina(unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina().devolverPosicion());
	}	
	
	public void jugar(Direccion unaDireccion) {
		this.unJugador.cambiarDireccion(unaDireccion);
		try {
			this.unJugador.jugar(unMapa);
			setChanged();
			notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina().devolverPosicion());
		} catch (ExcepcionEsquinaInvalida e1) {
		}
	}
}
