package fiuba.algo3.modelo;

import javax.swing.JOptionPane;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class Juego extends Observado {

	private Mapa unMapa;
	private Jugador unJugador;

	public Juego() throws ExcepcionEsquinaInvalida {
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa));
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
