package fiuba.algo3.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class ControladorJuego implements Observer {
	
	private Juego GPSChallenge;
	
	public ControladorJuego(Juego unGPSChallenge){
		this.GPSChallenge = unGPSChallenge;
	}
	
	private class EscuchaBotonDerecha implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.devolverJugador().cambiarDireccion(new Derecha());
			try {
				GPSChallenge.devolverJugador().jugar(GPSChallenge.devolverMapa());
			} catch (ExcepcionEsquinaInvalida e1) {
			}
		}
	}
	
	public ActionListener getListenerBotonDerecha() {
		return new EscuchaBotonDerecha();
	}
	
	private class EscuchaBotonArriba implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.devolverJugador().cambiarDireccion(new Arriba());
			try {
				GPSChallenge.devolverJugador().jugar(GPSChallenge.devolverMapa());
			} catch (ExcepcionEsquinaInvalida e1) {
			}
		}
	}
	
	public ActionListener getListenerBotonArriba() {
		return new EscuchaBotonArriba();
	}
	
	private class EscuchaBotonIzquierda implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.devolverJugador().cambiarDireccion(new Izquierda());
			try {
				GPSChallenge.devolverJugador().jugar(GPSChallenge.devolverMapa());
			} catch (ExcepcionEsquinaInvalida e1) {
			}
		}
	}
	
	public ActionListener getListenerBotonIzquierda() {
		return new EscuchaBotonIzquierda();
	}
	
	private class EscuchaBotonAbajo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.devolverJugador().cambiarDireccion(new Abajo());
			try {
				GPSChallenge.devolverJugador().jugar(GPSChallenge.devolverMapa());
			} catch (ExcepcionEsquinaInvalida e1) {
			}
		}
	}
	
	public ActionListener getListenerBotonAbajo() {
		return new EscuchaBotonAbajo();
	}

	public int devolverDimensionMapaFila() {
		int dimensionFila = this.GPSChallenge.devolverMapaFila();
		return dimensionFila;
	}
	
	public int devolverDimensionMapaColumna(){
		int dimensionColumna = this.GPSChallenge.devolverMapaColumna();
		return dimensionColumna;
	}

	@Override
	public void update(Observable o, Object arg) {
				
	}
	
}
